package com.example.model;

public class Rule {

    private final int questionId;
    private final int optionNumber;
    private final Technology technology;
    private final double weight;


    public Rule(int questionId, int optionNumber, Technology technology, double weight) {
        this.questionId = questionId;
        this.optionNumber = optionNumber;
        this.technology = technology;
        this.weight = weight;
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

    public double getWeight() {
        return weight;
    }
}
