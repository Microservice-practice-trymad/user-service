package com.trymad.user_service.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.trymad.user_service.entity.AppUser;
import com.trymad.user_service.web.dto.AppUserCreateDTO;
import com.trymad.user_service.web.dto.AppUserDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
	
	AppUserDTO toDto(AppUser entity);

	AppUser toEntity(AppUserDTO dto);

	AppUser toEntity(AppUserCreateDTO dto);

}
