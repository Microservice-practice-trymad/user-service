package com.trymad.user_service.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trymad.user_service.entity.AppUser;
import com.trymad.user_service.model.Role;
import com.trymad.user_service.repository.AppUserRepository;
import com.trymad.user_service.web.dto.AppUserCreateDTO;
import com.trymad.user_service.web.mapper.UserMapper;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Lazy))

@Service
@Transactional
public class AppUserService {
	
	private final AppUserRepository userRepository;
	private final RoleService roleService;
	private final UserMapper mapper;
	@Lazy private final AppUserService appUserService;

	@Transactional(readOnly = true)
	public AppUser get(UUID uuid) {
		return userRepository.findById(uuid).orElseThrow(
			() -> new EntityNotFoundException("User with uuid " + uuid + " not found"));
	}

	// TODO add password hashing;
	public AppUser create(AppUserCreateDTO createDto) {
		if(userRepository.existsByMail(createDto.mail())) {
			throw new EntityExistsException("User with mail " + createDto.mail() + " already exists");
		}

		final AppUser user = mapper.toEntity(createDto);
		user.setId(UUID.randomUUID());
		user.getRoles().add(roleService.get(Role.USER));
		
		final LocalDateTime now = LocalDateTime.now();
		user.setCreatedAt(now);
		user.setUpdatedAt(now);

		return userRepository.save(user);
	}

	public AppUser update(AppUserCreateDTO updateDto, UUID uuid) {
		if(updateDto.mail() != null && userRepository.existsByMail(updateDto.mail())) {
			throw new EntityExistsException("User with mail " + updateDto.mail() + " already exists");
		}

		if(!userRepository.existsById(uuid)) {
			throw new EntityNotFoundException("User with uuid " + uuid + " not found");
		}

		final AppUser user = appUserService.get(uuid);
		user.setName(updateDto.name());
		user.setSurname(updateDto.surname());
		user.setMail(updateDto.mail());
		user.setPhone(updateDto.phone());
		user.setUpdatedAt(LocalDateTime.now());

		return userRepository.save(user);
	}

}
