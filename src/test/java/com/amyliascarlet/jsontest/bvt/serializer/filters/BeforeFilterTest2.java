package com.amyliascarlet.jsontest.bvt.serializer.filters;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.BeforeFilter;

public class BeforeFilterTest2 extends TestCase {
    public void test_beforeFilter() throws Exception {
        BeforeFilter filter = new BeforeFilter() {
            
            @Override
            public void writeBefore(Object object) {
                this.writeKeyValue("id", 123);
            }
        };
        Assert.assertEquals(JSON.toJSONString(new VO(), filter), "{\"id\":123}");
    }
    
    public void test_beforeFilter2() throws Exception {
        BeforeFilter filter = new BeforeFilter() {
            
            @Override
            public void writeBefore(Object object) {
                this.writeKeyValue("id", 123);
                this.writeKeyValue("name", "wenshao");
            }
        };
        Assert.assertEquals(JSON.toJSONString(new VO(), filter), "{\"id\":123,\"name\":\"wenshao\"}");
    }
    
    public static class VO {
        
    }
}
