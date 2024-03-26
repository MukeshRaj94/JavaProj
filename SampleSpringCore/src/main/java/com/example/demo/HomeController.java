package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(@RequestParam("num1") int i, @RequestParam("num2")int j, Model m) {
		
		int num3 = i+j;
		m.addAttribute("num3",num3);
		return "result";
	}
	
	@PostMapping("/addAlien")
	public String addAlien(@ModelAttribute("aliens") Alien a) {
		repo.save(a);
		return "result";
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m){
		List<Alien> aliens = Arrays.asList(new Alien(101,"Mukesh"),new Alien(102,"Mohanraj"));
		m.addAttribute("result",aliens.toString());
		return "showAlien"; 
	}
	
	@GetMapping("getAlien")
	public String getAlien(int aid, Model m){
		
		m.addAttribute("result",repo.getOne(aid));
		return "showAlien"; 
	}
	
	@GetMapping("getAlienByName")
	public String getAlienByName(String aname, Model m){	
//		m.addAttribute("result",repo.findByAname(aname));
		m.addAttribute("result",repo.find(aname));
		return "showAlien"; 
	}
	
	
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name","Alien");
	}
	
	
}
