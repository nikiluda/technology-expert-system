package com.example;

import com.example.engine.InferenceEngine;
import com.example.knowledge.KnowledgeBase;
import com.example.model.Answer;
import com.example.model.Question;
import com.example.model.RecommendationResult;
import com.example.model.Technology;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleApplication {

    public static void main(String[] args) {

        KnowledgeBase knowledgeBase =
                KnowledgeBase.createDefault();

        Scanner scanner = new Scanner(System.in);

        List<Answer> answers = new ArrayList<>();

        for (Question question : knowledgeBase.getQuestions()) {

            System.out.println();
            System.out.println(question.getText());

            List<String> options = question.getOptions();

            for (int i = 0; i < options.size(); i++) {
                System.out.println(
                        (i + 1) + ". " + options.get(i)
                );
            }

            System.out.print("Ваш ответ: ");

            int optionNumber = scanner.nextInt();

            answers.add(
                    new Answer(
                            question.getId(),
                            optionNumber
                    )
            );
        }
        InferenceEngine engine = new InferenceEngine(knowledgeBase);

        RecommendationResult result =
                engine.createRecommendation(answers);

        scanner.close();

        System.out.println();
        System.out.println("==============================");
        System.out.println("Результат экспертной системы");
        System.out.println("==============================");

        System.out.println(
                "Рекомендуемая технология: "
                        + result.getRecommendedTechnology().getName()
        );

        System.out.println();
        System.out.println("Рейтинг технологий:");

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