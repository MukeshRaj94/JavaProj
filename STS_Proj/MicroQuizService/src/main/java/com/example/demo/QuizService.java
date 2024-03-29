package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.QuizRepo;
import com.example.demo.Question;
import com.example.demo.QuestionWrapper;
import com.example.demo.Quiz;
import com.example.demo.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizRepo qz;
	
	@Autowired
	FeignQuizInterface feignInt;

	public ResponseEntity<String> createQuiz(String category, String title) {
//		List<Question> qus = qusRepo.findRandomQuestionsByCategory(category);
//		System.out.println("qus::"+qus);
//		Quiz quiz = new Quiz();
////		quiz.setId(1);
//		quiz.setTitle(title);
//		quiz.setQuestions(qus);
//		qz.save(quiz);
		List<Integer> qus=feignInt.getQuestionsForQuiz(category).getBody();
		Quiz quiz = new Quiz();
		quiz.setId(5);
		quiz.setTitle(title);
		quiz.setQuestions(qus);
		qz.save(quiz);
		
		return new ResponseEntity<>("success",HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuzWrapper(Integer id) {
		List<QuestionWrapper> quzWrap = new ArrayList<>();
		
		//		Quiz listOfQuz = qz.findById(id).orElse(new Quiz());
//		System.out.println("listOfQuz::"+listOfQuz);
//		List<Question> listofQues = listOfQuz.getQuestions();
//		System.out.println("listofQues::"+listofQues);
//		for(Question qus: listofQues) {
//			QuestionWrapper qzWrp = new QuestionWrapper(qus.getId(),qus.getQuestiontitle(),qus.getOption1(),qus.getOption2(),qus.getOption3(),qus.getOption4());
//			quzWrap.add(qzWrp);
//		}
		Quiz quiz= qz.findById(id).get();
		List<Integer> questionIds = quiz.getQuestions();
		ResponseEntity<List<QuestionWrapper>> questions =feignInt.getQuestionsFromId(questionIds);
		return questions;
	}

	public ResponseEntity<Integer> submitQuiz(Integer id, List<Response> responses) {
//		Quiz quiz= qz.findById(id).get();
//		System.out.println("submit Quiz::"+quiz);
//		List<Question> listQus = quiz.getQuestions();
//		int i=0;
//		int right =0;
//		for(Response resp:responses) {
//			System.out.println(resp.getResponse());
//			System.out.println("listQus.get(i).getRightanswer()::"+listQus.get(i).getRightanswer());
//			if(resp.getResponse().equals(listQus.get(i).getRightanswer())) {
//				right++;
//				System.out.println("Inside right");
//			}
//			i++;
//		}
		ResponseEntity<Integer> score = feignInt.getScore(responses);
		return score;
	}

}
