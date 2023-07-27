package com.org.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
	
	Optional<Admin> findByUserName(String userName);
	Optional<Admin> findByEmail (String email);
	
}
