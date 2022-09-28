package com.aidan.QuizGenerator.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document
public class TextQuestion implements Question {

    @Id
    private String id;
    private String question, answer, type;

    public TextQuestion() {
    }

    public TextQuestion(String id, String question, String answer, String type) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.type = type;
    }

    public TextQuestion(String id, String question, String answer) {
        this(id, question, answer, "text");
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
        TextQuestion that = (TextQuestion) o;
        return Objects.equals(id, that.id) && Objects.equals(question, that.question) && Objects.equals(answer, that.answer) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer, type);
    }

    @Override
    public String toString() {
        return "TextQuestion{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
