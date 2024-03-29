package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Question;
import com.example.demo.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService qusService;
	
	@Autowired
	Environment env;
	
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
	//generate Questions which is from Quiz
		//similar to /create of Quiz
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName){
		return qusService.getQuestionsForQuiz(categoryName);
	}
	
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
		System.out.println(env.getProperty("local.server.port"));
		return qusService.getQuestionsFromId(questionIds);
	}
	
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
		System.out.println(env.getProperty("local.server.port"));
		return qusService.getScore(responses);
	}
	
}
