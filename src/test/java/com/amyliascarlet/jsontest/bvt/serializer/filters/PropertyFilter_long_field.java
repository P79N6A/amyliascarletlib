package com.amyliascarlet.jsontest.bvt.serializer.filters;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.PropertyFilter;
import com.amyliascarlet.lib.json.serializer.SerializeWriter;

public class PropertyFilter_long_field extends TestCase {

    public void test_0() throws Exception {
        PropertyFilter filter = new PropertyFilter() {

            public boolean apply(Object source, String name, Object value) {
                return false;
            }
        };

        SerializeWriter out = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        serializer.getPropertyFilters().add(filter);

        A a = new A();
        serializer.write(a);

        String text = out.toString();
        Assert.assertEquals("{}", text);
    }

    public void test_1() throws Exception {
        PropertyFilter filter = new PropertyFilter() {

            public boolean apply(Object source, String name, Object value) {
                if ("id".equals(name)) {
                    Assert.assertTrue(value instanceof Long);
                    return true;
                }
                return false;
            }
        };

        SerializeWriter out = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        serializer.getPropertyFilters().add(filter);

        A a = new A();
        serializer.write(a);

        String text = out.toString();
        Assert.assertEquals("{\"id\":0}", text);
    }

    public void test_2() throws Exception {
        PropertyFilter filter = new PropertyFilter() {

            public boolean apply(Object source, String name, Object value) {
                if ("name".equals(name)) {
                    return true;
                }
                return false;
            }
        };

        SerializeWriter out = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        serializer.getPropertyFilters().add(filter);

        A a = new A();
        a.name = "chennp2008";
        serializer.write(a);

        String text = out.toString();
        Assert.assertEquals("{\"name\":\"chennp2008\"}", text);
    }

    public void test_3() throws Exception {
        PropertyFilter filter = new PropertyFilter() {

            public boolean apply(Object source, String name, Object value) {
                if ("name".equals(name)) {
                    return true;
                }
                return false;
            }
        };

        SerializeWriter out = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        serializer.getPropertyFilters().add(filter);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "chennp2008");
        serializer.write(map);

        String text = out.toString();
        Assert.assertEquals("{\"name\":\"chennp2008\"}", text);
    }

    public void test_4() throws Exception {
        PropertyFilter filter = new PropertyFilter() {

            public boolean apply(Object source, String name, Object value) {
                if ("name".equals(name)) {
                    return false;
                }
                return true;
            }
        };

        SerializeWriter out = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        serializer.getPropertyFilters().add(filter);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 3);
        map.put("name", "chennp2008");
        serializer.write(map);

        String text = out.toString();
        Assert.assertEquals("{\"id\":3}", text);
    }

    public static class A {

        public long    id;
        public String name;


    }
}
