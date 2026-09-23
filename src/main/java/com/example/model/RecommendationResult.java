package com.example.model;

import java.util.List;
import java.util.Map;

public class RecommendationResult {

    private final Map<TechnologyCategory, Technology> recommendations;

    private final Map<
            TechnologyCategory,
            List<Map.Entry<Technology, Double>>
            > rankings;

    public RecommendationResult(
            Map<TechnologyCategory, Technology> recommendations,
            Map<TechnologyCategory, List<Map.Entry<Technology, Double>>> rankings) {

        this.recommendations = recommendations;
        this.rankings = rankings;
    }

    public Map<TechnologyCategory, Technology> getRecommendations() {
        return recommendations;
    }

    public Map<TechnologyCategory, List<Map.Entry<Technology, Double>>> getRankings() {
        return rankings;
    }
}