package com.aidan.QuizGenerator.dao;

import com.aidan.QuizGenerator.model.Question;
import reactor.core.publisher.Flux;

public interface QuestionDao {
    Flux<Question> getQuestions(long amount);
    void saveQuestion(Question question);
}
