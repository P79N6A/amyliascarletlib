package com.amyliascarlet.jsontest.bvt.serializer.stream;

import java.io.StringWriter;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.serializer.SerializeWriter;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;


public class StreamWriterTest_writeFieldValue_long extends TestCase {
    public void test_0() throws Exception {
        StringWriter out = new StringWriter();
        
        SerializeWriter writer = new SerializeWriter(out, 10);
        writer.config(SerializerFeature.QuoteFieldNames, true);
        Assert.assertEquals(10, writer.getBufferLength());
        
        writer.writeFieldValue(',', "abcde01245abcde", 123L);
        writer.close();
        
        String text = out.toString();
        Assert.assertEquals(",\"abcde01245abcde\":123", text);
    }
}
