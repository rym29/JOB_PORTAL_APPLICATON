package com.project.jobportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.jobportal.entity.Users;
import com.project.jobportal.repository.UsersRepository;
import com.project.jobportal.util.CustomUsersDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UsersRepository usersRepository;

	@Autowired
	public CustomUserDetailsService(UsersRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Could not found the user"));
		return new CustomUsersDetails(user);
	}

}
