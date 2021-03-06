package com.amyliascarlet.jsontest.bvt.serializer.stream;

import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;


public class StreamWriterTest_writeJSONStringTo extends TestCase {
    public void test_0() throws Exception {
        StringWriter out = new StringWriter();
        
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("a", 123);
        
        JSON.writeJSONStringTo(map, out);
        
        String text = out.toString();
        Assert.assertEquals("{\"a\":123}", text);
    }
}
