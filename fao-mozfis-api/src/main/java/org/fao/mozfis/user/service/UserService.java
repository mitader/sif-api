package org.fao.mozfis.user.service;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.user.model.UserEntity;
import org.fao.mozfis.user.model.filter.UserFilter;
import org.fao.mozfis.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Production Service implementation for User operations
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserEntity createUser(UserEntity user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setStatus(EntityState.ACTIVE);
		return userRepository.save(user);
	}

	public Page<UserEntity> findUsers(UserFilter filter, Pageable pagination) {
		return userRepository.findUsers(filter, pagination);
	}
}
