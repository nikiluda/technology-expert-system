package com.example;

import com.example.engine.InferenceEngine;
import com.example.knowledge.KnowledgeBase;
import com.example.model.Answer;
import com.example.model.Question;
import com.example.model.RecommendationResult;
import com.example.model.Technology;
import com.example.model.TechnologyCategory;

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

        InferenceEngine engine =
                new InferenceEngine(knowledgeBase);

        RecommendationResult result =
                engine.createRecommendation(answers);

        scanner.close();

        printResult(result);
    }

    private static void printResult(
            RecommendationResult result) {

        System.out.println();
        System.out.println("============================================================");
        System.out.println("              РЕЗУЛЬТАТ ЭКСПЕРТНОЙ СИСТЕМЫ");
        System.out.println("============================================================");

        for (TechnologyCategory category : TechnologyCategory.values()) {

            System.out.println();
            System.out.println(category);

            List<Map.Entry<Technology, Double>> ranking =
                    result.getRankings().get(category);

            if (ranking == null || ranking.isEmpty()) {
                continue;
            }

            int position = 1;

            for (Map.Entry<Technology, Double> entry : ranking) {

                System.out.printf(
                        "%d. %-12s %.2f%%%n",
                        position++,
                        entry.getKey().getName(),
                        entry.getValue() * 100
                );
            }
        }

        System.out.println();
        System.out.println("============================================================");
        System.out.println("                 РЕКОМЕНДУЕМЫЙ СТЕК");
        System.out.println("============================================================");

        printRecommendation(
                result,
                TechnologyCategory.BACKEND_LANGUAGE,
                "Backend"
        );

        printRecommendation(
                result,
                TechnologyCategory.DATABASE,
                "Database"
        );

        printRecommendation(
                result,
                TechnologyCategory.MESSAGE_BROKER,
                "Message Broker"
        );

        printRecommendation(
                result,
                TechnologyCategory.CACHE,
                "Cache"
        );

        printRecommendation(
                result,
                TechnologyCategory.API,
                "API"
        );

        printRecommendation(
                result,
                TechnologyCategory.CONTAINERIZATION,
                "Containerization"
        );

        System.out.println("============================================================");
    }
    private static void printRecommendation(
            RecommendationResult result,
            TechnologyCategory category,
            String categoryName) {

        Technology technology =
                result.getRecommendations().get(category);

        if (technology != null) {

            System.out.printf(
                    "%-20s %-15s %s%n",
                    categoryName,
                    technology.getName(),
                    technology.getDescription()
            );
        }
    }

}