package com.amyliascarlet.jsontest.bvt.serializer;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import junit.framework.TestCase;

/**
 * Created by wenshao on 09/01/2017.
 */
public class FloatFormatTest extends TestCase {
    public void test_format() throws Exception {
        Model model = new Model();
        model.value = 123.45678F;

        String str = JSON.toJSONString(model);
        assertEquals("{\"value\":123.46}", str);
    }

    public static class Model {
        @JSONField(format = "0.00")
        public float value;
    }
}
