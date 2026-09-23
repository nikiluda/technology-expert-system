package com.example.knowledge;

import com.example.model.Question;
import com.example.model.Rule;
import com.example.model.Technology;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeBase {

    private final List<Question> questions;
    private final List<Technology> technologies;
    private final List<Rule> rules;

    public KnowledgeBase(List<Question> questions, List<Technology> technologies, List<Rule> rules) {
        this.questions = questions;
        this.technologies = technologies;
        this.rules = new ArrayList<>();

        createRules();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public static KnowledgeBase createDefault() {

        List<Question> questions = List.of(
                new Question(
                        1,
                        "Какой тип программного продукта вы разрабатываете?",
                        List.of(
                                "Корпоративная информационная система",
                                "Высоконагруженный backend-сервис",
                                "Быстрый REST API / MVP",
                                "Сервис обработки данных или AI",
                                "Системный или инфраструктурный сервис"
                        )
                ),

                new Question(
                        2,
                        "Какой ожидается уровень нагрузки?",
                        List.of(
                                "Небольшой — до 100 запросов/сек",
                                "Средний — 100–1 000 запросов/сек",
                                "Высокий — 1 000–10 000 запросов/сек",
                                "Очень высокий — более 10 000 запросов/сек"
                        )
                ),

                new Question(
                        3,
                        "Что является главным приоритетом проекта?",
                        List.of(
                                "Скорость разработки",
                                "Производительность",
                                "Надёжность и долгосрочная поддержка",
                                "Масштабируемость",
                                "Минимальное потребление ресурсов"
                        )
                ),

                new Question(
                        4,
                        "Какой опыт преобладает у команды?",
                        List.of(
                                "Java / JVM",
                                "C# / .NET",
                                "JavaScript / TypeScript",
                                "Python",
                                "Go"
                        )
                ),

                new Question(
                        5,
                        "Насколько важна развитая enterprise-экосистема?",
                        List.of(
                                "Практически не нужна",
                                "Желательны готовые библиотеки",
                                "Важна",
                                "Критически важна"
                        )
                ),

                new Question(
                        6,
                        "Какой размер команды?",
                        List.of(
                                "1–2 разработчика",
                                "3–5 разработчиков",
                                "6–15 разработчиков",
                                "Более 15 разработчиков"
                        )
                ),

                new Question(
                        7,
                        "Насколько критична производительность приложения?",
                        List.of(
                                "Обычная производительность вполне достаточна",
                                "Производительность важна",
                                "Высокая производительность — одно из ключевых требований",
                                "Максимальная производительность — критическое требование"
                        )
                ),

                new Question(
                        8,
                        "Насколько важна низкая нагрузка на инфраструктуру?",
                        List.of(
                                "Практически не имеет значения",
                                "Желательно экономить ресурсы",
                                "Очень желательно",
                                "Критически важно минимальное потребление CPU/RAM"
                        )
                ),

                new Question(
                        9,
                        "Какой тип API планируется использовать?",
                        List.of(
                                "REST",
                                "REST + WebSocket",
                                "gRPC",
                                "Несколько типов API",
                                "Пока API не определён"
                        )
                ),

                new Question(
                        10,
                        "Насколько важна строгая типизация?",
                        List.of(
                                "Не является приоритетом",
                                "Желательна",
                                "Важна",
                                "Критически важна"
                        )
                ),

                new Question(
                        11,
                        "Какой срок разработки?",
                        List.of(
                                "Несколько дней",
                                "Несколько недель",
                                "Несколько месяцев",
                                "Долгосрочный проект на годы"
                        )
                ),

                new Question(
                        12,
                        "Насколько важна возможность быстро масштабировать систему?",
                        List.of(
                                "Масштабирование практически не требуется",
                                "Возможен умеренный рост нагрузки",
                                "Система должна легко масштабироваться",
                                "Горизонтальное масштабирование — ключевое требование"
                        )
                ),

                new Question(
                        13,
                        "Какие дополнительные технологии планируется использовать?",
                        List.of(
                                "PostgreSQL / SQL",
                                "Docker / Kubernetes",
                                "Kafka / RabbitMQ",
                                "Redis / кэширование",
                                "Большой набор внешних сервисов и интеграций"
                        )
                ),

                new Question(
                        14,
                        "Насколько важна простота найма разработчиков?",
                        List.of(
                                "Команда уже сформирована",
                                "Планируется небольшой найм",
                                "Потребуется регулярно расширять команду",
                                "Нужно максимально большое количество потенциальных кандидатов"
                        )
                ),

                new Question(
                        15,
                        "Какой жизненный цикл предполагается у проекта?",
                        List.of(
                                "Небольшой эксперимент / прототип",
                                "Проект на 1–2 года",
                                "Долгосрочный продукт",
                                "Критически важная система, которую планируется поддерживать много лет"
                        )
                )
        );


        return new KnowledgeBase(
                questions,
                List.of(),
                List.of()

        );
    }

    private List<Technology> createTechnologies() {
        Technology java = new Technology(
                "Java",
                "Универсальный язык для корпоративных и backend-систем",
                1.0
        );

        Technology go = new Technology(
                "Go",
                "Язык для высокопроизводительных и масштабируемых сервисов",
                1.0
        );

        Technology csharp = new Technology(
                "C#",
                "Язык платформы .NET для корпоративных приложений",
                1.0
        );

        Technology nodeJs = new Technology(
                "Node.js",
                "Среда выполнения JavaScript для backend-разработки",
                1.0
        );

        Technology python = new Technology(
                "Python",
                "Язык для backend, анализа данных, автоматизации и AI",
                1.0
        );

        return List.of(
                java,
                go,
                csharp,
                nodeJs,
                python
        );
    }

    private void addRules(int questionId, double[][] weights) {

        for (int answerIndex = 0; answerIndex < weights.length; answerIndex++) {

            for (int technologyIndex = 0;
                 technologyIndex < technologies.size();
                 technologyIndex++) {

                double weight = weights[answerIndex][technologyIndex];

                rules.add(new Rule(
                        questionId,
                        answerIndex + 1,
                        technologies.get(technologyIndex),
                        weight
                ));
            }
        }
    }

    private void createRules() {

        double[][] q1Weights = {
                {2.0, 1.1, 1.8, 1.0, 1.1},
                {1.5, 2.0, 1.4, 1.3, 0.9},
                {1.1, 1.4, 1.1, 1.8, 1.7},
                {0.9, 1.0, 1.0, 0.9, 2.0},
                {1.1, 2.0, 1.2, 0.7, 0.6}
        };

        double[][] q2Weights = {
                {1.0, 1.0, 1.0, 1.0, 1.0},
                {1.2, 1.4, 1.2, 1.2, 1.0},
                {1.5, 1.8, 1.5, 1.4, 0.8},
                {1.7, 2.0, 1.6, 1.5, 0.6}
        };

        double[][] q3Weights = {
                {1.2, 1.3, 1.2, 1.8, 1.8},
                {1.5, 2.0, 1.5, 1.4, 0.8},
                {1.8, 1.5, 1.8, 1.1, 1.1},
                {1.7, 1.9, 1.6, 1.4, 0.9},
                {1.0, 2.0, 0.8, 1.4, 0.7}
        };

        double[][] q4Weights = {
                {2.0, 0.8, 0.9, 0.8, 0.8},
                {0.9, 0.8, 2.0, 0.8, 0.8},
                {0.8, 0.8, 0.8, 2.0, 1.0},
                {0.8, 0.9, 0.8, 1.0, 2.0},
                {0.8, 2.0, 0.8, 0.8, 0.8}
        };

        double[][] q5Weights = {
                {1.0, 1.0, 1.0, 1.0, 1.0},
                {1.2, 1.1, 1.2, 1.2, 1.2},
                {1.6, 1.2, 1.6, 1.2, 1.1},
                {2.0, 1.1, 2.0, 1.0, 0.9}
        };

        double[][] q6Weights = {
                {1.2, 1.3, 1.1, 1.5, 1.4},
                {1.2, 1.3, 1.2, 1.4, 1.3},
                {1.5, 1.5, 1.5, 1.2, 1.2},
                {1.7, 1.6, 1.7, 1.2, 1.1}
        };

        double[][] q7Weights = {
                {1.0, 1.0, 1.0, 1.0, 1.0},
                {1.2, 1.3, 1.2, 1.2, 1.0},
                {1.5, 1.7, 1.4, 1.3, 0.8},
                {1.7, 2.0, 1.6, 1.5, 0.6}
        };

        double[][] q8Weights = {
                {1.0, 1.0, 1.0, 1.0, 1.0},
                {1.1, 1.3, 1.1, 1.2, 1.1},
                {1.3, 1.6, 1.2, 1.3, 1.0},
                {1.5, 1.9, 1.3, 1.4, 0.9}
        };

        double[][] q9Weights = {
                {1.2, 1.2, 1.2, 1.5, 1.3},
                {1.2, 1.2, 1.1, 1.8, 1.2},
                {1.4, 1.8, 1.4, 1.1, 0.9},
                {1.6, 1.7, 1.5, 1.4, 1.1},
                {1.0, 1.0, 1.0, 1.0, 1.0}
        };

        double[][] q10Weights = {
                {1.0, 1.0, 1.0, 1.0, 1.0},
                {1.2, 1.3, 1.2, 1.1, 1.0},
                {1.5, 1.6, 1.5, 1.2, 1.1},
                {1.8, 1.8, 1.7, 1.3, 1.2}
        };

        double[][] q11Weights = {
                {1.1, 1.2, 1.1, 1.8, 1.7},
                {1.2, 1.3, 1.2, 1.7, 1.6},
                {1.5, 1.5, 1.5, 1.3, 1.2},
                {1.8, 1.7, 1.8, 1.1, 1.0}
        };

        double[][] q12Weights = {
                {1.0, 1.0, 1.0, 1.0, 1.0},
                {1.2, 1.3, 1.2, 1.2, 1.0},
                {1.6, 1.7, 1.5, 1.4, 0.9},
                {1.8, 2.0, 1.6, 1.5, 0.7}
        };

        double[][] q13Weights = {
                {1.3, 1.2, 1.3, 1.3, 1.4},
                {1.5, 1.6, 1.5, 1.4, 1.3},
                {1.6, 1.8, 1.5, 1.4, 1.2},
                {1.5, 1.7, 1.5, 1.6, 1.2},
                {1.7, 1.5, 1.6, 1.5, 1.5}
        };

        double[][] q14Weights = {
                {1.0, 1.0, 1.0, 1.0, 1.0},
                {1.2, 1.1, 1.2, 1.3, 1.2},
                {1.4, 1.1, 1.5, 1.5, 1.3},
                {1.6, 1.0, 1.7, 1.7, 1.5}
        };

        double[][] q15Weights = {
                {1.0, 1.0, 1.0, 1.0, 1.0},
                {1.2, 1.2, 1.2, 1.3, 1.2},
                {1.6, 1.4, 1.6, 1.2, 1.1},
                {1.9, 1.5, 1.8, 1.0, 0.9}
        };


        addRules(1, q1Weights);
        addRules(2, q2Weights);
        addRules(3, q3Weights);
        addRules(4, q4Weights);
        addRules(5, q5Weights);
        addRules(6, q6Weights);
        addRules(7, q7Weights);
        addRules(8, q8Weights);
        addRules(9, q9Weights);
        addRules(10, q10Weights);
        addRules(11, q11Weights);
        addRules(12, q12Weights);
        addRules(13, q13Weights);
        addRules(14, q14Weights);
        addRules(15, q15Weights);

        System.out.println("Questions: " + questions.size());
        System.out.println("Technologies: " + technologies.size());
        System.out.println("Rules: " + rules.size());
    }

}
