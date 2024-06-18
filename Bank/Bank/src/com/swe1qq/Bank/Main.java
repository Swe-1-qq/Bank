package com.swe1qq.Bank;

import static com.swe1qq.Bank.ui.MenuHandler.startMenu;
import com.swe1qq.Bank.model.Account;
import com.swe1qq.Bank.logic.BankCard;
import com.swe1qq.Bank.logic.AuthenticationService;
import com.swe1qq.Bank.model.Person;
import com.swe1qq.Bank.model.Product;


public class Main {

  public static void main(String[] args) {
    Person[] people = Person.personCreate();
    Account.createAccountsForPeople(people);

    Product[] product =Product.createProducts();
    Person authenticatedPerson = AuthenticationService.performAuthentication(people);
    BankCard card = BankCard.generateBankCardForAccount(authenticatedPerson.getAccount());

    if (authenticatedPerson != null) {
      System.out.println("Авторизація успішна");
      authenticatedPerson.displayInfo();
      card.displayInfo();
      startMenu(authenticatedPerson.getAccount(),card);
    } else {
      System.out.println("Невірне ім'я користувача або пароль.");
    }
  }
}