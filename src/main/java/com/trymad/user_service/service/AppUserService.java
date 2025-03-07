package com.trymad.user_service.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trymad.user_service.entity.AppUser;
import com.trymad.user_service.repository.AppUserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
@Transactional
public class AppUserService {
	
	private final AppUserRepository userRepository;

	public AppUser get(UUID uuid) {
		return userRepository.findById(uuid).orElseThrow(
			() -> new EntityNotFoundException("User with uuid " + uuid + " not found"));
	}

}
