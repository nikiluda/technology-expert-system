package com.example.engine;

import com.example.knowledge.KnowledgeBase;
import com.example.model.Answer;
import com.example.model.RecommendationResult;
import com.example.model.Rule;
import com.example.model.Technology;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InferenceEngine {

    private final KnowledgeBase knowledgeBase;


    public InferenceEngine(KnowledgeBase knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }

    public Map<Technology,Double> calculateScores(List<Answer> answers) {

        Map<Technology, Double> scores = new HashMap<>();

        for (Technology technology : knowledgeBase.getTechnologies()) {
            scores.put(technology, technology.getPrior());
        }

        for (Answer answer : answers) {
            for (Rule rule : knowledgeBase.getRules()) {

                if (rule.getQuestionId() == answer.getQuestionId() && rule.getOptionNumber() == answer.getOptionNumber()) {

                    Technology technology = rule.getTechnology();

                    double currentScore = scores.get(technology);

                    double newScore = currentScore * rule.getWeight();

                    scores.put(technology, newScore);
                }
            }
        }

        return scores;
    }


    public Map<Technology, Double> normalizeScores(
            Map<Technology, Double> scores) {

        double totalScore = scores.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        Map<Technology, Double> normalizedScores = new HashMap<>();

        for (Map.Entry<Technology, Double> entry : scores.entrySet()) {

            double normalizedScore =
                    entry.getValue() / totalScore;

            normalizedScores.put(
                    entry.getKey(),
                    normalizedScore
            );
        }

        return normalizedScores;
    }

    public Technology findBestTechnology(
            Map<Technology, Double> normalizedScores) {

        Technology bestTechnology = null;
        double bestScore = Double.MIN_VALUE;

        for (Map.Entry<Technology, Double> entry : normalizedScores.entrySet()) {

            if (entry.getValue() > bestScore) {
                bestScore = entry.getValue();
                bestTechnology = entry.getKey();
            }
        }

        return bestTechnology;
    }

    public List<Map.Entry<Technology, Double>> sortScores(
            Map<Technology, Double> scores) {

        return scores.entrySet()
                .stream()
                .sorted(Map.Entry.<Technology, Double>comparingByValue().reversed())
                .collect(Collectors.toList());
    }

    public RecommendationResult createRecommendation(List<Answer> answers) {

        Map<Technology, Double> scores = calculateScores(answers);

        Map<Technology, Double> normalizedScores =
                normalizeScores(scores);

        List<Map.Entry<Technology, Double>> ranking =
                sortScores(normalizedScores);

        Technology recommendedTechnology =
                ranking.get(0).getKey();

        return new RecommendationResult(
                recommendedTechnology,
                ranking
        );
    }
}
