package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {

	private IBuildingRepository buildingRepository;

	private BuildingConverter buildingConverter;

	private IBuildingRepository buildingRepository() {
		if (buildingRepository == null) {
			buildingRepository = new BuildingRepository();
		}
		return buildingRepository;
	}

	private BuildingConverter buildingConverter() {
		if (buildingConverter == null) {
			buildingConverter = new BuildingConverter();
		}
		return buildingConverter;

	}

	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder builder, Pageble pageble) {
		List<BuildingDTO> result = new ArrayList<>();
		buildingRepository = new BuildingRepository();
		buildingConverter = new BuildingConverter();
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(builder, pageble);

		for (BuildingEntity item : buildingEntities) {
			result.add(buildingConverter.converterToDTO(item));
		}

		return result;
	}

	@Override
	public BuildingDTO save(BuildingDTO buildingDTO) {
		buildingRepository = new BuildingRepository();
		buildingConverter = new BuildingConverter();
		BuildingEntity buildingEntity = buildingConverter().converterToEntity(buildingDTO);
		buildingEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long id = buildingRepository().insert(buildingEntity);

		return null;
	}

	// @Override
	// public BuildingDTO update(BuildingDTO buildingDTO) {
	// BuildingConverter buildingConverter = new BuildingConverter();
	// BuildingEntity buildingEntity =
	// buildingConverter.converterToEntity(buildingDTO);
	// buildingEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
	// buildingRepository.update(buildingEntity);
	// return null;
	// }

	// @Override
	// public void delete(Long id) {
	// buildingRepository.delete(id);
	// }

	// @Override
	// public BuildingDTO findById(Long id) {
	// BuildingDTO buildingDTO = (BuildingDTO) buildingRepository.findById(id);
	// return buildingDTO;
	// }

	// @Override
	// public List<BuildingDTO> findAll() {
	// Map<String, Object> properties = new HashMap<>();
	// properties.put("name", "a");
	// properties.put("ward", "s");
	// Sorter sorter = new Sorter("name", "DESC");
	// PageRequest pageRequest = new PageRequest(1, 10, sorter);
	// List<BuildingEntity> list=buildingRepository.findAll(properties,
	// pageRequest);
	// List<BuildingDTO> result = new ArrayList<>();
	// BuildingConverter buildingConverter = new BuildingConverter();
	// for (int i = 0; i < list.size(); i++) {
	// BuildingDTO buildingDTO = buildingConverter.converterToDTO(list.get(i));
	// result.add(buildingDTO);
	// }
	// return result;
	// }
}
