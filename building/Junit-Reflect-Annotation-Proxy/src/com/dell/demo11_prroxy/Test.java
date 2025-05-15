package com.dell.demo11_prroxy;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        UserServiceImplement userServiceImplement = new UserServiceImplement();
        UserService proxy = ProxyUtil.createProxy(userServiceImplement);
        proxy.login("admin", "123456");
        proxy.selectUsers();
        proxy.deleteUsers();
    }
}
