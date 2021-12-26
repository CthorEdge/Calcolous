package com.calcoulus;

public class Authenticate {

    public Account setLogin(String username, String password, Postgres database){
        if (database.checkLoginCredentials(username, password)){
            return database.reloadRegisteredAccount(username);
        }
        return null;
    }
    public Account setRegister(String username, String password, int weight, Postgres database){
        if (!database.thereRegisteredAccount(username)){
            return new Account(username, password, weight, 0);
        }
        return null;
    }
}
