package org.fao.mozfis.user.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.fao.mozfis.core.event.CreateResourceEvent;
import org.fao.mozfis.user.model.UserEntity;
import org.fao.mozfis.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API to expose REST resources for Users
 * 
 * @author Nelson Magalhães (nelsonmagas@gmail.com)
 */
@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<UserEntity> findAll() {
		return userService.findUsers();
	}

	@PostMapping
	public ResponseEntity<UserEntity> save(@Valid @RequestBody UserEntity user, HttpServletResponse response) {
		UserEntity created = userService.createUser(user);
		publisher.publishEvent(new CreateResourceEvent(this, response, created.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}

}