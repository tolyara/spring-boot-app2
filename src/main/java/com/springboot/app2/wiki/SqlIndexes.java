package com.springboot.app2.wiki;

/**
 * https://habr.com/ru/post/247373/
 *
 * tree structure, Root level - Intermediate level - Leaf level
 *
 * Кластеризованный индекс
 * Кластеризованный индекс хранит реальные строки данных в листьях индекса.
 * Возвращаясь к предыдущему примеру, это означает что строка данных, связанная со значение ключа,
 * равного 123 будет храниться в самом индексе. Важной характеристикой кластеризованного индекса является то,
 * что все значения отсортированы в определенном порядке либо возрастания, либо убывания.
 * Таким образом, таблица или представление может иметь только один кластеризованный индекс.
 * В дополнение следует отметить, что данные в таблице хранятся в отсортированном виде только в случае если создан кластеризованный индекс у этой таблицы.
 * Таблица не имеющая кластеризованного индекса называется кучей.
 *
 * Некластеризованный индекс
 * В отличие от кластеризованного индекса, листья некластеризованного индекса содержат только те столбцы (ключевые),
 * по которым определен данный индекс, а также содержит указатель на строки с реальными данными в таблице.
 * Это означает, что системе подзапросов необходима дополнительная операция для обнаружения и получения требуемых данных.
 * Содержание указателя на данные зависит от способа хранения данных: кластеризованная таблица или куча.
 * Если указатель ссылается на кластеризованную таблицу, то он ведет к кластеризованному индексу, используя который можно найти реальные данные.
 * Если указатель ссылается на кучу, то он ведет к конкретному идентификатору строки с данными.
 * Некластеризованные индексы не могут быть отсортированы в отличие от кластеризованных,
 * однако вы можете создать более одного некластеризованного индекса на таблице или представлении, вплоть до 999.
 * Это не означает, что вы должны создавать как можно больше индексов. Индексы могут как улучшить, так и ухудшить производительность системы.
 * В дополнение к возможности создать несколько некластеризованных индексов,вы можете также включить дополнительные столбцы (included column)
 * в свой индекс: на листьях индекса будет храниться не только значение самих индексированных столбцов, но и значения этих не индексированных дополнительных столбцов.
 * Этот подход позволит вам обойти некоторые ограничения, наложенные на индекс.
 * К примеру, вы можете включить неидексируемый столбец или обойти ограничение на длину индекса (900 байт в большинстве случаев).
 *
 *
 *
 * Проектирование индексов
 * Насколько полезны индексы могут быть, настолько аккуратно они должны быть спроектированы.
 * Поскольку индексы могут занимать значительное дисковое пространство, вы не захотите создавать индексов больше, чем необходимо.
 * В дополнение, индексы автоматически обновляются когда сама строка с данными обновляется,
 * что может привести к дополнительным накладным расходам ресурсов и падению производительности.
 * При проектирование индексов должно приниматься во внимание несколько соображений относительно базы данных и запросов к ней.
 *
 *
 * Рассмотрим следующие рекомендации при планировании стратегии индексирования:
 *
 * - Для таблиц которые часто обновляются используйте как можно меньше индексов.
 *
 * - Если таблица содержит большое количество данных, но их изменения незначительны, тогда используйте столько индексов,
 * сколько необходимо для улучшение производительности ваших запросов. Однако хорошо подумайте перед использованием индексов на небольших таблицах,
 * т.к. возможно использование поиска по индексу может занять больше времени, нежели простое сканирование всех строк.
 *
 * - Для кластеризованных индексов старайтесь использовать настолько короткие поля насколько это возможно.
 * Наилучшим образом будет применение кластеризованного индекса на столбцах с уникальными значениями и не позволяющими использовать NULL.
 * Вот почему первичный ключ часто используется как кластеризованный индекс.
 *
 * - Уникальность значений в столбце влияет на производительность индекса. В общем случае, чем больше у вас дубликатов в столбце,
 * тем хуже работает индекс. С другой стороны, чем больше уникальных значения, тем выше работоспособность индекса. Когда возможно используйте уникальный индекс.
 *
 * - Для составного индекса возьмите во внимание порядок столбцов в индексе.
 * Столбцы, которые используются в выражениях WHERE (к примеру, WHERE FirstName = 'Charlie') должны быть в индексе первыми.
 * Последующие столбцы должны быть перечислены с учетом уникальности их значений (столбцы с самым высоким количеством уникальных значений идут первыми).
 *
 * - Также можно указать индекс на вычисляемых столбцах, если они соответствуют некоторым требованиям.
 * К примеру, выражение которые используются для получения значения столбца, должны быть детерминистическими
 * (всегда возвращать один и тот же результат для заданного набора входных параметров).
 *
 *
 * Дополнительно следует использовать следующие принципы:
 *
 * Старайтесь вставлять или модифицировать в одном запросе как можно больше строк, а не делать это в несколько одиночных запросов.
 * Создайте некластеризованный индекс на столбцах которые часто используются в ваших запросах в качестве условий поиска в WHERE и соединения в JOIN.
 * Рассмотрите возможность индексирования столбцов, использующихся в запросах поиска строк на точное соответствие значений.
 *
 */
public class SqlIndexes {
}