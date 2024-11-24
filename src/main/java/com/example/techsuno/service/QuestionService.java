package com.example.techsuno.service;

import com.example.techsuno.model.Question;
import com.example.techsuno.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionRepo.findAll();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<Question> addQuestion(Question question) {
        Question savedQuestion = questionRepo.save(question);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        List<Question> questions = questionRepo.findByCategory(category);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<Question> getQuestionById(Long id) {
        Question question = questionRepo.findById(id).orElse(null);
        if (question == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(question, HttpStatus.OK);
    }
}