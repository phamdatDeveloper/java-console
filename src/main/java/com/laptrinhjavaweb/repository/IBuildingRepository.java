package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageable;

public interface IBuildingRepository extends JpaRepository<BuildingEntity> {
//	List<BuildingEntity> findAll(BuildingSearchBuilder fieldSearch, int offset, int limit);

	List<BuildingEntity> findAll(Map<String, Object> params,Pageable pageable);

//	List<BuildingEntity> findAll(BuildingSearchBuilder fieldSearch, int offset, int limit);
}
