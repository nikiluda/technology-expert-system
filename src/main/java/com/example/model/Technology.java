package com.example.model;

public class Technology {

    private final String name;
    private final String description;
    private final TechnologyCategory category;
    private final double prior;

    public Technology(String name, String description, TechnologyCategory category, double prior) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.prior = prior;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrior() {
        return prior;
    }

    public TechnologyCategory getCategory() {
        return category;
    }
}
