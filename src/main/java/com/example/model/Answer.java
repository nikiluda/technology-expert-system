package com.example.model;

public class Answer {

    private final int questionId;
    private final int optionNumber;

    public Answer(int questionId, int optionNumber) {
        this.questionId = questionId;
        this.optionNumber = optionNumber;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getOptionNumber() {
        return optionNumber;
    }
}
