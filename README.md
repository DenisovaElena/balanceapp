# Test Task
Страница для регистрации пользователя, а также для логина пользователей. У каждого пользователя после логина отображается баланс.

Задание приведено в [Tech_Test_Task.pdf](PlatformaOFD_Test_Task.pdf)

Использованный стек технологий: Java 8, Spring MVC, Spring Security, Apache Tiles 3, Tomcat 8.

Дополнительный стек технологий (+): jQuery, Ajax, Bootstrap 4, Awesome Icons, Noty.

Согласно заданию, приложение реализовано без использования ORM-фреймворков.

Слой сервисов реализует все CRUD-операции (в целях масштабирования).

Слой контроллеров состоит из абстрактного контроллера, содержащего CRUD-операции (в целях масштабирования) и ProfileRestController, который реализует требуемые в разработанном приложении операции регистрации и отображения данных пользователя.

Покрытие тестами: реализовано 13 JUnit-тестов на слои сервиса и контроллера.

В качестве БД выбрана HSQLDB (InFile).

Packaging приложения: WAR.

##Тестовые пользователи:

### User1:

    Логин: user1
    Пароль: user1

### User2:

    Логин: user2
    Пароль: user2
