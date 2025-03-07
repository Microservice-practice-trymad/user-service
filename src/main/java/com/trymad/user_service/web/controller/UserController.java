package com.trymad.user_service.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.trymad.user_service.service.AppUserService;
import com.trymad.user_service.web.dto.AppUserDTO;
import com.trymad.user_service.web.mapper.UserMapper;

import lombok.AllArgsConstructor;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	private final AppUserService userService;
	private final UserMapper userMapper;

	@GetMapping("{uuid}")
	public AppUserDTO getUserById(@PathVariable UUID uuid) {
		return userMapper.toDto(userService.get(uuid));
	}
	

}
