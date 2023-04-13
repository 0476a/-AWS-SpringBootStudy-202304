package com.web.study.security.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.web.study.dto.response.auth.JwtTokenRespDto;
import com.web.study.security.PrincipalUserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
	
	private final Key key;
	
	// 키 객체를 만들어주는 과정이다. 
	public JwtTokenProvider(@Value("${jwt.secretKey}") String secretKey) {
		// 암호화하는 방법이라고 생각하면됨.
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		this.key = Keys.hmacShaKeyFor(keyBytes);
	}
	
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

}
