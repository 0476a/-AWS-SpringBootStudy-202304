package com.web.study.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean{
	
	private final JwtTokenProvider jwtTokenProvider;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) // chain은 필터 다음에 실행할 녀석
			throws IOException, ServletException {
		
		String token = getToken(request);
//		System.out.println("token: " + token);
		
		boolean validatitonFlag = jwtTokenProvider.validateToken(token);
//		System.out.println("flag: " + validatitonFlag);
		
		// ture이면 실행됨.
		if(validatitonFlag) {
			// 생성된 UsernamePasswordAuthenticationToken을 받아서 Authentication에 넣어준다.
			Authentication authentication = jwtTokenProvider.getAuthentication(token);
			// 최종적이로 이게 되야 인증이 된것이다.
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		
		chain.doFilter(request, response);
	}
	
	private String getToken(ServletRequest request) {
		// getHeader를 사용하려면 다운케스팅 해줘야함!
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String type = "Bearer";
		// header에서 값을 가져온다.
		String token = httpServletRequest.getHeader("Authorization");
		
		//hasText 문자열이 Null, 공백이 아닌지 확인, 앞에 Bearer가 있는 것을 확인한다.
		if(StringUtils.hasText(token) && token.startsWith(type)) {
			// Bearer을 잘라준다.
			return token.substring(type.length() + 1);
		}
		
		return null;
	}

}
