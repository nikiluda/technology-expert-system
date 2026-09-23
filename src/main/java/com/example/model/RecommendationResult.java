package com.example.model;

import java.util.List;
import java.util.Map;

public class RecommendationResult {

    private final Technology recommendedTechnology;
    private final List<Map.Entry<Technology, Double>> ranking;


    public RecommendationResult(Technology recommendedTechnology, List<Map.Entry<Technology, Double>> ranking) {
        this.recommendedTechnology = recommendedTechnology;
        this.ranking = ranking;
    }

    public Technology getRecommendedTechnology() {
        return recommendedTechnology;
    }

    public List<Map.Entry<Technology, Double>> getRanking() {
        return ranking;
    }
}
