package com.amyliascarlet.jsontest.bvt.serializer;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.serializer.JSONSerializer;
import com.amyliascarlet.lib.json.serializer.SerializeWriter;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class MapTest extends TestCase {

    public void test_no_sort() throws Exception {
        JSONObject obj = new JSONObject(true);
        obj.put("name", "jobs");
        obj.put("id", 33);
        String text = toJSONString(obj);
        Assert.assertEquals("{'name':'jobs','id':33}", text);
    }
    
    public void test_null() throws Exception {
        JSONObject obj = new JSONObject(true);
        obj.put("name", null);
        String text = JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue);
        Assert.assertEquals("{\"name\":null}", text);
    }

    public static final String toJSONString(Object object) {
        SerializeWriter out = new SerializeWriter();

        try {
            JSONSerializer serializer = new JSONSerializer(out);
            serializer.config(SerializerFeature.SortField, false);
            serializer.config(SerializerFeature.UseSingleQuotes, true);

            serializer.write(object);

            return out.toString();
        } catch (StackOverflowError e) {
            throw new JSONException("maybe circular references", e);
        } finally {
            out.close();
        }
    }
}
