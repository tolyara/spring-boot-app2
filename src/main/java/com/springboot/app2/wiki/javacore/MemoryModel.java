package com.springboot.app2.wiki.javacore;

/**
 *
 * https://habr.com/ru/articles/510454/
 *
 * Java-модель памяти, используемая внутри JVM, делит память на стеки потоков (thread stacks) и кучу (heap).
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Каждый поток, работающий в виртуальной машине Java, имеет свой собственный стек. Стек содержит информацию о том, какие методы вызвал поток.
 * Как только поток выполняет свой код, стек вызовов изменяется.
 *
 * Стек потока содержит все локальные переменные для каждого выполняемого метода. Поток может получить доступ только к своему стеку.
 * Локальные переменные, невидимы для всех других потоков, кроме потока, который их создал.
 * Даже если два потока выполняют один и тот же код, они всё равно будут создавать локальные переменные этого кода в своих собственных стеках.
 * Таким образом, каждый поток имеет свою версию каждой локальной переменной.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Куча содержит все объекты, созданные в вашем приложении, независимо от того, какой поток создал объект.
 * К этому относятся и версии объектов примитивных типов (например, Byte, Integer, Long и т.д.).
 * Неважно, был ли объект создан и присвоен локальной переменной или создан как переменная-член другого объекта, он хранится в куче.
 *
 * Локальная переменная может быть примитивного типа, в этом случае она полностью хранится в стеке потока. *
 * Локальная переменная также может быть ссылкой на объект. В этом случае ссылка (локальная переменная) хранится в стеке потоков, но сам объект хранится в куче.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Объект может содержать методы, и эти методы могут содержать локальные переменные.
 * Эти локальные переменные также хранятся в стеке потоков, даже если объект, которому принадлежит метод, хранится в куче.
 *
 * Переменные-члены объекта хранятся в куче вместе с самим объектом.
 * Это верно как в случае, когда переменная-член имеет примитивный тип, так и в том случае, если она является ссылкой на объект.
 *
 * Статические переменные класса также хранятся в куче вместе с определением класса.
 *
 */
public class MemoryModel {
}
