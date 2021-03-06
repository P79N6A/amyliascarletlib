package com.amyliascarlet.jsontest.bvt.serializer.filters;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.NameFilter;
import com.amyliascarlet.lib.json.serializer.SerializeWriter;

import junit.framework.TestCase;

public class NameFilterTest_IntegerKey extends TestCase {

    public void test_namefilter() throws Exception {
        NameFilter filter = new NameFilter() {

            public String process(Object source, String name, Object value) {
                if (name.equals("1001")) {
                    return "ID";
                }

                return name;
            }

        };

        SerializeWriter out = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        serializer.getNameFilters().add(filter);

        Map map = new HashMap();
        map.put(1001, 0);
        serializer.write(map);

        String text = out.toString();
        Assert.assertEquals("{\"ID\":0}", text);
    }

}
