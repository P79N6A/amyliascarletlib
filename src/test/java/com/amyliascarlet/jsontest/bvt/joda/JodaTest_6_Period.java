package com.amyliascarlet.jsontest.bvt.joda;

import com.amyliascarlet.lib.json.JSON;
import junit.framework.TestCase;
import org.joda.time.Period;

public class JodaTest_6_Period extends TestCase {
    public void test_for_joda_0() throws Exception {

       Model m = new Model();
       m.period = Period.days(3);

       String json = JSON.toJSONString(m);

       assertEquals("{\"period\":\"P3D\"}", json);

       Model m1 = JSON.parseObject(json, Model.class);
       assertEquals(m.period, m1.period);
    }

    public static class Model {
        public Period period;
    }
}
