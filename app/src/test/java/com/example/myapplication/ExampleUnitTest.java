package com.example.myapplication;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    @Test
    public void addition_isCorrect() {

        String s = "赛格威机器人非常高兴与您同乘,我要去%s楼,到%s了后我会先下电梯";
        String aa = String.format(s, "1","1");

        System.out.println(aa);

    }

}




