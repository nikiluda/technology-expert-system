package com.example;

import com.example.engine.InferenceEngine;
import com.example.knowledge.KnowledgeBase;
import com.example.model.Answer;
import com.example.model.RecommendationResult;
import com.example.model.Technology;
import com.example.model.TechnologyCategory;

import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        KnowledgeBase knowledgeBase =
                KnowledgeBase.createDefault();

        InferenceEngine engine =
                new InferenceEngine(knowledgeBase);

        List<Answer> answers = List.of(
                new Answer(1, 1),
                new Answer(2, 4),
                new Answer(3, 3)
        );

        RecommendationResult result =
                engine.createRecommendation(answers);

        for (TechnologyCategory category : TechnologyCategory.values()) {

            System.out.println();
            System.out.println(category);

            List<Map.Entry<Technology, Double>> ranking =
                    result.getRankings().get(category);

            if (ranking == null) {
                continue;
            }

            int position = 1;

            for (Map.Entry<Technology, Double> entry : ranking) {

                System.out.printf(
                        "%d. %s -> %.2f%%%n",
                        position++,
                        entry.getKey().getName(),
                        entry.getValue() * 100
                );
            }
        }

        System.out.println();
        System.out.println("========== РЕКОМЕНДУЕМЫЙ СТЕК ==========");

        for (TechnologyCategory category : TechnologyCategory.values()) {

            Technology technology =
                    result.getRecommendations().get(category);

            if (technology != null) {
                System.out.printf(
                        "%s -> %s%n",
                        category,
                        technology.getName()
                );
            }
        }
    }
}