package com.example.model;

import java.util.List;

public class Question {

    private final int id;
    private final String text;
    private final List<String> options;

    public Question(int id, String text, List<String> options) {
        this.id = id;
        this.text = text;
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }
}
