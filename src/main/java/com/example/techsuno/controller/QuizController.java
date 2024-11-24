package com.example.techsuno.controller;

import com.example.techsuno.repo.QuizRepo;
import com.example.techsuno.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

    @Autowired
    private  QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer noOfQuestions, @RequestParam String title) {
        return quizService.createQuiz(category, noOfQuestions, title);
    }
}
