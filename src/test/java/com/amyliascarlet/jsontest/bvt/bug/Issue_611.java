package com.amyliascarlet.jsontest.bvt.bug;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;

import junit.framework.TestCase;

public class Issue_611 extends TestCase {
    public void test_for_issue() throws Exception {
        String text = "{\"priority\":1}";
        JSONObject obj = JSON.parseObject(text);
        Assert.assertEquals(1, obj.getInteger("priority").intValue());
        Assert.assertEquals(1, obj.getIntValue("priority"));
    }
}
