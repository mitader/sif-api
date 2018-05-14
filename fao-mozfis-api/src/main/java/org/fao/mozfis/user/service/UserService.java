package org.fao.mozfis.user.service;

import java.util.List;
import java.util.Optional;

import org.fao.mozfis.core.entity.EntityState;
import org.fao.mozfis.user.model.UserEntity;
import org.fao.mozfis.user.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service for User operations
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
		user.setStatus(EntityState.active);
		return userRepository.save(user);
	}

	public UserEntity updateUser(Long id, UserEntity user) {
		UserEntity existing = findUserById(id);
		BeanUtils.copyProperties(user, existing, "id", "password");
		return userRepository.save(existing);
	}

	private UserEntity findUserById(Long code) {
		Optional<UserEntity> found = userRepository.findById(code);

		if (!found.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}

		return found.get();
	}

	public List<UserEntity> findUsers() {
		return userRepository.findByStatus(EntityState.active);
	}
}
