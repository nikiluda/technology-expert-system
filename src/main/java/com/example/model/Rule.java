package com.example.model;

public class Rule {

    private final int questionId;
    private final int optionNumber;
    private final Technology technology;
    private final double coefficient;


    public Rule(int questionId, int optionNumber, Technology technology, double coefficient) {
        this.questionId = questionId;
        this.optionNumber = optionNumber;
        this.technology = technology;
        this.coefficient = coefficient;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public Technology getTechnology() {
        return technology;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
