package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {

	private static IBuildingRepository buildingRepository;
	private static BuildingConverter buildingConverter;

	public static IBuildingRepository getBuildingRepository() {
		if (buildingRepository == null) {
			buildingRepository = new BuildingRepository();
		}
		return  buildingRepository;
	}

	public static BuildingConverter getBuildingConverter() {
		if (buildingConverter == null) {
			buildingConverter = new BuildingConverter();
		}
		return buildingConverter;
	}

	

	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder builder, Pageble pageble) {
		
		List<BuildingEntity> buildingEntities = getBuildingRepository().findAll(builder, pageble);
		List<BuildingDTO> result = buildingEntities.stream().map(item -> getBuildingConverter().converterToDTO(item))
				.collect(Collectors.toList());

		return result;
	}

	@Override
	public BuildingDTO save(BuildingDTO buildingDTO) {

		BuildingEntity buildingEntity = getBuildingConverter().converterToEntity(buildingDTO);
		buildingEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long id = getBuildingRepository().insert(buildingEntity);

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
