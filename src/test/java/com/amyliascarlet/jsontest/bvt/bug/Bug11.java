package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;

public class Bug11 extends TestCase {

    public void test_bug11() throws Exception {
        String text = "[{KH:\"(2010-2011-2)-13105-13039-1\", JC:\"1\"}] ";
        JSON.parse(text);
        System.out.println(text);
    }
}
