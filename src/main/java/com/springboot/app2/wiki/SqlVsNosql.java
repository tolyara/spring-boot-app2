package com.springboot.app2.wiki;

/**
 *
 * https://habr.com/ru/companies/ruvds/articles/727474/
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * SQL (Structured Query Language) — это язык структурированных запросов, используемый для управления и манипулирования реляционными базами данных.
 * SQL-базы данных применяются там, где необходимо хранить и управлять данными структурированной природы,
 * например, информацией о продуктах, покупателях и оформленных заказах в магазине.
 *
 * NoSQL (Not Only SQL) — это широкий термин, который относится к нереляционным моделям баз данных,
 * которые используют различные структуры для хранения данных: документы, ключ-значение, столбцовые и графовые БД.
 * NoSQL-базы данных применяются, когда необходимо хранить данные неструктурированной природы, например, большие объёмы текстовых данных, изображения и видео.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * SQL-базы данных используют реляционную модель данных, где информация хранится в таблицах, связанных между собой.
 * В таблице имеется набор столбцов, каждый из которых соответствует определённому типу данных.
 * Например, целочисленные данные, строки, даты, время, нулевые значения, булевы значения и т. д.
 * Это означает, что набор данных может быть разбит на отдельные поля для каждого вида информации.
 * В SQL-базах данных используется язык запросов SQL, который позволяет пользователям создавать таблицы, добавлять, изменять и удалять данные,
 * а также запрашивать информацию из базы данных.
 *
 * NoSQL-базы данных имеют более гибкую модель данных, которая не требует таблиц и связей, как в SQL-базах.
 * Как правило, данные в NoSQL-базах хранятся в документах, коллекциях или графах.
 * Документ — это структурированный контейнер для хранения данных в формате пар ключ-значение, где пары могут иметь разные типы данных.
 * Коллекция — это группа документов, связанных между собой. Граф — это набор вершин и связей между ними.
 * NoSQL-базы данных используют специальные языки запросов, которые позволяют пользователям запрашивать и манипулировать данными,
 * такие как: MongoDB Query Language для MongoDB, Cassandra Query Language для Apache Cassandra и т. д.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * SQL-базы данных обычно используют реляционную модель, где данные хранятся в таблицах, связанных с друг другом.
 * Данные в таблицах структурированы по строгим правилам и могут быть связаны с помощью внешних ключей.
 * Эта структура данных делает SQL-базы данных хорошо подходящими для хранения и обработки структурированных данных.
 * Однако эта модель не подходит для хранения неструктурированных данных, таких как изображения, звуковые файлы, видеоматериалы и т. д.
 *
 * NoSQL-базы данных используют нереляционную модель хранения данных, где данные могут храниться в виде «ключ-значение», документов, графов и т. д.
 * В NoSQL-базах данных нет строгих правил для организации данных, что делает их более гибкими для хранения различных типов данных и структур.
 * Однако эта гибкость может повредить производительности при обработке данных в некоторых случаях.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Что касается производительности, то SQL-базы данных обычно имеют высокую производительность при работе с сильно структурированными данными
 * и большими объёмами информации, поскольку они могут использовать оптимизированные индексы и быстрые алгоритмы сортировки/фильтрации данных.
 * Однако при работе с неструктурированными данными, производительность SQL-баз может снижаться.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * S и NoS бд имеют различные механизмы для обеспечения надёжности и устойчивости, но их методы зависят от конкретного решения и его требований к надёжности и безопасности.
 *
 * В SQL-базах данных используется транзакционная модель, которая позволяет сохранять целостность данных и обеспечивать ACID свойства для отказоустойчивости и надёжности бд.
 * Также SQL-базы данных могут использовать процессы резервного копирования и восстановления для обеспечения сохранности данных и минимизации потерь в случае сбоя.
 *
 * В NoSQL-базах данных, которые редко используют транзакционные модели, обычно применяется распределённая архитектура, чтобы повысить надёжность и отказоустойчивость.
 * Кластеризация и репликация данных помогают минимизировать вероятность потери данных и обеспечить их доступность в случае отказа ноды или узла.
 *
 * Если сравнивать, то у SQL-баз данных есть ряд преимуществ по сравнению с NoSQL. Например, в SQL можно легко установить ограничения на доступ к данным для разных пользователей,
 * а также применять различные аутентификационные механизмы для обеспечения безопасности данных.
 * При этом SQL-базы данных имеют лучшую поддержку транзакционности, что позволяет автоматически откатывать изменения при обнаружении проблемных транзакций и,
 * таким образом, нивелировать возможные проблемы безопасности.
 *
 * С другой стороны, у NoSQL-баз данных есть некоторые преимущества в области безопасности. Например, MongoDB и Couchbase используют документо-ориентированную модель,
 * что делает их более непроницаемыми для атак с использованием SQL-инъекций.
 * В NoSQL-базах данных также применяются методы шифрования данных, что обеспечивает более высокий уровень безопасности.
 * Однако в NoSQL-базах данных разработчики должны самостоятельно реализовывать механизмы безопасности, что может привести к возможным проблемам,
 * если разработчик недостаточно опытен или внимателен при разработке.
 *
 */
public class SqlVsNosql {
}
