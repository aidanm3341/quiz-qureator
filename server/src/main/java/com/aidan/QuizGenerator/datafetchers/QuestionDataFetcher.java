package com.aidan.QuizGenerator.datafetchers;

import com.aidan.QuizGenerator.model.PictureQuestion;
import com.aidan.QuizGenerator.model.Question;
import com.aidan.QuizGenerator.model.TextQuestion;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class QuestionDataFetcher {

    private final List<Question> questions = List.of(
            new TextQuestion("What is the capital of Afghanistan", "Kabul"),
            new TextQuestion("Who wrote the Ender's Game saga?", "Orsen Scott Card"),
            new TextQuestion("Who played Mrs.Weasley in Harry Potter", "Julie Walters"),
            new PictureQuestion("Who is this character?", "Tony the Tiger", "static/tony.jpeg")
    );

    @DgsQuery
    public List<Question> questions(Integer amount) {
        if(amount == null)
            return questions;

        List<Question> tempQs = new ArrayList<>(questions);
        Collections.shuffle(tempQs);
        return tempQs.stream().limit(amount).collect(Collectors.toList());
    }
}
