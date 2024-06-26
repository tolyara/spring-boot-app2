package com.springboot.app2.wiki.microservice;

/**
 *
 * MONOLITH ADVANTAGES:
 * - easy to develop;
 * - easy to deploy;
 * - easy to debug and support;
 * - more productive, consumes less hardware resources if designed well;
 * - more productive, communication with services is simple and fast, no need to use http (or other) protocols;
 *
 * MONOLITH DISADVANTAGES:
 * - difficult to integrate new technologies, cannot easily implement new module on Python if all monolith is written on Java;
 * - code base becomes more cumbersome and thus threshold of entering new developer to project grows up;
 * - heavy to scale one concrete module, but it might be an advantage because in case of microservice we need to do a lot of movement/setup/changes
 * whereas with monolith we just need to rent one more server and put the code in there;
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * MICROSERVICE ADVANTAGES:
 * - independence of technologies;
 * - easy to scale a small feature/service;
 * - decentralized data management, each service might have their own database, changes made in db model of one service will not affect to other components;
 * - each service can have their own security filters;
 * - easy to split/distribute technical assignment/tasks between a few teams;
 *
 * MICROSERVICE DISADVANTAGES:
 * - difficult to develop/deploy/debug, always need to think about interaction between services when develop new features;
 * - need more extensive logging;
 * - testing the entire application;
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Optimal app development strategy:
 * - first develop basic structure (registration, item catalog, ordering, stock/storage/warehouse, shipping) as monolith,
 * client's business will get time advantage on competitive market to allocate niche;
 * - then if need to integrate new functionality (card billing), build it to separate microservice;
 * - then if some service requires scaling, move it to separate microservice and scale (setup 2, 3 or more instances of it);
 * - eventually, move essential features which potentially will need extension to separate microservice, bit by bit, gradually;
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * https://habr.com/ru/company/maxilect/blog/677128/
 *
 * Ways of communication betwwen microservices:
 * Synchronous:
 * -  REST-like, transfer protocols (http, soap);
 * Asynchronous:
 * - messaging (kafka, rabbitmq);
 *
 */
public class MicroserviceVsMonolith {
}
