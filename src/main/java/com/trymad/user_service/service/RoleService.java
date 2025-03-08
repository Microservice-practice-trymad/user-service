package com.trymad.user_service.service;

import org.springframework.stereotype.Service;

import com.trymad.user_service.entity.RoleEntity;
import com.trymad.user_service.model.Role;
import com.trymad.user_service.repository.RoleRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class RoleService {
	
	private final RoleRepository roleRepository;

	public RoleEntity get(Role role) {
		return roleRepository.findByName(role).orElseThrow(
			() -> new EntityNotFoundException("Role " + role.toString() + " don`t exists")
		);
	}

}
