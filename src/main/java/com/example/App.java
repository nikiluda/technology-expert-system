package com.example;

import com.example.model.Question;

import java.util.List;


public class App 
{
    public static void main( String[] args ) {

        Question question = new Question(
                1,
                "Какой тип программного продукта вы планируете разрабатывать ?",
                List.of(
                        "Небольшое веб-приложение или REST API",
                        "Корпоративную информационную систему",
                        "Высоконагруженный серверный сервис",
                        "Приложение для автоматизации отдельных задач"
                )
        );

        System.out.println(question.getText());


        for (int i = 0; i < question.getOptions().size(); i++) {
            System.out.println(
                    (i + 1) + ") " + question.getOptions().get(i)
            );
        }

    }
}
