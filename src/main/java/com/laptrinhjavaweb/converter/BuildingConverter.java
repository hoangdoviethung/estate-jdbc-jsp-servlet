package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

public class BuildingConverter {
	public BuildingDTO converterToDTO(BuildingEntity buildingEntity){
		ModelMapper mapper = new ModelMapper();
		BuildingDTO buildingDTO = mapper.map(buildingEntity, BuildingDTO.class);
		return buildingDTO;
	}
	
	public BuildingEntity converterToEntity(BuildingDTO buildingDTO){
		ModelMapper mapper = new ModelMapper();
		BuildingEntity buildingEntity = mapper.map(buildingDTO, BuildingEntity.class);
		return buildingEntity;
	}
}
