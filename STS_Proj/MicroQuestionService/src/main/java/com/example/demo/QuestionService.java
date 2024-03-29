package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.QuestionRepo;
import com.example.demo.Question;

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

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName) {
		List<Integer> questions = repo.findRandomQuestionsByCategory(categoryName);
		return new ResponseEntity<>(questions,HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
		List<QuestionWrapper> wrapper = new ArrayList<>();
		List<Question> questions= new ArrayList<>();
		for(Integer id:questionIds) {
			questions.add(repo.findById(id).get());
		}
		
		for(Question question:questions) {
			QuestionWrapper rapper= new QuestionWrapper();
			rapper.setId(question.getId());
			rapper.setQuestiontitle(question.getQuestiontitle());
			rapper.setOption1(question.getOption1());
			rapper.setOption2(question.getOption2());
			rapper.setOption3(question.getOption3());
			rapper.setOption4(question.getOption4());
			wrapper.add(rapper);
		}
		
		return new ResponseEntity<>(wrapper,HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		
		int right =0;
		for(Response resp:responses) {
			Question question = repo.findById(resp.getId()).get();
			if(resp.getResponse().equals(question.getRightanswer())) {
				right++;
				System.out.println("Inside right");
			}
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
}

