package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer>{

	List<Question> findByCategory(String category);

	@Query(value="select * from question q where q.category=?1",nativeQuery=true)
	List<Question> findRandomQuestionsByCategory(String category);

}
