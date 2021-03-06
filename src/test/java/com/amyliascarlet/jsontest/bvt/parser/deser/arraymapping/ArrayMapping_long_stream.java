package com.amyliascarlet.jsontest.bvt.parser.deser.arraymapping;

import java.io.StringReader;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSONReader;
import com.amyliascarlet.lib.json.parser.Feature;

import junit.framework.TestCase;

public class ArrayMapping_long_stream extends TestCase {
    public void test_for_error() throws Exception {
        
        JSONReader reader = new JSONReader(new StringReader("[1001,\"wenshao\"]"), Feature.SupportArrayToBean);
        Model model = reader.readObject(Model.class);
        Assert.assertEquals(1001, model.id);
        Assert.assertEquals("wenshao", model.name);
    }
    
    public static class Model {
        public long id;
        public String name;
        
    }
}
