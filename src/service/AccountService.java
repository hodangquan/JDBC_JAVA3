/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import repository.AccountRepository;
import java.sql.*;
import java.util.List;
import model.Account;

/**
 *
 * @author hodangquan
 */
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService() {
        accountRepository = new AccountRepository();
    }

    public static String HashPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] resultArray = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : resultArray) {
                stringBuffer.append(String.format("%02x", b));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException ex) {
        }
        return "";
    }

    public boolean authention(String uesrname, String password) throws SQLException {
        Account account = accountRepository.getByUsername(uesrname);
        if (account.getUsername() == null || account.getPassword() == null) {
            return false;
        }
        if (!account.getPassword().equals(HashPassword(password))) {
            return false;
        }
        return true;
    }

    public boolean role(String username, String password) throws SQLException {
        List<Account> accounts = accountRepository.layDSAccounts();
        for (Account account : accounts) {
            if (account.getRole() == 0 && account.getUsername().equals(username) && account.getPassword().equals(HashPassword(password))) {
                return true;
            }
        }
        return false;
    }

}
