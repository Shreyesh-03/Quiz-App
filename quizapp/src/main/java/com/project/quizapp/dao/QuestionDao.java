package com.project.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.quizapp.model.Question;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

        List<Question> findByCategory(String category);

        @Query(value="SELECT * from question q WHERE q.category=:category ORDER BY RAND() LIMIT :noQ",nativeQuery = true)
        List<Question> findRandomQuestionsByCategory(String category, int noQ);
}
