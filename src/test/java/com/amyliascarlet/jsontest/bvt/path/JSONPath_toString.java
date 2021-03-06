package com.amyliascarlet.jsontest.bvt.path;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONPath;

import junit.framework.TestCase;

public class JSONPath_toString extends TestCase {
    public void test_toJSONString() throws Exception {
        Model model = new Model();
        model.path = new JSONPath("$");
        String text = JSON.toJSONString(model);
        Assert.assertEquals("{\"path\":\"$\"}", text);
        
        JSON.parseObject(text, Model.class);
    }

    public static class Model {
        public JSONPath path;
    }
}
