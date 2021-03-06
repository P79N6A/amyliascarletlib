package com.amyliascarlet.jsontest.bvt.bug;

import java.util.List;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;

import junit.framework.TestCase;

public class Bug_for_issue_555 extends TestCase {

    public void test_for_issue() throws Exception {
        JSON.parseObject("{\"list\":[{\"spec\":{}}]}", A.class);
    }

    public static class A {

        public List<B> list;
    }

    public static class B {

        @JSONField(serialize = true, deserialize = false)
        public Spec spec;
    }

    public static class Spec {
        private int id;
        
        public Spec(int id) {
            this.id = id;
        }
    }
}
