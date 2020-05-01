package com.laptrinhjavaweb.repository.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.IBuildingRepository;

public class BuildingRepository extends SimpleJpaRepository<BuildingEntity> implements IBuildingRepository {

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, Pageable pageable) {
		return this.findAll(params,pageable);
	}

}
