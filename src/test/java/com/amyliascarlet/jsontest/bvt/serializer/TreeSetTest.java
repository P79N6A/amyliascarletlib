package com.amyliascarlet.jsontest.bvt.serializer;

import java.util.Collection;
import java.util.TreeSet;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;


public class TreeSetTest extends TestCase {
    
    public void test_null() throws Exception {
        VO vo = new VO();
        vo.setValue(new TreeSet());
        
        Assert.assertEquals("{\"@type\":\"com.amyliascarlet.jsontest.bvt.serializer.TreeSetTest$VO\",\"value\":TreeSet[]}", JSON.toJSONString(vo, SerializerFeature.WriteClassName));
    }

    public static class VO {

        private Collection value;

        public Collection getValue() {
            return value;
        }

        public void setValue(Collection value) {
            this.value = value;
        }

    }
}
