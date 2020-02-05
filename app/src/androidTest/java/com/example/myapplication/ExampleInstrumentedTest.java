package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {



        String s ="{\n" + "    \"tts\": [\n" + "        {\n" + "            \"type\": \"value\",\n" + "            \"text\": \"value\",\n" + "            \"interval\": 1\n" + "        },\n" + "        {\n" + "            \"type\": \"value\",\n" + "            \"text\": \"value\",\n" + "            \"interval\": 1\n" + "        }\n" + "    ]\n" + "}";
        JSONObject configObject = JSON.parseObject(s);

        JSONArray jsonArray = configObject.getJSONArray("tts");
        List<ArrayList> arr = JSON.parseArray(jsonArray.toString(),ArrayList.class);
    }
}
