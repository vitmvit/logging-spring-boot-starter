# logging-spring-boot-starter

Данный стартер представляет собой автоконфигурацию для логирования.

## Инструкция по установке

Для работы данного стартера необходимо запустить таску build, она автоматически выгрузит прoект в локальный maven
репозиторий.

В build.gradle основного проекта:

- Необходимо указать mavenLocal() в repositories
    ```text
        repositories {
            mavenLocal()
            mavenCentral()
        }
    ```
- Необходимо добавить зависимость на стартер в dependencies:
    ```text
        implementation "ru.clevertec.news:logging-spring-boot-starter:1.0"
    ```

Далее необходимо указать аннотацию @Log над необходимым классом

## Пример работы

```text
CommentController.getById:
Request: [53]
Response: <200 OK OK,ru.clevertec.news.dto.CommentDto@7d469f0c,[]>
Time: 167
```

