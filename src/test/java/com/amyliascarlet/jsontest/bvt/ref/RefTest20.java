package com.amyliascarlet.jsontest.bvt.ref;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;

import junit.framework.TestCase;

public class RefTest20 extends TestCase {
    public void test_array() throws Exception {
        String text = "{\"resultObj\":{\"appId\":1161605300000000588,\"inputParamList\":[],\"obj\":{\"$ref\":\"$.resultObj\"}}}";
        
        JSONObject obj = JSON.parseObject(text);
        JSONObject resultObj = obj.getJSONObject("resultObj");
        Assert.assertSame(resultObj, resultObj.get("obj"));
    }
}
