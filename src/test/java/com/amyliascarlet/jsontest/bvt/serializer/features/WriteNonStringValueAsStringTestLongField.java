package com.amyliascarlet.jsontest.bvt.serializer.features;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

import junit.framework.TestCase;

public class WriteNonStringValueAsStringTestLongField extends TestCase {
    public void test_0() throws Exception {
        VO vo = new VO();
        vo.id = 100;
        
        String text = JSON.toJSONString(vo, SerializerFeature.WriteNonStringValueAsString);
         Assert.assertEquals("{\"id\":\"100\"}", text);
    }
    
    public static class VO {
        public long id;
    }
}
