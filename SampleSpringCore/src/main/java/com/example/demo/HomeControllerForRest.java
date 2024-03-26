package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControllerForRest {
	
	@Autowired
	AlienRepo repo;
	
	@GetMapping(path="/aliens",produces= {"application/json"})
	public List<Alien> getAliens() {
		
		List<Alien> aln = repo.findAll();
		System.out.println("Inside Method GetAliens");
		return aln;
	}
	
	@GetMapping("/alien/{aid}")
	public Alien getAlien(@PathVariable int aid) {		
		Alien aln = repo.findById(aid).orElseThrow();
		return aln;
	}
	
	@PostMapping(path="/alien",consumes= {MediaType.APPLICATION_JSON_VALUE})
	public Alien postAlien(@RequestBody Alien aln) {		
		System.out.println("Post mapping");
		repo.save(aln);
		return aln;
	}
}
