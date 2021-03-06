package com.amyliascarlet.jsontest.bvt.bug;

import java.io.StringReader;
import java.util.Date;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONReader;
import com.amyliascarlet.lib.json.annotation.JSONField;

import junit.framework.TestCase;

public class Issue744 extends TestCase {

    public static class Model {
        @JSONField(format="yyyy-MM-dd'T'HH:mm:ss")
        public Date date;
    }
    
    public void test() {
        String text = "{\"date\":\"9999-09-08T00:00:00\"}";
        Model model =JSON.parseObject(text, Model.class);

        String text2 = JSON.toJSONString(model);
        System.out.println(text2);
    }

    public void test_reader() {
        String text = "{\"date\":\"9999-09-08T00:00:00\"}";

        Model model = new JSONReader(new StringReader(text)).readObject(Model.class);

        String text2 = JSON.toJSONString(model);
        System.out.println(text2);
    }
}
