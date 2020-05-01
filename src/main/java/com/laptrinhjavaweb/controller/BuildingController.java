package com.laptrinhjavaweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;

public class BuildingController {

	private static BuildingService buildingService = new BuildingService();

	public static void main(String[] args) {

		int page = 1;
		int limit = 2;
		int offset = (page - 1) * limit;
		String name = null;
		String district = null;
		Integer buildingArea = null;
		Integer numberOfBasement = 2;
		IBuildingService buildingService = new BuildingService();
		Map<String, Object> properties = new HashMap<>();
		properties.put("name", name);
		properties.put("district", district);
		properties.put("buildingarea", buildingArea);
		properties.put("numberofbasement", numberOfBasement);
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder().setName(name)
				.setDistrict(district).setBuildingArea(buildingArea).setNumberOfBasement(numberOfBasement).build();
		Pageable pageable = new PageRequest(page, limit);

		List<BuildingDTO> buildings = buildingService.findAll(buildingSearchBuilder, pageable);
		for (BuildingDTO item : buildings) {
			System.out.println("ID: " + item.getId() + " Name:" + item.getName() + " - Street " + item.getStreet());
		}

	}
}
