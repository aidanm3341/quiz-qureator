package com.aidan.QuizGenerator.dao;

import com.aidan.QuizGenerator.model.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class MongoDbQuestionDao implements QuestionDao {

    private final Logger logger = LoggerFactory.getLogger(MongoDbQuestionDao.class);
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public MongoDbQuestionDao(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Override
    public Flux<Question> getQuestions(long amount) {
        return reactiveMongoTemplate.aggregate(
                TypedAggregation.newAggregation(Aggregation.sample(amount)),
                        "questions",
                        Question.class
                )
                .doOnNext(question -> logger.info("Successfully retrieved [{}] from the database", question));
    }

    @Override
    public void saveQuestion(Question question) {
        reactiveMongoTemplate.insert(question, "questions");
    }
}
