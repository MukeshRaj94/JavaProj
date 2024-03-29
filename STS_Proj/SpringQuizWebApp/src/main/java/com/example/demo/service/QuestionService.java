package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuestionRepo;
import com.example.demo.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionRepo repo;
	
	public ResponseEntity<List<Question>> getAllQuestion(){
		try {
			return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(repo.findAll(),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Question>> getCategory(String category){
		try {
			return new ResponseEntity<>(repo.findByCategory(category),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(repo.findByCategory(category),HttpStatus.BAD_REQUEST);
	}

	public Question addQuestion(Question qus) {
		return repo.save(qus);
	}
}
