package com.amyliascarlet.jsontest.bvt.serializer.filters;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.ValueFilter;

import junit.framework.TestCase;

public class ValueFilterTest_field_int extends TestCase {

    public void test_valuefilter() throws Exception {
        ValueFilter filter = new ValueFilter() {

            public Object process(Object source, String name, Object value) {
                if (name.equals("id")) {
                    return "AAA";
                }

                return value;
            }

        };


        Bean a = new Bean();
        String text = JSON.toJSONString(a, filter);

        Assert.assertEquals("{\"id\":\"AAA\"}", text);
    }

    public static class Bean {

        public int    id;
        public String name;


    }
}
