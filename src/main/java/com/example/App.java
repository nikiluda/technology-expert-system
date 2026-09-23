package com.example;

import com.example.engine.InferenceEngine;
import com.example.knowledge.KnowledgeBase;
import com.example.model.Answer;
import com.example.model.RecommendationResult;
import com.example.model.Technology;

import java.util.List;
import java.util.Map;


public class App
{
    public static void main( String[] args ) {

        KnowledgeBase knowledgeBase = KnowledgeBase.createDefault();

        InferenceEngine engine = new InferenceEngine(knowledgeBase);

        List<Answer> answers = List.of(
                new Answer(1, 1),
                new Answer(2, 4),
                new Answer(3, 3)
        );

        RecommendationResult result =
                engine.createRecommendation(answers);

        System.out.println();

        int position = 1;

        for (Map.Entry<Technology, Double> entry : result.getRanking()) {

            System.out.printf(
                    "%d. %s -> %.2f%%%n",
                    position++,
                    entry.getKey().getName(),
                    entry.getValue() * 100
            );
        }
    }
}
