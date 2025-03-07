package com.trymad.user_service.web.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;

import com.trymad.user_service.entity.AppUser;
import com.trymad.user_service.web.dto.AppUserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	AppUserDTO toDto(AppUser entity);

	@BeanMapping(ignoreByDefault = true)
	AppUser toEntity(AppUserDTO dto);

}
