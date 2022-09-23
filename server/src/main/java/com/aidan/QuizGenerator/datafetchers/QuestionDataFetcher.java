package com.aidan.QuizGenerator.datafetchers;

import com.aidan.QuizGenerator.dao.QuestionDao;
import com.aidan.QuizGenerator.model.PictureQuestion;
import com.aidan.QuizGenerator.model.Question;
import com.aidan.QuizGenerator.model.TextQuestion;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class QuestionDataFetcher {

    Logger logger = LoggerFactory.getLogger(QuestionDataFetcher.class);

    @Autowired
    private QuestionDao questionDao;

    @DgsQuery
    public List<Question> questions(Integer amount) {
        logger.info("Call made to 'questions' endpoint");
        if(amount == null)
            return questionDao.getQuestions();

        List<Question> tempQs = new ArrayList<>(questionDao.getQuestions());
        Collections.shuffle(tempQs);
        return tempQs.stream().limit(amount).collect(Collectors.toList());
    }
}
