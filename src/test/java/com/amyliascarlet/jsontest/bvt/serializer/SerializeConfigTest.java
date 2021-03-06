package com.amyliascarlet.jsontest.bvt.serializer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializeConfig;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;

public class SerializeConfigTest extends TestCase {

    public void test_0() throws Exception {
        SerializeConfig config = new SerializeConfig();

        Method method = SerializeConfig.class.getDeclaredMethod("createJavaBeanSerializer", Class.class);
        method.setAccessible(true);
        Exception error = null;
        try {
            method.invoke(config, int.class);
        } catch (InvocationTargetException ex) {
            error = ex;
        }
        Assert.assertNotNull(error);
    }

    public void test_1() throws Exception {
        SerializeConfig config = new SerializeConfig();
        config.setTypeKey("%type");
        Assert.assertEquals("%type", config.getTypeKey());

        Assert.assertEquals("{\"%type\":\"java.util.LinkedHashMap\"}",
                            JSON.toJSONString(new LinkedHashMap(), config, SerializerFeature.WriteClassName));
    }
}
