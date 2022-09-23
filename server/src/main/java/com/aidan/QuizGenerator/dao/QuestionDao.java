package com.aidan.QuizGenerator.dao;

import com.aidan.QuizGenerator.model.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestions();
}
