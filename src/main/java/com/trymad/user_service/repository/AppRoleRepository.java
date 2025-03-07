package com.trymad.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trymad.user_service.entity.AppRoleEntity;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRoleEntity, Integer> {
	
}
