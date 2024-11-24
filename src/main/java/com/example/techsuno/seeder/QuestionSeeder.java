package com.example.techsuno.seeder;

import com.example.techsuno.model.Question;
import com.example.techsuno.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QuestionSeeder implements CommandLineRunner {

    @Autowired
    private QuestionService questionService;

    @Override
    public void run(String... args) throws Exception {
        seedQuestions();
    }

    private void seedQuestions() {
//        if (questionService.getAllQuestions().isEmpty()) {
            for (int i = 1; i <= 50; i++) {
                Question question = new Question();
                question.setQuestion("This is question " + i);
                question.setCategory("Category" + ((i % 5) + 1)); // Rotates between Category 1 to 5
                question.setDifficultyLevel(i % 3 == 0 ? "Easy" : i % 3 == 1 ? "Medium" : "Hard");
                question.setOption1("Q" + i + "-OP1");
                question.setOption2("Q" + i + "-OP2");
                question.setOption3("Q" + i + "-OP3");
                question.setOption4("Q" + i + "-OP4");
                question.setCorrectOption((i % 4) + 1); // Cycles through 1 to 4
                question.setExplanation("Explanation for question " + i);
                questionService.addQuestion(question);
            }
            System.out.println("Seeded 1000 questions successfully!");
//        } else {
//            System.out.println("Questions already exist in the database. No seeding performed.");
//        }
    }
}
