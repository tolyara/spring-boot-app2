package com.springboot.app2.wiki.oop;

/**
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Why is Java not 100% OOP language?
 *
 * Because it still have 8 primitive types - byte, int etc.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Can we overload a static method?
 *
 * Yes
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Can we override a static method?
 *
 * We can declare static methods with the same signature in the subclass, but it is not considered overriding as there won’t be any run-time polymorphism.
 * Hence the answer is ‘No’.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Can we return more specified type in overriding method of subclass?
 *
 * Yes, but not vise versa (Class4)
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 *
 *
 */

public class OOPBasics {

    public static void main(String[] args) {
//        OOPBasics.test("qwerty");
//        OOPBasics.test(10);

        System.out.println(Class5.test());
        System.out.println(Class55.test());
    }

    public static void test(String s) {
        System.out.println("String : " + s);
    }

    public static void test(Integer i) {
        System.out.println("Integer : " + i);
    }

}

class OOPBasics2 extends OOPBasics {

    public static void test(String s) {
        System.out.println("String : " + s);
    }

}

class OOPBasics3 {

    public String test(String s) {
        System.out.println("String : ");
        return s;
    }

    /**
     * 'test(String)' is already defined in 'com.springboot.app2.wiki.oop.OOPBasics3'
     */
//    public Integer test(String s) {
//        System.out.println("String : " + s);
//        return 0;
//    }

}

class Class4 {

    public Object test(String s) {
        System.out.println("String : ");
        return 0;
    }

}

class Class44 extends Class4 {

    @Override
    public Integer test(String s) {
        System.out.println("String : ");
        return 1;
    }

}

class Class5 {

    public static Integer test() {
        return 0;
    }

    private void test2() {}

}

class Class55 extends Class5 {

    public static Integer test() {
        return 1;
    }

//    @Override
    private void test2() {}     // not override, just the method with same signature as in parent class
    // Class5'; attempting to assign weaker access privileges ('private'); was 'packageLocal'

}
