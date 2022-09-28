package com.aidan.QuizGenerator.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document
public class PictureQuestion implements Question {

    @Id
    private String id;
    private String question, answer, pictureUrl, type;

    public PictureQuestion() {
    }

    public PictureQuestion(String id, String question, String answer, String pictureUrl, String type) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.pictureUrl = pictureUrl;
        this.type = type;
    }

    public PictureQuestion(String id, String question, String answer, String pictureUrl) {
        this(id, question, answer, pictureUrl, "picture");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PictureQuestion that = (PictureQuestion) o;
        return Objects.equals(id, that.id) && Objects.equals(question, that.question) && Objects.equals(answer, that.answer) && Objects.equals(pictureUrl, that.pictureUrl) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer, pictureUrl, type);
    }

    @Override
    public String toString() {
        return "PictureQuestion{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
