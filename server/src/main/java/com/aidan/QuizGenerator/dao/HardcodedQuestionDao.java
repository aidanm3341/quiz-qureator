package com.aidan.QuizGenerator.dao;

import com.aidan.QuizGenerator.model.PictureQuestion;
import com.aidan.QuizGenerator.model.Question;
import com.aidan.QuizGenerator.model.TextQuestion;
import reactor.core.publisher.Flux;

public class HardcodedQuestionDao implements QuestionDao {

    @Override
    public Flux<Question> getQuestions(long amount) {
        return Flux.just(
                new TextQuestion("1", "What is the capital of Afghanistan", "Kabul"),
                new TextQuestion("2", "Who wrote the Ender's Game saga?", "Orson Scott Card"),
                new TextQuestion("3", "Who played Mrs.Weasley in Harry Potter", "Julie Walters"),
                new PictureQuestion("4", "Who is this character?", "Tony the Tiger", "tony.jpeg")
        ).take(amount);
    }

    @Override
    public void saveQuestion(Question question) {

    }
}
