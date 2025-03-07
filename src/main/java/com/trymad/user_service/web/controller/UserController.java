package com.trymad.user_service.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.trymad.user_service.service.AppUserService;
import com.trymad.user_service.web.dto.AppUserCreateDTO;
import com.trymad.user_service.web.dto.AppUserDTO;
import com.trymad.user_service.web.mapper.UserMapper;

import lombok.AllArgsConstructor;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



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

	@PostMapping
	public AppUserDTO createUser(@RequestBody AppUserCreateDTO userCreateDto) {
		return userMapper.toDto(userService.create(userCreateDto));
	}

	@PutMapping("{uuid}")
	public AppUserDTO updateUser(@PathVariable UUID uuid, @RequestBody AppUserCreateDTO updateDto) {
		return userMapper.toDto(userService.update(updateDto, uuid));
	}

}
