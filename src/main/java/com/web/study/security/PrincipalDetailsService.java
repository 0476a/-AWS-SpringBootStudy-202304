package com.web.study.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.study.domain.entity.User;
import com.web.study.exception.CustomException;
import com.web.study.repository.UserRepository;

import lombok.RequiredArgsConstructor;

//사용자정보와 DB의 정보가 맞는지 비교하기위한 것
//UserDetailsService 불러오면 PrincipalDetailsServiced이걸 실행시켜줌.
//service 어노테이션을 사용해서 IOC로 넘어가기 때문!
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	
	//authenticate가 실행되면서 받아온 username 값이 매개변수로 들어가게 됨.
	//매니저가 해줌.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = userRepository.findUserByUsername(username);
		
		if(userEntity == null) {
			throw new CustomException("사용자 정보를 다시 확인해주세요");
		}
		
		return userEntity.toPrincipal();
	}

}
