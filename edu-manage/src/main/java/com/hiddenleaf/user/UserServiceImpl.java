package com.hiddenleaf.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) {

		return null;

	}
}
