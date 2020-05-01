package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.builder.BuildingSearchBuilder.Builder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.Pageable;

public interface IBuildingService {
//	List<BuildingDTO> findAll(String name,String district,int offset,int limit);

	List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch, Pageable pageable);

//	List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch, int offset, int limit); 
}
