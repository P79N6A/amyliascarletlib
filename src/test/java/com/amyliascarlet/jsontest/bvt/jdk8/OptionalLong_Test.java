package com.amyliascarlet.jsontest.bvt.jdk8;

import java.util.OptionalLong;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;

import junit.framework.TestCase;

public class OptionalLong_Test extends TestCase {

    public void test_optional() throws Exception {
        Model model = new Model();
        model.value = OptionalLong.empty();

        String text = JSON.toJSONString(model);

        Assert.assertEquals("{\"value\":null}", text);

        Model model2 = JSON.parseObject(text, Model.class);

        Assert.assertEquals(model2.value, model.value);
    }


    public static class Model {
        public OptionalLong value;

    }
}
