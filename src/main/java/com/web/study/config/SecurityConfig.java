package com.web.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.web.study.security.jwt.JwtAuthenticationEntryPoint;
import com.web.study.security.jwt.JwtAuthenticationFilter;
import com.web.study.security.jwt.JwtTokenProvider;

import ch.qos.logback.classic.pattern.EnsureExceptionHandling;
import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private final JwtTokenProvider jwtTokenProvider;
	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// security filter
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.httpBasic().disable(); // 웹 기본 인증 방식
		http.formLogin().disable(); // 폼태그를 통한 로그인
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 세션 비활성
		http.authorizeRequests()
			.antMatchers("/auth/register/**", "/auth/login/**") // security Context가 없어도됨.
			.permitAll()
			.antMatchers("/courses")
			.hasRole("ADMIN")
			.anyRequest() // security Context가 있어야됨.
			.authenticated() // security Context뿐만 아니라 authenticate 값도 있어야됨. 인증하는 과정
			.and()
			.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class) //UsernamePasswordAuthenticationFilter(사용자 인증 필터) 고정임!
			.exceptionHandling()
			.authenticationEntryPoint(jwtAuthenticationEntryPoint);
	}
}
