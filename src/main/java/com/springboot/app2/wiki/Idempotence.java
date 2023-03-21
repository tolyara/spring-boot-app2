package com.springboot.app2.wiki;

/**
 *
 * Метод HTTP является идемпотентным, если повторный идентичный запрос, сделанный один или несколько раз подряд,
 * имеет один и тот же эффект, не изменяющий состояние сервера.
 * Другими словами, идемпотентный метод не должен иметь никаких побочных эффектов (side-effects),
 * кроме сбора статистики или подобных операций.
 * Корректно реализованные методы GET, HEAD, PUT и DELETE идемпотентны, но не метод POST. Также все безопасные методы являются идемпотентными.
 *
 * Метод HTTP является безопасным, если он не меняет состояние сервера.
 * Другими словами, безопасный метод проводит операции "только чтение" (read-only).
 * Несколько следующих методов HTTP безопасные: GET, HEAD или OPTIONS.
 * Все безопасные методы являются также идемпотентными, как и некоторые другие, но при этом небезопасные, такие как PUT или DELETE.
 *
 * Для идемпотентности нужно рассматривать только изменение фактического внутреннего состояния сервера,
 * а возвращаемые запросами коды статуса могут отличаться: первый вызов DELETE вернёт код 200,
 * в то время как последующие вызовы вернут код 404.
 * Из идемпотентности DELETE неявно следует, что разработчики не должны использовать метод DELETE при реализации RESTful API с функциональностью удалить последнюю запись.
 *
 */
public class Idempotence {
}
