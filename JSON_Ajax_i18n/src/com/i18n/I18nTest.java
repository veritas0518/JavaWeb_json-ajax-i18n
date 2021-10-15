package com.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @ClassName: I18nTest
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/9/16 16:08
 **/

public class I18nTest {
    @Test
    public void testLocal() {
//        //获取你系统默认的语言，国家信息
//        Locale locale = Locale.getDefault();
//        System.out.println(locale);

        //获取中文，中文的常量的Locale对象
        System.out.println(Locale.CHINA);

        System.out.println(Locale.US);
    }

    @Test
    public void testI18n() {
        //得到我们需要的locale对象
        Locale locale = Locale.CHINA;
        //通过指定的basename和Locale对象，读取相应的配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        System.out.println("username:" + bundle.getString("username"));
        System.out.println("password:" + bundle.getString("password"));
        System.out.println("sex:" + bundle.getString("sex"));
        System.out.println("age:" + bundle.getString("age"));

    }
}
