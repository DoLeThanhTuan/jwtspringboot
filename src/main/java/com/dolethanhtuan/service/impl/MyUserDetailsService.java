package com.dolethanhtuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dolethanhtuan.dto.EnumStatus;
import com.dolethanhtuan.entity.MyUserEntity;
import com.dolethanhtuan.repository.MyUserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private MyUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUserEntity myUserEntity = userRepository.findOneByUsernameAndStatus(username, EnumStatus.Active.getStatusCode()).orElseThrow(null);
		if(myUserEntity == null)
			throw new UsernameNotFoundException("Not found user");
		return myUserEntity;
	}
}
