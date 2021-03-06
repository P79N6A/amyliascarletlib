package com.amyliascarlet.jsontest.bvt.parser.number;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONException;

import junit.framework.TestCase;

public class NumberValueTest_error_1 extends TestCase {

    public void test_0() throws Exception {
        Exception error = null;
        try {
            String text = "33e";
            JSON.parse(text);
        } catch (JSONException e) {
            error = e;
        }
        Assert.assertNotNull(error);
    }
}
