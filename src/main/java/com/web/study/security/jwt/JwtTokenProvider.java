package com.web.study.security.jwt;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.web.study.dto.response.auth.JwtTokenRespDto;
import com.web.study.exception.CustomException;
import com.web.study.security.PrincipalUserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtTokenProvider {
	
	// 이게 핵심임
	private final Key key;
	
	// 키 객체를 만들어주는 과정이다. 
	public JwtTokenProvider(@Value("${jwt.secretKey}") String secretKey) {
		// 암호화하는 방법이라고 생각하면됨.
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		this.key = Keys.hmacShaKeyFor(keyBytes);
	}
	
	// 토큰을 생성해줄 때 사용함.
	public JwtTokenRespDto createToken(Authentication authentication) {
		StringBuilder authoritiesBuilder = new StringBuilder();
		
		authentication.getAuthorities().forEach(grantedAuthority -> {
			authoritiesBuilder.append(grantedAuthority.getAuthority());
			authoritiesBuilder.append(",");
		});
		
		// 마지막 쉼표 지우기
		authoritiesBuilder.delete(authoritiesBuilder.length() - 1, authoritiesBuilder.length());
		
		String authorities = authoritiesBuilder.toString();
		
		// 초까지하면 숫자가 너무 커져서 long으로 해줌.
		long now = (new Date()).getTime();
		// 1000 == 1초
		Date tokenExpiresDate = new Date(now + (1000 * 60 * 30)); // 토큰 만료 시간
		
		PrincipalUserDetails userDetails = (PrincipalUserDetails) authentication.getPrincipal();
		
		// 사용자를 식별할때 필요한 것들만 골라서 넣어주면 됨.
		String accessToken = Jwts.builder()
				// authentication의 하위에 UserDetails안에 getUserName의 값이 authentication의 getName값에 대입됨.
				.setSubject(authentication.getName())
				.claim("userId", userDetails.getUserId())
				.claim("auth", authorities)
				.setExpiration(tokenExpiresDate)
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
		
		return JwtTokenRespDto.builder()
				.grantType("Bearer")
				.accessToken(accessToken)
				.build();
	}
	
	// 토큰을 검증하는 것
	public boolean validateToken(String token) {
		try {
			// 토큰이 어떤 토큰인지 자동으로 알아봐주는 라이브러리이다.
			Jwts.parserBuilder()
			.setSigningKey(key)
			.build()
			.parseClaimsJws(token);
			// 무조건 Jws로 해줘야함 이거 많이 했갈림! 오류도 잘안뜸.
			return true;
		} catch (SecurityException | MalformedJwtException e) {
			// Security라이브러리에 오류가 있거나, JSON의 포맷이 잘못된 JWT가 들어왔을 때 예외
			// SignatureException이 포함되어 있음
			log.info("Invalid JWT Token", e);
		} catch (ExpiredJwtException e) {
			// 토큰의 유효기간이 만료된 경우 예외
			log.info("Expired JWT Token", e);
		} catch (UnsupportedJwtException e) {
			// jwt의 형식을 지키지 않은 경우 (Header.Payload.Signature)
			log.info("Unsupported JWT Token", e);
		} catch (IllegalArgumentException e) {
			// JWT토큰이 없을 때
			log.info("IllegalArgument JWT Token", e);
		} catch (Exception e) {
			log.info("JWT Token Error", e);
		}
		return false;
	}
	
	// 토큰을 검증한 것을 Authentication 변환해주는 것
	public Authentication getAuthentication(String accessToken) {
		Claims claims = parseClaims(accessToken);
		Object roles = claims.get("auth");
		
		// 권한은 무조건 있어야 하므로 조건을 준것이다. (회원가입때부터 잘못된 녀석을 걸러냄!)
		if(roles == null) {
			throw new CustomException("권한 정보가 없는 토큰입니다.");
		}
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		String[] rolesArray = roles.toString().split(",");
		
		Arrays.asList(rolesArray).forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role));
		});
		
		// spring에서 기본적으로 지원해주는 User를 생성해준다.
		                                  // username         password  권한
		UserDetails userDetails = new User(claims.getSubject(), "", authorities);
		                                            // 유저객체, 인증관련(생략가능), 권한
		return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
		// 임시의 Authentication를 생성해서 리턴해준다. ->Authentication으로 업케스팅 되서 들억마
	}
	
	
	private Claims parseClaims(String accessToken) {
		try {
			return Jwts.parserBuilder()
					.setSigningKey(key)
					.build()
					.parseClaimsJws(accessToken)
					// payload에 해당함!
					.getBody();
		} catch (ExpiredJwtException e) {
			// 형식상 넣어주는 거임.
			return e.getClaims();
		}
	}

}
