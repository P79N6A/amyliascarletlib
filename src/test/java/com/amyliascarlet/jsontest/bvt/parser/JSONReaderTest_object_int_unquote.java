package com.amyliascarlet.jsontest.bvt.parser;

import java.io.StringReader;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSONReader;
import com.amyliascarlet.lib.json.parser.JSONScanner;

public class JSONReaderTest_object_int_unquote extends TestCase {

    String text = "{f0:0,f1:1,f2:2,f3:3,f4:4, " + //
                  "f5:5,f6:6,f7:7,f8:8,f9:9}";

    public void test_read() throws Exception {

        JSONReader reader = new JSONReader(new StringReader(text));
        reader.startObject();

        int count = 0;
        while (reader.hasNext()) {
            String key = (String) reader.readObject();
            Integer value = reader.readInteger();
            count++;
        }
        Assert.assertEquals(10, count);

        reader.endObject();
        reader.close();
    }

    public void test_read_1() throws Exception {
        JSONReader reader = new JSONReader(new JSONScanner(text));
        reader.startObject();

        int count = 0;
        while (reader.hasNext()) {
            String key = (String) reader.readObject();
            Integer value = reader.readInteger();
            count++;
        }
        Assert.assertEquals(10, count);

        reader.endObject();
        reader.close();
    }
}
