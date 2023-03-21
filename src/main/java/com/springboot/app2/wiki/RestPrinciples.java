package com.springboot.app2.wiki;

/**
 * Всего в REST есть шесть требований к проектированию API. Пять из них обязательные, одно — опциональное:
 *
 * Клиент-серверная модель (client-server model).
 * Отсутствие состояния (statelessness).
 * Кэширование (cacheability).
 * Единообразие интерфейса (uniform interface).
 * Многоуровневая система (layered system).
 * Код по требованию (code on demand) — необязательно. -> (В REST позволяется загрузка и выполнение кода или программы на стороне клиента)
 *
 *
 *
 * Четыре принципа единого интерфейса:
 *
 * - Identification of resources (основан на ресурсах). В REST ресурсом является все то, чему можно дать имя. Например,пользователь, изображение, предмет (майка, голодная собака, текущая погода) и т.д. Каждый ресурс в REST должен быть идентифицирован посредством стабильного идентификатора, который не меняется при изменении состояния ресурса. Идентификатором в REST является URI.
 * - Manipulation of resources through representations. (Манипуляции над ресурсами через представления). Представление в REST используется для выполнения действий над ресурсами. Представление ресурса представляет собой текущее или желаемое состояние ресурса. Например, если ресурсом является пользователь, то представлением может являться XML или HTML описание этого пользователя.
 * - Self-descriptive messages (само-документируемые сообщения). Под само-описательностью имеется ввиду, что запрос и ответ должны хранить в себе всю необходимую информацию для их обработки. Не должны быть дополнительные сообщения или кэши для обработки одного запроса. Другими словами отсутствие состояния, сохраняемого между запросами к ресурсам. Это очень важно для масштабирования системы.
 * - HATEOAS (hypermedia as the engine of application state). Статус ресурса передается через содержимое body, параметры строки запроса, заголовки запросов и запрашиваемый URI (имя ресурса). Это называется гипермедиа (или гиперссылки с гипертекстом). HATEOAS также означает, что, в случае необходимости ссылки могут содержатся в теле ответа (или заголовках) для поддержки URI , извлечения самого объекта или запрошенных объектов.
 *
 *
 *
 * REST — это архитектурный стиль API. Он не ограничивается никакими протоколами и не имеет собственных методов.
 * Но обычно в RESTful-сервисах используют стандарт HTTP, а файлы передают в формате JSON или XML.
 *
 * REST-подход к архитектуре позволяет сделать сервисы отказоустойчивыми, гибкими и производительными,
 * а при их масштабировании и внесении изменений не возникает больших сложностей.
 *
 */
public class RestPrinciples {
}