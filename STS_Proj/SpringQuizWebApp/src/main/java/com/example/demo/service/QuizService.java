package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuestionRepo;
import com.example.demo.dao.QuizRepo;
import com.example.demo.model.Question;
import com.example.demo.model.QuestionWrapper;
import com.example.demo.model.Quiz;
import com.example.demo.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizRepo qz;
	@Autowired
	QuestionRepo qusRepo;

	public ResponseEntity<String> createQuiz(String category, String title) {
		List<Question> qus = qusRepo.findRandomQuestionsByCategory(category);
		System.out.println("qus::"+qus);
		Quiz quiz = new Quiz();
//		quiz.setId(1);
		quiz.setTitle(title);
		quiz.setQuestions(qus);
		qz.save(quiz);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuzWrapper(Integer id) {
		List<QuestionWrapper> quzWrap = new ArrayList<>();
		Quiz listOfQuz = qz.findById(id).orElse(new Quiz());
		System.out.println("listOfQuz::"+listOfQuz);
		List<Question> listofQues = listOfQuz.getQuestions();
		System.out.println("listofQues::"+listofQues);
		for(Question qus: listofQues) {
			QuestionWrapper qzWrp = new QuestionWrapper(qus.getId(),qus.getQuestiontitle(),qus.getOption1(),qus.getOption2(),qus.getOption3(),qus.getOption4());
			quzWrap.add(qzWrp);
		}
		return new ResponseEntity<>(quzWrap,HttpStatus.OK);
	}

	public ResponseEntity<Integer> submitQuiz(Integer id, List<Response> responses) {
		Quiz quiz= qz.findById(id).get();
		System.out.println("submit Quiz::"+quiz);
		List<Question> listQus = quiz.getQuestions();
		int i=0;
		int right =0;
		for(Response resp:responses) {
			System.out.println(resp.getResponse());
			System.out.println("listQus.get(i).getRightanswer()::"+listQus.get(i).getRightanswer());
			if(resp.getResponse().equals(listQus.get(i).getRightanswer())) {
				right++;
				System.out.println("Inside right");
			}
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}

}
