package com.amyliascarlet.jsontest.bvt.joda;

import com.amyliascarlet.lib.json.JSON;
import junit.framework.TestCase;
import org.joda.time.Duration;

public class JodaTest_6_Duration extends TestCase {
    public void test_for_joda_0() throws Exception {

       Model m = new Model();
       m.duration = new Duration(24L*60L*60L*1000L);

       String json = JSON.toJSONString(m);

       assertEquals("{\"duration\":\"PT86400S\"}", json);

       Model m1 = JSON.parseObject(json, Model.class);
       assertEquals(m.duration, m1.duration);
    }

    public static class Model {
        public Duration duration;
    }
}
