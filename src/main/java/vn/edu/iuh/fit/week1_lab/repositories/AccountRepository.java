package vn.edu.iuh.fit.week1_lab.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.week1_lab.entities.Account;

public class AccountRepository {
   private Account account;
   private EntityManager entityManager;

    public AccountRepository() {
        this.entityManager = entityManager;
    }

    public Account checkLogin(String accountId, String password) {
        try {
            account = (Account) entityManager.createQuery("SELECT a FROM Account a WHERE a.accountId = :username AND a.password = :password")
                    .setParameter("username", accountId)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            account = null;
        }
        return account;
    }
}
