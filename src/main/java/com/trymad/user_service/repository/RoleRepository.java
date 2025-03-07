package com.trymad.user_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trymad.user_service.entity.RoleEntity;
import com.trymad.user_service.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
	
	Optional<RoleEntity> findByName(Role name);
	
}
