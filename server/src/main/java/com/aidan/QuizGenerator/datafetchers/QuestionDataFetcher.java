package com.aidan.QuizGenerator.datafetchers;

import com.aidan.QuizGenerator.dao.QuestionDao;
import com.aidan.QuizGenerator.model.Question;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class QuestionDataFetcher {

    Logger logger = LoggerFactory.getLogger(QuestionDataFetcher.class);

    @Autowired
    private QuestionDao questionDao;

    @DgsQuery
    public List<Question> questions(Integer amount) {
        logger.info("Request made for [{}] question(s)", amount);

        return questionDao.getQuestions(amount == null ? Long.MAX_VALUE : amount)
                .collect(Collectors.toList())
                .block();
    }
}
