package com.dell.demo11_prroxy;

public class UserServiceImplement implements UserService {
    @Override
    public void login(String loginName, String passWord) throws InterruptedException {

        if("admin".equals(loginName) && "123456".equals(passWord)){
            System.out.println("恭喜您登陸成功");
        } else {
            System.out.println("登入失敗");
        }
        Thread.sleep(1000);
    }

    @Override
    public void deleteUsers() throws InterruptedException {
        System.out.println("成功刪除一萬個用戶");
        Thread.sleep(1500);
    }

    @Override
    public String[] selectUsers() throws InterruptedException {
        System.out.println("查詢出三個用戶");
        String[] names = {"1","2","3"};
        Thread.sleep(2000);

        return names;
    }
}
