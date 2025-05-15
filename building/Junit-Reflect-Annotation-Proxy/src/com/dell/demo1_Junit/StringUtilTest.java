package com.dell.demo1_Junit;

import org.junit.Assert;
import org.junit.Test;

// 測試類：Junit單元測試框架
public class StringUtilTest {
    // 測試方法：必須public、無參、無返回值
    // 必須加上@Test

    @Test
    public void testPrintNumber(){
        // 測試步驟：
        StringUtil.printNumber("abc");

        // 測試範例
        StringUtil.printNumber("");
        StringUtil.printNumber(null);
    }

    @Test
    public void testGetMaxIndex() {
        // 測試步驟：
        int index1 = StringUtil.getIndex("aaaaaa");
        // 測試範例
        int index2 = StringUtil.getIndex("");
        int index3 = StringUtil.getIndex(null);

        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);

        // 斷言測試：斷言結果與預期結果是否一致
        Assert.assertEquals("error", 5, index1);
        Assert.assertEquals("error", -1, index2);
        Assert.assertEquals("error", -1, index3);
    }
}
