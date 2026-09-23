package com.example.engine;

import com.example.knowledge.KnowledgeBase;
import com.example.model.Answer;
import com.example.model.RecommendationResult;
import com.example.model.Rule;
import com.example.model.Technology;
import com.example.model.TechnologyCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InferenceEngine {

    private final KnowledgeBase knowledgeBase;

    public InferenceEngine(KnowledgeBase knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }

    public Map<TechnologyCategory, Map<Technology, Double>> calculateScores(
            List<Answer> answers) {

        Map<TechnologyCategory, Map<Technology, Double>> scores =
                new HashMap<>();

        for (Technology technology : knowledgeBase.getTechnologies()) {

            scores
                    .computeIfAbsent(
                            technology.getCategory(),
                            category -> new HashMap<>()
                    )
                    .put(
                            technology,
                            technology.getPrior()
                    );
        }

        for (Answer answer : answers) {

            for (Rule rule : knowledgeBase.getRules()) {

                if (rule.getQuestionId() == answer.getQuestionId()
                        && rule.getOptionNumber() == answer.getOptionNumber()) {

                    Technology technology = rule.getTechnology();

                    Map<Technology, Double> categoryScores =
                            scores.get(technology.getCategory());

                    double currentScore =
                            categoryScores.get(technology);

                    double newScore =
                            currentScore * rule.getWeight();

                    categoryScores.put(
                            technology,
                            newScore
                    );
                }
            }
        }

        return scores;
    }

    public Map<TechnologyCategory, Map<Technology, Double>> normalizeScores(
            Map<TechnologyCategory, Map<Technology, Double>> scores) {

        Map<TechnologyCategory, Map<Technology, Double>> normalizedScores =
                new HashMap<>();

        for (Map.Entry<TechnologyCategory, Map<Technology, Double>> categoryEntry
                : scores.entrySet()) {

            Map<Technology, Double> categoryScores =
                    categoryEntry.getValue();

            double totalScore = categoryScores.values()
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .sum();

            Map<Technology, Double> normalizedCategoryScores =
                    new HashMap<>();

            for (Map.Entry<Technology, Double> technologyEntry
                    : categoryScores.entrySet()) {

                double normalizedScore =
                        technologyEntry.getValue() / totalScore;

                normalizedCategoryScores.put(
                        technologyEntry.getKey(),
                        normalizedScore
                );
            }

            normalizedScores.put(
                    categoryEntry.getKey(),
                    normalizedCategoryScores
            );
        }

        return normalizedScores;
    }

    public List<Map.Entry<Technology, Double>> sortScores(
            Map<Technology, Double> scores) {

        return scores.entrySet()
                .stream()
                .sorted(
                        Map.Entry
                                .<Technology, Double>comparingByValue()
                                .reversed()
                )
                .collect(Collectors.toList());
    }

    public RecommendationResult createRecommendation(
            List<Answer> answers) {

        Map<TechnologyCategory, Map<Technology, Double>> scores =
                calculateScores(answers);

        Map<TechnologyCategory, Map<Technology, Double>> normalizedScores =
                normalizeScores(scores);

        Map<TechnologyCategory, List<Map.Entry<Technology, Double>>> rankings =
                new HashMap<>();

        Map<TechnologyCategory, Technology> recommendations =
                new HashMap<>();

        for (Map.Entry<TechnologyCategory, Map<Technology, Double>> entry
                : normalizedScores.entrySet()) {

            TechnologyCategory category = entry.getKey();

            List<Map.Entry<Technology, Double>> ranking =
                    sortScores(entry.getValue());

            rankings.put(category, ranking);

            if (!ranking.isEmpty()) {
                recommendations.put(
                        category,
                        ranking.get(0).getKey()
                );
            }
        }

        return new RecommendationResult(
                recommendations,
                rankings
        );
    }
}