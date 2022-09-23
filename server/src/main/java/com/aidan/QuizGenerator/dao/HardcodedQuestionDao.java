package com.aidan.QuizGenerator.dao;

import com.aidan.QuizGenerator.model.PictureQuestion;
import com.aidan.QuizGenerator.model.Question;
import com.aidan.QuizGenerator.model.TextQuestion;

import java.util.List;

public class HardcodedQuestionDao implements QuestionDao{

    @Override
    public List<Question> getQuestions() {
        return List.of(
                new TextQuestion("What is the capital of Afghanistan", "Kabul"),
                new TextQuestion("Who wrote the Ender's Game saga?", "Orson Scott Card"),
                new TextQuestion("Who played Mrs.Weasley in Harry Potter", "Julie Walters"),
                new PictureQuestion("Who is this character?", "Tony the Tiger", "tony.jpeg")
        );
    }
}
