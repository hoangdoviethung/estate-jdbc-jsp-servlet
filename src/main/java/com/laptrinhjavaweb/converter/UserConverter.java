package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

public class UserConverter {
	public UserDTO converterToDTO(UserEntity userEntity){
		ModelMapper mapper = new ModelMapper();
		UserDTO userDTO = mapper.map(userEntity, UserDTO.class);
		return userDTO;
	}
	
	public UserEntity converterToEntity(UserDTO userDTO){
		ModelMapper mapper = new ModelMapper();
		UserEntity userEntity = mapper.map(userDTO, UserEntity.class);
		return userEntity;
	}
}
