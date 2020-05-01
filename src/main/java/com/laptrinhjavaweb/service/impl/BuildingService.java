package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {
	private IBuildingRepository buildingRepository;
	private BuildingConverter buildingConvertor;

	public BuildingService() {
		buildingRepository = new BuildingRepository();
		buildingConvertor = new BuildingConverter();
	}

	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch,Pageable pageable) {
		Map<String, Object> properties = new HashMap<>();
		properties.put("name",fieldSearch.getName() );
		properties.put("district",fieldSearch.getDistrict() );
		properties.put("buildingArea",fieldSearch.getBuildingArea());
		properties.put("numberOfBasement",fieldSearch.getNumberOfBasement() );
		
		List<BuildingEntity> buildingEntitis = buildingRepository.findAll(properties,pageable);
		return buildingEntitis.stream().map(item -> buildingConvertor.convertToDTO(item)).collect(Collectors.toList());
	}

}

