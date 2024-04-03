package com.springboot.app2.wiki.microservice;

/**
 *
 * https://habr.com/ru/companies/simbirsoft/articles/329970/
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Проблема
 * Если веб-ресурс становится достаточно популярным, может стать вопрос о том, что одного сервера для него недостаточно.
 * И тогда встает вопрос о распределении нагрузки между несколькими серверами.
 * Простейший вариант быстро распределить нагрузку – использовать несколько копий ресурса и репликацию базы данных.
 * А учитывая, что все действия такой системы никак не разделены, это порождает новые проблемы.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * CQRS – подход проектирования программного обеспечения, при котором код, изменяющий состояние, отделяется от кода, просто читающего это состояние.
 * Подобное разделение может быть логическим и основываться на разных уровнях. Кроме того, оно может быть физическим и включать разные звенья (tiers), или уровни.
 *
 * Основная идея CQS в том, что в объекте методы могут быть двух типов:
 * - Queries: Методы возвращают результат, не изменяя состояние объекта. Другими словами, у Query не никаких побочных эффектов.
 * - Commands: Методы изменяют состояние объекта, не возвращая значение.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * https://bool.dev/blog/detail/pattern-cqrs-i-event-sourcing
 *
 * Преимущества CQRS
 *
 * - Независимое масштабирование. CQRS позволяет раздельно масштабировать рабочие нагрузки чтения и записи, снижая риск конфликтов блокировки.
 * - Оптимизированные схемы данных. Для query применить схему, оптимизированную для запросов, а commands — другую схему, оптимизированную для обновлений.
 * - Безопасность. Разделение операций позволит настроить более гибкую систему доступа.
 * - Разделение проблем. Разделение операций позволяет получить более гибкие и простые в обслуживании классы.
 * - Более простые запросы. Сохраняя в базе данных для чтения materialized view, вы предотвратите использование сложных запросов и join'ов.
 * - Не требует 2 хранилища данных. Отдельные хранилища для query и command это одна из реализаций, а не обязательное требование
 *
 * Недостатки CQRS
 *
 * - Сложность. Основная идея CQRS звучит просто. Но ее реализация может привести к усложнению проекта приложения, особенно если реализовывать его в связке с Event Sourcing.
 * - Обмен сообщениями. Сама по себе модель CQRS не требует месседжинга, но месседж брокеры часто применяются для обработки команд и публикации событий.
 * Это означает, нужно будет реализовывать обработку сбоев и дубликатов при передаче сообщений.
 * - Eventual consistency. Если вы разделите базы данных для чтения и записи, в базе данных для чтения могут оставаться устаревшие данные.
 * БД для чтения должна быть up to date, чтобы отражать изменения из БД для записи, и может быть трудно трекать, когда пользователь сделал запрос на основе устаревших данных с БД для чтения.
 *
 *
 */
public class CQRS {
}