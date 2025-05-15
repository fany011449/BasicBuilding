package com.dell.demo11_prroxy;

public interface UserService {
    void login(String loginName, String passWord) throws InterruptedException;
    void deleteUsers() throws InterruptedException;
    String[] selectUsers() throws InterruptedException;
}
