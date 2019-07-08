package com.laptrinhjavaweb.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentArea;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.repository.IRentAreaRepository;
import com.laptrinhjavaweb.repository.impl.RentAreaRepository;

public class BuildingConverter {
	@Inject
	private IRentAreaRepository rentAreaRepository;

	public BuildingDTO converterToDTO(BuildingEntity buildingEntity) {
		rentAreaRepository = new RentAreaRepository();
		ModelMapper mapper = new ModelMapper();
		BuildingDTO result = mapper.map(buildingEntity, BuildingDTO.class);
		Map<String, Object> condition = new HashMap<>();
		condition.put("buildingid", buildingEntity.getId());
		List<RentArea> rentAreas = rentAreaRepository.findAll(condition, new PageRequest(null, null, null));
		List<String> areas = new ArrayList<>();
		for (RentArea item : rentAreas) {
			areas.add(item.getValue());
		}
		if (areas.size() > 0) {
			result.setRentArea(StringUtils.join(areas, ","));
		}
		if(StringUtils.isNotBlank(buildingEntity.getType())){
			 result.setBuildingTypes(buildingEntity.getType().split(","));
		}
		return result;
	}

	public BuildingEntity converterToEntity(BuildingDTO buildingDTO) {
		ModelMapper mapper = new ModelMapper();
		BuildingEntity buildingEntity = mapper.map(buildingDTO, BuildingEntity.class);
		return buildingEntity;
	}
}
