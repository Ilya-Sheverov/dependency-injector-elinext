# Dependency-injector-elinext

Тестовое задание, которое заключается в написании простейшего Dependency Injection-контейнера.

## Table of Contents

* [description](README.md#description)
* [technologies](README.md#technologies)
* [quick build](README.md#Quick-Build)
* [style guide](README.md#style-guide)
* [todo](README.md#todo)

## Description
[to the table of contents](README.md#table-of-contents)

Используя *Java Reflection API* и классы из пакета *java.lang.reflect* реализовать простейшую версию *Dependency Injection-контейнера*.
Результатом работы должен стать *Maven* (или *Gradle*) проект, который может собираться в одну или несколько JAR-библиотек.
Сторонние библиотеки использовать запрещено. Весь код должен быть написан вами. За исключением библиотек для тестирования.
Для проверки работы библиотеки должны быть написаны Unit-тесты. Основные функциональные требования можно прочитать [здесь](FUNCTIONAL_REQUIREMENTS.md). 

Как пользоваться библиотекой можно посмотреть [здесь](HOW_TO_USE_IT.md). 

## Technologies
[to the table of contents](README.md#table-of-contents)

В проекте используется:

1. Java 11;
2. JUnit 5;
3. Maven
4. Git

## Quick Build

[to the table of contents](README.md#table-of-contents)

##### Для того, чтобы собрать у себя библиотеку у вас должно быть установлено:

1. Java 11 или выше;
2. Maven 4.0 или выше;
3. Git.

##### Инструкция по сборке:

1. Скачайте репозиторий при помощи команды :

   `$ git clone https://github.com/Ilya-Sheverov/dependency-injector-elinext.git`

   После чего у вас появится директория *dependency-injector-elinext*.

2. Далее необходимо собрать **.jar**. Для этого зайдите в директорию где находится pom.xml и выполните команду в консоли:

     `mvn package`

      Или сразу сохраните библиотеку в ваш локальный maven-репозиторий.

     `mvn install`

   И добавьте зависимость в ваш pom.xml.
   ```xml
   <dependency>
       <groupId>com.github.sheverov.ilya</groupId>
       <artifactId>dependency-injector-elinext</artifactId>
       <version>1.5</version>
   </dependency>
   ```

## Style Guide

[to the table of contents](README.md#table-of-contents)

В проекте используется  [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html),
за исключением пункта [4.2 Block indentation](https://google.github.io/styleguide/javaguide.html#s4.2-block-indentation).
Использую **block indentation**= +4 пробела, вместо 2.

## TODO

- [X] Контейнер должен работать в многопоточной среде. То, как реализовано у меня сейчас, возможно,
[не работает](http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html).
Сделать метод для получения singleton бина потокобезопасным возможно добавив synchronized
для метода  `synchronized  public <T> T getBean(Class<T> type)` класса BindingBeansContext.class, но это сделает контейнер не производительным.
- [X] Добавить тест для проверки, что мой контейнер корректно будет работать в многопоточной среде.
- [X] Аргументы конструктора могут быть классами, реализующими добавленный в байдинг интерфейс.
Если аргумент конструктора является классом,то возникает следующая **проблема**:
Если у класса существует два интерфейса и один и тот же класс будет зарегистрирован под разными интерфейсами, может возникнуть вопрос, а какой интерфейс выбрать.
Если учесть, что кроме внедрения зависимости через конструктор происходить ничего не будет, то это не проблема,
но если потом потребуется добавить условно динамический прокси, то через какой интерфейс его реализовывать остаётся для меня под вопросом.
- [X] В случае, если метод `checkBindings()`не был вызван, предотвратить ошибку StackOverflowError.
- [ ] Написать алгоритм метода `checkBindings()` более эффективно.
- [ ] Пересмотреть архитектуру, сделать её гибкой и интуитивно понятной.
- [ ] Написать JavaDoc.

