package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlienRepo extends JpaRepository<Alien, Integer>{
	
	public List<Alien> findByAname(String name);	//Query DSL
	
	@Query("from Alien where aname= :name")
	public List<Alien> find(@Param("name") String aname);
}
