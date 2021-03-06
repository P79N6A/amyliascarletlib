package com.amyliascarlet.jsontest.bvt.parser;

import java.util.Map;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;


public class ProductViewTest extends TestCase {
    public void test_parse() throws Exception {
        String text = "{\"code\":0,\"message\":\"Register Successfully!\",\"status\":\"OK\"}";
        Map map = JSON.parseObject(text, Map.class);
        System.out.println(map.get("code").getClass());
    }
}
