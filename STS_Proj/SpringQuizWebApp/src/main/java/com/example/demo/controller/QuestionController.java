package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Question;
import com.example.demo.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService qusService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getQuestions() {
		return qusService.getAllQuestion();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getCategory(@PathVariable String category) {
		return qusService.getCategory(category);
	}
	
	@PostMapping("add")
	public String addQuestion(@RequestBody Question qus) {
		qusService.addQuestion(qus);
		return "success";
	}
}
