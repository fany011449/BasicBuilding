package com.dell.demo10_proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Star implements StarService{
    String name;

    @Override
    public void sing(String name) {
        System.out.println(this.name + "表演歌曲：" + name);
    }

    @Override
    public String dance() {
        System.out.println(this.name + "表演歌曲：" + name);
        return "THX";
    }
}
