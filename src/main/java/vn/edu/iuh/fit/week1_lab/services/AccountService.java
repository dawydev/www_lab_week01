package vn.edu.iuh.fit.week1_lab.services;

import vn.edu.iuh.fit.week1_lab.entities.Account;
import vn.edu.iuh.fit.week1_lab.repositories.AccountRepository;

public class AccountService {
    private AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account login(String accountId, String password) {
        return accountRepository.checkLogin(accountId, password);
    }
}
