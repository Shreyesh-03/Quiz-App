package com.project.quizapp.controller;

import com.project.quizapp.model.QuestionWrapper;
import com.project.quizapp.model.Response;
import com.project.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    // http://localhost:8080/quiz/create?category=Java&noQ=5&title=JQuiz
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int noQ,@RequestParam String title){
       // return new ResponseEntity<>("Hi Quiz got created", HttpStatus.OK);
        return quizService.createQuiz(category,noQ,title);
    }

    //http://localhost:8080/quiz/get/1
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
         return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }

}
