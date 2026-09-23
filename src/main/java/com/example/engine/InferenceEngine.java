package com.example.engine;

import com.example.knowledge.KnowledgeBase;
import com.example.model.Answer;
import com.example.model.Rule;
import com.example.model.Technology;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

                    double currenScore = scores.get(technology);

                    double newScore = currenScore * rule.getWeight();

                    scores.put(technology, newScore);
                }
            }
        }

        return scores;
    }
}
