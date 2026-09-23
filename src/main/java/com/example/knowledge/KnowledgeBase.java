package com.example.knowledge;

import com.example.model.Question;
import com.example.model.Rule;
import com.example.model.Technology;
import com.example.model.TechnologyCategory;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeBase {

    private final List<Question> questions;
    private final List<Technology> technologies;
    private final List<Rule> rules;

    public KnowledgeBase(List<Question> questions, List<Technology> technologies, List<Rule> rules) {
        this.questions = questions;
        this.technologies = technologies;
        this.rules = rules;
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
                        "Какой технологический стек наиболее знаком команде?",
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
                        "Какой характер взаимодействия между клиентом и системой?",
                        List.of(
                                "Классический HTTP API для web/mobile клиентов",
                                "Двунаправленная связь и real-time обновления",
                                "Взаимодействие между backend-сервисами",
                                "Публичный API для внешних клиентов",
                                "Несколько типов взаимодействия одновременно"
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
                        "Какой тип данных преимущественно используется в системе?",
                        List.of(
                                "Структурированные данные с чёткой схемой",
                                "Связанные структурированные данные",
                                "Документы / JSON / динамическая структура",
                                "События и временные ряды",
                                "Смешанный тип данных"
                        )
                ),

                new Question(
                        14,
                        "Как компоненты системы должны взаимодействовать между собой?",
                        List.of(
                                "В основном синхронно через HTTP",
                                "Преимущественно синхронно, но возможны фоновые задачи",
                                "Значительная часть взаимодействия должна быть асинхронной",
                                "Система должна быть построена вокруг событий",
                                "Используется смешанный подход"
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
                ),

                new Question(
                        16,
                        "Как система должна обрабатывать данные?",
                        List.of(
                                "В основном обычные CRUD-операции",
                                "Периодическая обработка больших объёмов",
                                "Постоянный поток событий",
                                "Асинхронная обработка фоновых задач",
                                "Смешанный вариант"
                        )
                ),

                new Question(
                        17,
                        "Насколько важна строгая согласованность данных?",
                        List.of(
                                "Допустима eventual consistency",
                                "Согласованность желательна",
                                "Согласованность важна",
                                "Строгая транзакционная согласованность критична"
                        )
                ),

                new Question(
                        18,
                        "Какой характер нагрузки ожидается?",
                        List.of(
                               "Равномерная",
                                "Пиковая",
                                "Резко меняющаяся",
                                "Постоянно высокая",
                                "Непредсказуемая"
                        )
                ),

                new Question(
                        19,
                        "Нужна ли асинхронная обработка операций?",
                        List.of(
                                "Практически не нужна",
                                "Иногда требуется",
                                "Важная часть системы",
                                "Основной способ взаимодействия компонентов"
                        )
                ),

                new Question(
                        20,
                        "Как должна развёртываться система?",
                        List.of(
                                "Один сервер / локальное окружение",
                                "Несколько серверов",
                                "Облачная инфраструктура",
                                "Динамическое горизонтальное масштабирование",
                                "Распределённая production-инфраструктура"
                        )
                )

        );

        List<Technology> backendLanguages = createBackendLanguages();
        List<Technology> databases = createDatabases();
        List<Technology> messageBrokers = createMessageBrokers();
        List<Technology> caches = createCaches();
        List<Technology> apis = createApis();
        List<Technology> containerization = createContainerization();

        List<Technology> technologies = new ArrayList<>();

        technologies.addAll(backendLanguages);
        technologies.addAll(databases);
        technologies.addAll(messageBrokers);
        technologies.addAll(caches);
        technologies.addAll(apis);
        technologies.addAll(containerization);

        List<Rule> rules = new ArrayList<>();

        createRules(
                backendLanguages,
                databases,
                messageBrokers,
                caches,
                apis,
                containerization,
                rules
        );

        KnowledgeBase knowledgeBase = new KnowledgeBase(
                questions,
                technologies,
                rules
        );

        // TODO: убрать в будущем
        System.out.println("Questions: " + knowledgeBase.getQuestions().size());
        System.out.println("Technologies: " + knowledgeBase.getTechnologies().size());
        System.out.println("Rules: " + knowledgeBase.getRules().size());

        return knowledgeBase;
    }

    private static List<Technology> createBackendLanguages() {
        Technology java = new Technology(
                "Java",
                "Универсальный язык для корпоративных и backend-систем",
                TechnologyCategory.BACKEND_LANGUAGE,
                1.0
        );

        Technology go = new Technology(
                "Go",
                "Язык для высокопроизводительных и масштабируемых сервисов",
                TechnologyCategory.BACKEND_LANGUAGE,
                1.0
        );

        Technology csharp = new Technology(
                "C#",
                "Язык платформы .NET для корпоративных приложений",
                TechnologyCategory.BACKEND_LANGUAGE,
                1.0
        );

        Technology nodeJs = new Technology(
                "Node.js",
                "Среда выполнения JavaScript для backend-разработки",
                TechnologyCategory.BACKEND_LANGUAGE,
                1.0
        );

        Technology python = new Technology(
                "Python",
                "Язык для backend, анализа данных, автоматизации и AI",
                TechnologyCategory.BACKEND_LANGUAGE,
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

    private static List<Technology> createDatabases() {

        Technology postgresql = new Technology(
                "PostgreSQL",
                "Реляционная СУБД для надёжных и транзакционных приложений",
                TechnologyCategory.DATABASE,
                1.0
        );

        Technology mysql = new Technology(
                "MySQL",
                "Реляционная СУБД для веб- и прикладных систем",
                TechnologyCategory.DATABASE,
                1.0
        );

        Technology mongodb = new Technology(
                "MongoDB",
                "Документно-ориентированная NoSQL база данных",
                TechnologyCategory.DATABASE,
                1.0
        );

        return List.of(
                postgresql,
                mysql,
                mongodb
        );
    }

    private static List<Technology> createMessageBrokers() {

        Technology kafka = new Technology(
                "Kafka",
                "Распределённая платформа потоковой передачи событий",
                TechnologyCategory.MESSAGE_BROKER,
                1.0
        );

        Technology rabbitMq = new Technology(
                "RabbitMQ",
                "Брокер сообщений для асинхронного взаимодействия сервисов",
                TechnologyCategory.MESSAGE_BROKER,
                1.0
        );

        return List.of(
                kafka,
                rabbitMq
        );
    }

    private static List<Technology> createCaches() {

        Technology redis = new Technology(
                "Redis",
                "Высокопроизводительное in-memory хранилище и система кэширования",
                TechnologyCategory.CACHE,
                1.0
        );

        Technology memcached = new Technology(
                "Memcached",
                "Простое распределённое in-memory кэширование",
                TechnologyCategory.CACHE,
                1.0
        );

        return List.of(
                redis,
                memcached
        );
    }

    private static List<Technology> createApis() {

        Technology rest = new Technology(
                "REST",
                "Архитектурный стиль для построения HTTP API",
                TechnologyCategory.API,
                1.0
        );

        Technology grpc = new Technology(
                "gRPC",
                "Высокопроизводительный RPC-фреймворк для взаимодействия сервисов",
                TechnologyCategory.API,
                1.0
        );

        Technology graphql = new Technology(
                "GraphQL",
                "Язык запросов и среда выполнения для API",
                TechnologyCategory.API,
                1.0
        );

        return List.of(
                rest,
                grpc,
                graphql
        );
    }

    private static List<Technology> createContainerization() {

        Technology docker = new Technology(
                "Docker",
                "Платформа контейнеризации приложений",
                TechnologyCategory.CONTAINERIZATION,
                1.0
        );

        Technology kubernetes = new Technology(
                "Kubernetes",
                "Платформа оркестрации контейнеризированных приложений",
                TechnologyCategory.CONTAINERIZATION,
                1.0
        );

        return List.of(
                docker,
                kubernetes
        );
    }

    private static void addRules(
            int questionId,
            double[][] weights,
            List<Technology> technologies,
            List<Rule> rules
    ) {

        for (int answerIndex = 0; answerIndex < weights.length; answerIndex++) {

            for (int technologyIndex = 0;
                 technologyIndex < technologies.size();
                 technologyIndex++) {

                rules.add(new Rule(
                        questionId,
                        answerIndex + 1,
                        technologies.get(technologyIndex),
                        weights[answerIndex][technologyIndex]
                ));
            }
        }
    }

    private static void createRules(
            List<Technology> backendLanguages,
            List<Technology> databases,
            List<Technology> messageBrokers,
            List<Technology> caches,
            List<Technology> apis,
            List<Technology> containerization,
            List<Rule> rules) {

        double[][] q1BackendWeights = {
                {2.0, 1.0, 1.8, 0.9, 0.8},
                {1.4, 2.0, 1.3, 1.1, 1.5},
                {1.3, 1.2, 1.5, 2.0, 1.1},
                {1.0, 1.2, 1.0, 2.0, 1.4},
                {1.0, 1.5, 1.0, 0.8, 2.0}
        };
        double[][] q1DatabaseWeights = {
                {1.8, 1.7, 1.1},
                {1.7, 1.4, 1.2},
                {1.2, 1.1, 1.3},
                {1.2, 1.0, 1.8},
                {1.3, 1.2, 1.3}
        };
        double[][] q1BrokerWeights = {
                {1.3, 1.4},
                {1.8, 1.5},
                {1.0, 1.0},
                {1.8, 1.4},
                {1.7, 1.3}
        };
        double[][] q1CacheWeights = {
                {1.4, 1.2},
                {1.7, 1.2},
                {1.3, 1.2},
                {1.8, 1.2},
                {1.5, 1.1}
        };
        double[][] q1ApiWeights = {
                {1.8, 1.1, 1.2},
                {1.5, 1.8, 1.0},
                {2.0, 1.1, 1.5},
                {1.3, 1.4, 1.8},
                {1.2, 1.8, 1.0}
        };
        double[][] q1ContainerWeights = {
                {1.3, 1.1},
                {1.6, 1.8},
                {1.4, 1.1},
                {1.5, 1.6},
                {1.5, 1.9}
        };
        addRules(1, q1BackendWeights, backendLanguages, rules);
        addRules(1, q1DatabaseWeights, databases, rules);
        addRules(1, q1BrokerWeights, messageBrokers, rules);
        addRules(1, q1CacheWeights, caches, rules);
        addRules(1, q1ApiWeights, apis, rules);
        addRules(1, q1ContainerWeights, containerization, rules);


        double[][] q2BackendWeights = {
                {1.0, 1.0, 1.0, 1.1, 1.2},
                {1.2, 1.3, 1.2, 1.2, 1.3},
                {1.5, 1.7, 1.5, 1.3, 1.6},
                {1.7, 2.0, 1.6, 1.4, 1.8}
        };

        double[][] q2DatabaseWeights = {
                {1.0, 1.0, 1.0},
                {1.2, 1.2, 1.1},
                {1.5, 1.6, 1.3},
                {1.8, 1.9, 1.4}
        };

        double[][] q2BrokerWeights = {
                {1.0, 1.0},
                {1.2, 1.2},
                {1.6, 1.5},
                {1.9, 1.8}
        };

        double[][] q2CacheWeights = {
                {1.0, 1.0},
                {1.2, 1.1},
                {1.6, 1.3},
                {1.9, 1.5}
        };

        double[][] q2ApiWeights = {
                {1.0, 1.0, 1.0},
                {1.1, 1.2, 1.1},
                {1.2, 1.5, 1.3},
                {1.3, 1.8, 1.4}
        };

        double[][] q2ContainerWeights = {
                {1.0, 1.0},
                {1.2, 1.2},
                {1.5, 1.6},
                {1.8, 2.0}
        };

        addRules(2, q2BackendWeights, backendLanguages, rules);
        addRules(2, q2DatabaseWeights, databases, rules);
        addRules(2, q2BrokerWeights, messageBrokers, rules);
        addRules(2, q2CacheWeights, caches, rules);
        addRules(2, q2ApiWeights, apis, rules);
        addRules(2, q2ContainerWeights, containerization, rules);


        double[][] q3BackendWeights = {
                {1.3, 1.2, 1.2, 1.7, 1.5},
                {1.4, 1.8, 1.3, 1.2, 1.5},
                {1.8, 1.5, 1.8, 1.1, 1.1},
                {1.6, 1.8, 1.5, 1.2, 1.4},
                {1.2, 1.8, 1.2, 1.1, 1.7}
        };

        double[][] q3DatabaseWeights = {
                {1.2, 1.1, 1.1},
                {1.5, 1.5, 1.2},
                {1.8, 1.6, 1.3},
                {1.7, 1.5, 1.2},
                {1.3, 1.2, 1.1}
        };

        double[][] q3BrokerWeights = {
                {1.0, 1.2},
                {1.6, 1.5},
                {1.6, 1.8},
                {1.8, 1.6},
                {1.4, 1.3}
        };

        double[][] q3CacheWeights = {
                {1.2, 1.1},
                {1.5, 1.2},
                {1.7, 1.3},
                {1.7, 1.3},
                {1.5, 1.1}
        };

        double[][] q3ApiWeights = {
                {1.6, 1.1, 1.4},
                {1.3, 1.7, 1.2},
                {1.5, 1.4, 1.6},
                {1.4, 1.8, 1.5},
                {1.2, 1.6, 1.1}
        };

        double[][] q3ContainerWeights = {
                {1.2, 1.0},
                {1.4, 1.4},
                {1.6, 1.7},
                {1.6, 1.8},
                {1.3, 1.5}
        };

        addRules(3, q3BackendWeights, backendLanguages, rules);
        addRules(3, q3DatabaseWeights, databases, rules);
        addRules(3, q3BrokerWeights, messageBrokers, rules);
        addRules(3, q3CacheWeights, caches, rules);
        addRules(3, q3ApiWeights, apis, rules);
        addRules(3, q3ContainerWeights, containerization, rules);


        double[][] q4BackendWeights = {
                {2.0, 1.0, 1.8, 1.0, 1.0},
                {1.0, 2.0, 1.0, 1.0, 1.0},
                {1.0, 1.0, 2.0, 1.8, 1.0},
                {1.0, 1.0, 1.0, 1.0, 2.0},
                {1.2, 1.3, 1.2, 1.2, 1.2}
        };

        double[][] q4DatabaseWeights = {
                {1.5, 1.4, 1.1},
                {1.4, 1.3, 1.1},
                {1.4, 1.3, 1.1},
                {1.2, 1.1, 1.5},
                {1.3, 1.3, 1.2}
        };

        double[][] q4BrokerWeights = {
                {1.3, 1.2},
                {1.4, 1.4},
                {1.2, 1.2},
                {1.3, 1.4},
                {1.2, 1.2}
        };

        double[][] q4CacheWeights = {
                {1.3, 1.2},
                {1.3, 1.2},
                {1.2, 1.2},
                {1.2, 1.3},
                {1.2, 1.2}
        };

        double[][] q4ApiWeights = {
                {1.4, 1.2, 1.3},
                {1.3, 1.5, 1.2},
                {1.3, 1.5, 1.4},
                {1.2, 1.2, 1.5},
                {1.2, 1.4, 1.2}
        };

        double[][] q4ContainerWeights = {
                {1.3, 1.2},
                {1.3, 1.4},
                {1.2, 1.3},
                {1.2, 1.3},
                {1.2, 1.3}
        };

        addRules(4, q4BackendWeights, backendLanguages, rules);
        addRules(4, q4DatabaseWeights, databases, rules);
        addRules(4, q4BrokerWeights, messageBrokers, rules);
        addRules(4, q4CacheWeights, caches, rules);
        addRules(4, q4ApiWeights, apis, rules);
        addRules(4, q4ContainerWeights, containerization, rules);


        double[][] q5BackendWeights = {
                {1.0, 1.0, 1.0, 1.0, 1.0},
                {1.3, 1.1, 1.3, 1.1, 1.1},
                {1.7, 1.2, 1.7, 1.2, 1.1},
                {2.0, 1.2, 1.9, 1.0, 1.0}
        };

        double[][] q5DatabaseWeights = {
                {1.0, 1.0, 1.0},
                {1.2, 1.2, 1.1},
                {1.6, 1.5, 1.2},
                {1.9, 1.8, 1.2}
        };

        double[][] q5BrokerWeights = {
                {1.0, 1.0},
                {1.2, 1.2},
                {1.5, 1.5},
                {1.8, 1.8}
        };

        double[][] q5CacheWeights = {
                {1.0, 1.0},
                {1.2, 1.1},
                {1.5, 1.3},
                {1.8, 1.5}
        };

        double[][] q5ApiWeights = {
                {1.0, 1.0, 1.0},
                {1.2, 1.2, 1.1},
                {1.5, 1.5, 1.3},
                {1.8, 1.8, 1.5}
        };

        double[][] q5ContainerWeights = {
                {1.0, 1.0},
                {1.2, 1.2},
                {1.5, 1.5},
                {1.8, 2.0}
        };

        addRules(5, q5BackendWeights, backendLanguages, rules);
        addRules(5, q5DatabaseWeights, databases, rules);
        addRules(5, q5BrokerWeights, messageBrokers, rules);
        addRules(5, q5CacheWeights, caches, rules);
        addRules(5, q5ApiWeights, apis, rules);
        addRules(5, q5ContainerWeights, containerization, rules);


        double[][] q6BackendWeights = {
                {1.2, 1.2, 1.2, 1.3, 1.3},
                {1.3, 1.3, 1.3, 1.3, 1.3},
                {1.5, 1.5, 1.5, 1.4, 1.4},
                {1.7, 1.6, 1.7, 1.4, 1.3}
        };

        double[][] q6DatabaseWeights = {
                {1.1, 1.1, 1.2},
                {1.2, 1.2, 1.2},
                {1.4, 1.4, 1.3},
                {1.6, 1.5, 1.3}
        };

        double[][] q6BrokerWeights = {
                {1.0, 1.0},
                {1.2, 1.2},
                {1.5, 1.4},
                {1.8, 1.6}
        };

        double[][] q6CacheWeights = {
                {1.0, 1.0},
                {1.2, 1.1},
                {1.4, 1.3},
                {1.6, 1.4}
        };

        double[][] q6ApiWeights = {
                {1.1, 1.1, 1.1},
                {1.2, 1.2, 1.2},
                {1.4, 1.4, 1.3},
                {1.6, 1.7, 1.4}
        };

        double[][] q6ContainerWeights = {
                {1.0, 1.0},
                {1.2, 1.2},
                {1.5, 1.6},
                {1.8, 2.0}
        };

        addRules(6, q6BackendWeights, backendLanguages, rules);
        addRules(6, q6DatabaseWeights, databases, rules);
        addRules(6, q6BrokerWeights, messageBrokers, rules);
        addRules(6, q6CacheWeights, caches, rules);
        addRules(6, q6ApiWeights, apis, rules);
        addRules(6, q6ContainerWeights, containerization, rules);


        double[][] q7BackendWeights = {
                {1.0, 1.0, 1.0, 1.0, 1.0},
                {1.2, 1.3, 1.2, 1.2, 1.3},
                {1.5, 1.7, 1.4, 1.3, 1.5},
                {1.7, 2.0, 1.6, 1.4, 1.8}
        };

        double[][] q7DatabaseWeights = {
                {1.0, 1.0, 1.0},
                {1.2, 1.2, 1.1},
                {1.5, 1.6, 1.2},
                {1.8, 1.9, 1.3}
        };

        double[][] q7BrokerWeights = {
                {1.0, 1.0},
                {1.2, 1.2},
                {1.5, 1.4},
                {1.8, 1.7}
        };

        double[][] q7CacheWeights = {
                {1.0, 1.0},
                {1.2, 1.1},
                {1.6, 1.3},
                {1.9, 1.5}
        };

        double[][] q7ApiWeights = {
                {1.0, 1.0, 1.0},
                {1.1, 1.2, 1.1},
                {1.3, 1.5, 1.2},
                {1.4, 1.8, 1.3}
        };

        double[][] q7ContainerWeights = {
                {1.0, 1.0},
                {1.2, 1.2},
                {1.5, 1.6},
                {1.8, 2.0}
        };

        addRules(7, q7BackendWeights, backendLanguages, rules);
        addRules(7, q7DatabaseWeights, databases, rules);
        addRules(7, q7BrokerWeights, messageBrokers, rules);
        addRules(7, q7CacheWeights, caches, rules);
        addRules(7, q7ApiWeights, apis, rules);
        addRules(7, q7ContainerWeights, containerization, rules);



        double[][] q8BackendWeights = {
                {1.0, 1.0, 1.0, 1.0, 1.0},
                {1.1, 1.3, 1.1, 1.2, 1.3},
                {1.2, 1.6, 1.2, 1.3, 1.5},
                {1.3, 1.9, 1.3, 1.4, 1.7}
        };

        double[][] q8DatabaseWeights = {
                {1.0, 1.0, 1.0},
                {1.1, 1.2, 1.1},
                {1.2, 1.5, 1.2},
                {1.3, 1.8, 1.3}
        };

        double[][] q8BrokerWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.3, 1.2},
                {1.5, 1.3}
        };

        double[][] q8CacheWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.3, 1.2},
                {1.5, 1.3}
        };

        double[][] q8ApiWeights = {
                {1.0, 1.0, 1.0},
                {1.1, 1.2, 1.0},
                {1.2, 1.4, 1.1},
                {1.3, 1.7, 1.2}
        };

        double[][] q8ContainerWeights = {
                {1.0, 1.0},
                {1.2, 1.3},
                {1.4, 1.6},
                {1.5, 1.9}
        };

        addRules(8, q8BackendWeights, backendLanguages, rules);
        addRules(8, q8DatabaseWeights, databases, rules);
        addRules(8, q8BrokerWeights, messageBrokers, rules);
        addRules(8, q8CacheWeights, caches, rules);
        addRules(8, q8ApiWeights, apis, rules);
        addRules(8, q8ContainerWeights, containerization, rules);


        double[][] q9BackendWeights = {
                {1.4, 1.2, 1.3, 1.3, 1.2},
                {1.3, 1.4, 1.2, 1.5, 1.2},
                {1.4, 1.8, 1.3, 1.2, 1.4},
                {1.5, 1.3, 1.5, 1.4, 1.3},
                {1.4, 1.5, 1.4, 1.4, 1.3}
        };

        double[][] q9DatabaseWeights = {
                {1.4, 1.3, 1.2},
                {1.3, 1.2, 1.2},
                {1.5, 1.4, 1.2},
                {1.4, 1.3, 1.3},
                {1.5, 1.4, 1.3}
        };

        double[][] q9BrokerWeights = {
                {1.0, 1.0},
                {1.2, 1.2},
                {1.8, 1.7},
                {1.9, 1.8},
                {1.6, 1.5}
        };

        double[][] q9CacheWeights = {
                {1.2, 1.1},
                {1.5, 1.2},
                {1.3, 1.2},
                {1.4, 1.2},
                {1.4, 1.2}
        };

        double[][] q9ApiWeights = {
                {1.9, 1.0, 1.2},
                {1.2, 1.1, 1.3},
                {1.1, 2.0, 1.1},
                {1.5, 1.3, 1.8},
                {1.5, 1.5, 1.5}
        };

        double[][] q9ContainerWeights = {
                {1.1, 1.0},
                {1.2, 1.3},
                {1.4, 1.6},
                {1.4, 1.5},
                {1.5, 1.6}
        };

        addRules(9, q9BackendWeights, backendLanguages, rules);
        addRules(9, q9DatabaseWeights, databases, rules);
        addRules(9, q9BrokerWeights, messageBrokers, rules);
        addRules(9, q9CacheWeights, caches, rules);
        addRules(9, q9ApiWeights, apis, rules);
        addRules(9, q9ContainerWeights, containerization, rules);


        double[][] q10BackendWeights = {
                {1.0, 1.0, 1.0, 1.0, 1.0},
                {1.2, 1.3, 1.2, 1.1, 1.2},
                {1.5, 1.6, 1.5, 1.2, 1.3},
                {1.8, 1.9, 1.8, 1.3, 1.5}
        };

        double[][] q10DatabaseWeights = {
                {1.0, 1.0, 1.0},
                {1.1, 1.2, 1.1},
                {1.3, 1.4, 1.2},
                {1.5, 1.6, 1.3}
        };

        double[][] q10BrokerWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.3, 1.3},
                {1.5, 1.5}
        };

        double[][] q10CacheWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.2, 1.2},
                {1.4, 1.3}
        };

        double[][] q10ApiWeights = {
                {1.0, 1.0, 1.0},
                {1.2, 1.3, 1.1},
                {1.4, 1.6, 1.3},
                {1.6, 1.9, 1.4}
        };

        double[][] q10ContainerWeights = {
                {1.0, 1.0},
                {1.1, 1.2},
                {1.3, 1.4},
                {1.5, 1.6}
        };

        addRules(10, q10BackendWeights, backendLanguages, rules);
        addRules(10, q10DatabaseWeights, databases, rules);
        addRules(10, q10BrokerWeights, messageBrokers, rules);
        addRules(10, q10CacheWeights, caches, rules);
        addRules(10, q10ApiWeights, apis, rules);
        addRules(10, q10ContainerWeights, containerization, rules);



        double[][] q11BackendWeights = {
                {1.2, 1.3, 1.2, 1.7, 1.6},
                {1.3, 1.4, 1.3, 1.6, 1.5},
                {1.5, 1.5, 1.5, 1.3, 1.2},
                {1.8, 1.8, 1.7, 1.2, 1.1}
        };

        double[][] q11DatabaseWeights = {
                {1.1, 1.1, 1.1},
                {1.3, 1.2, 1.1},
                {1.5, 1.4, 1.1},
                {1.8, 1.6, 1.0}
        };

        double[][] q11BrokerWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.4, 1.3},
                {1.7, 1.5}
        };

        double[][] q11CacheWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.3, 1.2},
                {1.5, 1.4}
        };

        double[][] q11ApiWeights = {
                {1.1, 1.0, 1.1},
                {1.2, 1.2, 1.1},
                {1.3, 1.4, 1.2},
                {1.5, 1.6, 1.3}
        };

        double[][] q11ContainerWeights = {
                {1.0, 1.0},
                {1.2, 1.2},
                {1.5, 1.5},
                {1.8, 1.8}
        };

        addRules(11, q11BackendWeights, backendLanguages, rules);
        addRules(11, q11DatabaseWeights, databases, rules);
        addRules(11, q11BrokerWeights, messageBrokers, rules);
        addRules(11, q11CacheWeights, caches, rules);
        addRules(11, q11ApiWeights, apis, rules);
        addRules(11, q11ContainerWeights, containerization, rules);


        double[][] q12BackendWeights = {
                {1.0, 1.0, 1.0, 1.0, 1.0},
                {1.2, 1.3, 1.2, 1.2, 1.1},
                {1.5, 1.7, 1.4, 1.3, 1.0},
                {1.8, 2.0, 1.6, 1.4, 0.9}
        };

        double[][] q12DatabaseWeights = {
                {1.0, 1.0, 1.0},
                {1.2, 1.2, 1.1},
                {1.5, 1.4, 1.1},
                {1.8, 1.7, 1.0}
        };

        double[][] q12BrokerWeights = {
                {1.0, 1.0},
                {1.2, 1.1},
                {1.5, 1.3},
                {1.8, 1.5}
        };

        double[][] q12CacheWeights = {
                {1.0, 1.0},
                {1.2, 1.1},
                {1.5, 1.3},
                {1.8, 1.5}
        };

        double[][] q12ApiWeights = {
                {1.1, 1.0, 1.1},
                {1.2, 1.3, 1.1},
                {1.4, 1.5, 1.2},
                {1.6, 1.8, 1.3}
        };

        double[][] q12ContainerWeights = {
                {1.0, 1.0},
                {1.3, 1.4},
                {1.6, 1.7},
                {1.9, 2.0}
        };

        addRules(12, q12BackendWeights, backendLanguages, rules);
        addRules(12, q12DatabaseWeights, databases, rules);
        addRules(12, q12BrokerWeights, messageBrokers, rules);
        addRules(12, q12CacheWeights, caches, rules);
        addRules(12, q12ApiWeights, apis, rules);
        addRules(12, q12ContainerWeights, containerization, rules);


        double[][] q13BackendWeights = {
                {1.4, 1.3, 1.3, 1.2, 1.2},
                {1.6, 1.5, 1.4, 1.3, 1.2},
                {1.3, 1.5, 1.2, 1.7, 1.4},
                {1.4, 1.7, 1.3, 1.2, 1.5},
                {1.3, 1.4, 1.3, 1.3, 1.3}
        };

        double[][] q13DatabaseWeights = {
                {1.8, 1.6, 1.0},
                {1.9, 1.7, 1.0},
                {1.2, 1.2, 1.9},
                {1.1, 1.1, 1.8},
                {1.4, 1.3, 1.4}
        };

        double[][] q13BrokerWeights = {
                {1.0, 1.0},
                {1.0, 1.0},
                {1.6, 1.4},
                {1.8, 1.5},
                {1.3, 1.2}
        };

        double[][] q13CacheWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.2, 1.1},
                {1.4, 1.3},
                {1.3, 1.2}
        };

        double[][] q13ApiWeights = {
                {1.2, 1.1, 1.2},
                {1.2, 1.1, 1.3},
                {1.2, 1.4, 1.5},
                {1.3, 1.6, 1.4},
                {1.3, 1.3, 1.3}
        };

        double[][] q13ContainerWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.3, 1.4},
                {1.4, 1.6},
                {1.2, 1.2}
        };

        addRules(13, q13BackendWeights, backendLanguages, rules);
        addRules(13, q13DatabaseWeights, databases, rules);
        addRules(13, q13BrokerWeights, messageBrokers, rules);
        addRules(13, q13CacheWeights, caches, rules);
        addRules(13, q13ApiWeights, apis, rules);
        addRules(13, q13ContainerWeights, containerization, rules);


        double[][] q14BackendWeights = {
                {1.2, 1.1, 1.1, 1.3, 1.1},
                {1.3, 1.2, 1.2, 1.3, 1.2},
                {1.5, 1.6, 1.4, 1.3, 1.4},
                {1.5, 1.7, 1.4, 1.2, 1.5},
                {1.3, 1.4, 1.3, 1.3, 1.3}
        };

        double[][] q14DatabaseWeights = {
                {1.2, 1.2, 1.1},
                {1.3, 1.3, 1.1},
                {1.4, 1.3, 1.1},
                {1.5, 1.4, 1.1},
                {1.3, 1.3, 1.2}
        };

        double[][] q14BrokerWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.7, 1.5},
                {1.9, 1.7},
                {1.4, 1.3}
        };

        double[][] q14CacheWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.3, 1.2},
                {1.4, 1.3},
                {1.2, 1.2}
        };

        double[][] q14ApiWeights = {
                {1.6, 1.1, 1.1},
                {1.4, 1.2, 1.2},
                {1.2, 1.6, 1.3},
                {1.1, 1.8, 1.3},
                {1.3, 1.4, 1.3}
        };

        double[][] q14ContainerWeights = {
                {1.0, 1.0},
                {1.1, 1.2},
                {1.4, 1.5},
                {1.5, 1.8},
                {1.3, 1.4}
        };

        addRules(14, q14BackendWeights, backendLanguages, rules);
        addRules(14, q14DatabaseWeights, databases, rules);
        addRules(14, q14BrokerWeights, messageBrokers, rules);
        addRules(14, q14CacheWeights, caches, rules);
        addRules(14, q14ApiWeights, apis, rules);
        addRules(14, q14ContainerWeights, containerization, rules);


        double[][] q15BackendWeights = {
                {1.0, 1.0, 1.0, 1.0, 1.0},
                {1.2, 1.2, 1.2, 1.3, 1.2},
                {1.6, 1.4, 1.6, 1.2, 1.1},
                {1.9, 1.5, 1.8, 1.0, 0.9}
        };

        double[][] q15DatabaseWeights = {
                {1.0, 1.0, 1.0},
                {1.2, 1.2, 1.1},
                {1.6, 1.5, 1.1},
                {1.9, 1.7, 1.0}
        };

        double[][] q15BrokerWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.4, 1.3},
                {1.7, 1.5}
        };

        double[][] q15CacheWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.3, 1.2},
                {1.5, 1.4}
        };

        double[][] q15ApiWeights = {
                {1.1, 1.0, 1.1},
                {1.2, 1.2, 1.1},
                {1.4, 1.5, 1.2},
                {1.6, 1.7, 1.3}
        };

        double[][] q15ContainerWeights = {
                {1.0, 1.0},
                {1.2, 1.2},
                {1.5, 1.5},
                {1.8, 1.9}
        };

        addRules(15, q15BackendWeights, backendLanguages, rules);
        addRules(15, q15DatabaseWeights, databases, rules);
        addRules(15, q15BrokerWeights, messageBrokers, rules);
        addRules(15, q15CacheWeights, caches, rules);
        addRules(15, q15ApiWeights, apis, rules);
        addRules(15, q15ContainerWeights, containerization, rules);


        double[][] q16BackendWeights = {
                {1.4, 1.2, 1.4, 1.2, 1.1},
                {1.5, 1.7, 1.5, 1.4, 1.2},
                {1.3, 1.7, 1.3, 1.2, 1.6},
                {1.4, 1.6, 1.4, 1.3, 1.5},
                {1.3, 1.5, 1.3, 1.3, 1.3}
        };

        double[][] q16DatabaseWeights = {
                {1.8, 1.5, 1.0},
                {1.6, 1.7, 1.0},
                {1.2, 1.3, 1.8},
                {1.3, 1.4, 1.6},
                {1.4, 1.3, 1.4}
        };

        double[][] q16BrokerWeights = {
                {1.0, 1.0},
                {1.4, 1.3},
                {1.8, 1.6},
                {1.7, 1.5},
                {1.3, 1.2}
        };

        double[][] q16CacheWeights = {
                {1.0, 1.0},
                {1.2, 1.2},
                {1.3, 1.4},
                {1.4, 1.3},
                {1.2, 1.2}
        };

        double[][] q16ApiWeights = {
                {1.3, 1.1, 1.2},
                {1.2, 1.4, 1.3},
                {1.2, 1.5, 1.5},
                {1.1, 1.4, 1.6},
                {1.3, 1.3, 1.3}
        };

        double[][] q16ContainerWeights = {
                {1.0, 1.0},
                {1.3, 1.4},
                {1.5, 1.6},
                {1.4, 1.6},
                {1.2, 1.3}
        };

        addRules(16, q16BackendWeights, backendLanguages, rules);
        addRules(16, q16DatabaseWeights, databases, rules);
        addRules(16, q16BrokerWeights, messageBrokers, rules);
        addRules(16, q16CacheWeights, caches, rules);
        addRules(16, q16ApiWeights, apis, rules);
        addRules(16, q16ContainerWeights, containerization, rules);


        double[][] q17BackendWeights = {
                {1.1, 1.1, 1.1, 1.3, 1.0},
                {1.3, 1.2, 1.3, 1.3, 1.1},
                {1.5, 1.4, 1.5, 1.2, 1.1},
                {1.8, 1.7, 1.8, 1.1, 1.0}
        };

        double[][] q17DatabaseWeights = {
                {1.0, 1.0, 1.3},
                {1.3, 1.2, 1.5},
                {1.6, 1.5, 1.4},
                {1.9, 1.8, 1.2}
        };

        double[][] q17BrokerWeights = {
                {1.2, 1.2},
                {1.3, 1.2},
                {1.4, 1.3},
                {1.5, 1.4}
        };

        double[][] q17CacheWeights = {
                {1.1, 1.1},
                {1.2, 1.2},
                {1.3, 1.3},
                {1.4, 1.4}
        };

        double[][] q17ApiWeights = {
                {1.2, 1.1, 1.2},
                {1.3, 1.2, 1.3},
                {1.4, 1.3, 1.4},
                {1.5, 1.4, 1.5}
        };

        double[][] q17ContainerWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.2, 1.3},
                {1.4, 1.5}
        };

        addRules(17, q17BackendWeights, backendLanguages, rules);
        addRules(17, q17DatabaseWeights, databases, rules);
        addRules(17, q17BrokerWeights, messageBrokers, rules);
        addRules(17, q17CacheWeights, caches, rules);
        addRules(17, q17ApiWeights, apis, rules);
        addRules(17, q17ContainerWeights, containerization, rules);


        double[][] q18BackendWeights = {
                {1.1, 1.1, 1.1, 1.2, 1.1},
                {1.3, 1.5, 1.3, 1.3, 1.2},
                {1.4, 1.7, 1.4, 1.3, 1.4},
                {1.6, 1.9, 1.5, 1.3, 1.2},
                {1.3, 1.5, 1.3, 1.3, 1.3}
        };

        double[][] q18DatabaseWeights = {
                {1.3, 1.2, 1.0},
                {1.5, 1.4, 1.0},
                {1.4, 1.3, 1.1},
                {1.5, 1.4, 1.0},
                {1.3, 1.3, 1.2}
        };

        double[][] q18BrokerWeights = {
                {1.0, 1.0},
                {1.5, 1.4},
                {1.7, 1.5},
                {1.8, 1.6},
                {1.4, 1.3}
        };

        double[][] q18CacheWeights = {
                {1.0, 1.0},
                {1.3, 1.2},
                {1.5, 1.4},
                {1.6, 1.5},
                {1.3, 1.2}
        };

        double[][] q18ApiWeights = {
                {1.1, 1.0, 1.1},
                {1.2, 1.3, 1.2},
                {1.3, 1.5, 1.3},
                {1.4, 1.6, 1.4},
                {1.3, 1.3, 1.3}
        };

        double[][] q18ContainerWeights = {
                {1.0, 1.0},
                {1.3, 1.4},
                {1.5, 1.6},
                {1.6, 1.8},
                {1.3, 1.4}
        };

        addRules(18, q18BackendWeights, backendLanguages, rules);
        addRules(18, q18DatabaseWeights, databases, rules);
        addRules(18, q18BrokerWeights, messageBrokers, rules);
        addRules(18, q18CacheWeights, caches, rules);
        addRules(18, q18ApiWeights, apis, rules);
        addRules(18, q18ContainerWeights, containerization, rules);


        double[][] q19BackendWeights = {
                {1.1, 1.1, 1.1, 1.2, 1.1},
                {1.3, 1.4, 1.3, 1.3, 1.2},
                {1.5, 1.6, 1.4, 1.3, 1.4},
                {1.7, 1.9, 1.5, 1.3, 1.3}
        };

        double[][] q19DatabaseWeights = {
                {1.1, 1.1, 1.0},
                {1.3, 1.2, 1.0},
                {1.4, 1.3, 1.1},
                {1.5, 1.4, 1.1}
        };

        double[][] q19BrokerWeights = {
                {1.0, 1.0},
                {1.3, 1.2},
                {1.7, 1.5},
                {1.9, 1.7}
        };

        double[][] q19CacheWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.3, 1.2},
                {1.5, 1.4}
        };

        double[][] q19ApiWeights = {
                {1.2, 1.1, 1.1},
                {1.3, 1.2, 1.2},
                {1.2, 1.5, 1.3},
                {1.1, 1.7, 1.4}
        };

        double[][] q19ContainerWeights = {
                {1.0, 1.0},
                {1.2, 1.3},
                {1.4, 1.5},
                {1.6, 1.8}
        };

        addRules(19, q19BackendWeights, backendLanguages, rules);
        addRules(19, q19DatabaseWeights, databases, rules);
        addRules(19, q19BrokerWeights, messageBrokers, rules);
        addRules(19, q19CacheWeights, caches, rules);
        addRules(19, q19ApiWeights, apis, rules);
        addRules(19, q19ContainerWeights, containerization, rules);


        double[][] q20BackendWeights = {
                {1.1, 1.1, 1.2, 1.1, 1.1},
                {1.3, 1.3, 1.3, 1.2, 1.2},
                {1.4, 1.5, 1.4, 1.3, 1.4},
                {1.5, 1.7, 1.5, 1.3, 1.5},
                {1.4, 1.5, 1.4, 1.3, 1.4}
        };

        double[][] q20DatabaseWeights = {
                {1.2, 1.1, 1.0},
                {1.3, 1.2, 1.0},
                {1.5, 1.4, 1.1},
                {1.6, 1.5, 1.1},
                {1.4, 1.3, 1.2}
        };

        double[][] q20BrokerWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.4, 1.3},
                {1.6, 1.5},
                {1.5, 1.4}
        };

        double[][] q20CacheWeights = {
                {1.0, 1.0},
                {1.1, 1.1},
                {1.3, 1.2},
                {1.5, 1.4},
                {1.4, 1.3}
        };

        double[][] q20ApiWeights = {
                {1.1, 1.0, 1.1},
                {1.2, 1.2, 1.2},
                {1.3, 1.4, 1.3},
                {1.4, 1.6, 1.4},
                {1.3, 1.4, 1.3}
        };

        double[][] q20ContainerWeights = {
                {1.0, 1.0},
                {1.3, 1.4},
                {1.6, 1.7},
                {1.8, 2.0},
                {1.7, 1.8}
        };

        addRules(20, q19BackendWeights, backendLanguages, rules);
        addRules(20, q19DatabaseWeights, databases, rules);
        addRules(20, q19BrokerWeights, messageBrokers, rules);
        addRules(20, q19CacheWeights, caches, rules);
        addRules(20, q19ApiWeights, apis, rules);
        addRules(20, q19ContainerWeights, containerization, rules);



    }

}
