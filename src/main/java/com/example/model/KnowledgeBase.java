package com.example.model;

import java.util.List;

public class KnowledgeBase {

    private final List<Question> questions;
    private final List<Technology> technologies;

    public KnowledgeBase(List<Question> questions, List<Technology> technologies) {
        this.questions = questions;
        this.technologies = technologies;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }
}
