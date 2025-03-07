package com.trymad.user_service.web.dto;


public record AppUserCreateDTO(

	String name,

	String surname,

	String password,

	String mail, 

	String phone
) {}