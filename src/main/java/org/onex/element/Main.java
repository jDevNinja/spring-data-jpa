package org.onex.element;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);

    AccountRepository accountRepository =
        context.getBean("accountRepository", AccountRepository.class);

    // метод getById() возвращает прокси объекта
    Account getById = accountRepository.getById(1);

    // к этому моменту сессия уже закрыта
    //    System.out.println(getById); // будет брошено org.hibernate.LazyInitializationException

    Account findById = accountRepository.findById(1).get();
    List<Account> allByIdGreaterThan = accountRepository.findAllByIdGreaterThan(45);

    System.out.println("Аккаунт с id 1: " + findById);
    System.out.println("Аккаунт с id > 45: " + allByIdGreaterThan);
  }
}
