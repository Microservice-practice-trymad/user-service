package com.trymad.user_service.web.dto;

import java.util.UUID;

public record AppUserDTO(
	UUID id,

	String name,

	String surname,

	String mail, 

	String phone
) {}
