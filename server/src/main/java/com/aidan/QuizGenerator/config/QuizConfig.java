package com.aidan.QuizGenerator.config;

import com.aidan.QuizGenerator.dao.MongoDbQuestionDao;
import com.aidan.QuizGenerator.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Configuration
@DependsOn("reactiveMongoTemplate")
public class QuizConfig {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Bean
    public QuestionDao questionDao() {
        return new MongoDbQuestionDao(reactiveMongoTemplate);
    }
}
