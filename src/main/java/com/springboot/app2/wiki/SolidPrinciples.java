package com.springboot.app2.wiki;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 *
 * SOLID - это принципы разработки программного обеспечения, следуя которым Вы получите хороший код, который в дальнейшем будет хорошо масштабироваться и поддерживаться в рабочем состоянии.
 *
 * S - Single Responsibility Principle - Каждый класс должен иметь только одну зону ответственности.
 *
 * O - Open closed Principle - Классы должны быть открыты для расширения, но закрыты для изменения.
 *
 * L - Liskov substitution Principle - Должна быть возможность вместо базового (родительского) типа (класса) подставить любой его подтип (класс-наследник),
 * при этом работа программы не должна измениться.
 *
 * I -  Interface Segregation Principle - Данный принцип обозначает, что не нужно заставлять клиента (класс) реализовывать интерфейс, который не имеет к нему отношения.
 *
 * D - Dependency Inversion Principle - Модули верхнего уровня не должны зависеть от модулей нижнего уровня.
 * И те, и другие должны зависеть от абстракции. Абстракции не должны зависеть от деталей. Детали должны зависеть от абстракций.
 *
 */
public class SolidPrinciples {

    public static void main(String[] args) {
//        Account account = new Account();
//        account.payment("", BigDecimal.ONE);
//        Account salaryAccount = new SalaryAccount();
//        salaryAccount.payment("", BigDecimal.ONE);
//        Account depositAccount = new DepositAccount();
//        depositAccount.payment("", BigDecimal.ONE); // UnsupportedOperationException: Operation not supported

        PaymentAccount paymentAccount = new PaymentAccount();
        paymentAccount.payment("", BigDecimal.ONE);
        PaymentAccount salaryAccount = new SalaryAccount();
        salaryAccount.payment("", BigDecimal.ONE); // Now replacing the PaymentAccount class with its descendant class SalaryAccount will not "break" our program
    }

}

/**
 * Liskov demo
 */
class Account {

    public BigDecimal balance(String numberAccount) {
        //logic
        return null;
    }

    public void refill(String numberAccount, BigDecimal sum) {
        //logic
    }

//    public void payment(String numberAccount, BigDecimal sum) {
//        //logic
//    }

}

class PaymentAccount extends Account {

    public void payment(String numberAccount, BigDecimal sum) {
        //logic
    }

}

//class SalaryAccount extends Account {
class SalaryAccount extends PaymentAccount {
    @Override
    public BigDecimal balance(String numberAccount){
        //logic
        return null;
    };
    @Override
    public void refill(String numberAccount, BigDecimal sum){
        //logic
    }
    @Override
    public void payment(String numberAccount, BigDecimal sum){
        //logic
    }
}

class DepositAccount extends Account {

    @Override
    public BigDecimal balance(String numberAccount) {
        //logic
        return null;
    }

    @Override
    public void refill(String numberAccount, BigDecimal sum) {
        //logic
    }

//    @Override
//    public void payment(String numberAccount, BigDecimal sum){
//        throw new UnsupportedOperationException("Operation not supported");
//    }

}