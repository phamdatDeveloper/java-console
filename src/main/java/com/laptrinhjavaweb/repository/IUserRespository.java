package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.dto.UserDTO;

public interface IUserRespository extends JpaRepository<UserDTO>{
	List<UserDTO> findAll(int status);
}
