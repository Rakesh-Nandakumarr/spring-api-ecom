package com.example.techsuno.service;

import com.example.techsuno.model.Question;
import com.example.techsuno.model.Quiz;
import com.example.techsuno.repo.QuestionRepo;
import com.example.techsuno.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, Integer noOfQuestions, String title) {
        List<Question> questions = questionRepo.findRandomQuestionsByCategory(category, noOfQuestions);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("Quiz created successfully!\nQuiz Title: " + title, HttpStatus.CREATED);
    }
}