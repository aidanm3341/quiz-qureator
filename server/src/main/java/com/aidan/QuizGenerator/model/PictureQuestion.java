package com.aidan.QuizGenerator.model;

public class PictureQuestion extends Question {
    private final String pictureUrl;

    public PictureQuestion(String question, String answer, String pictureUrl) {
        super(question, answer);
        this.pictureUrl = pictureUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }
}
