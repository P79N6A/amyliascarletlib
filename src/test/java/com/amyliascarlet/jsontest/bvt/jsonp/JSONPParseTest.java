package com.amyliascarlet.jsontest.bvt.jsonp;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import com.amyliascarlet.lib.json.JSONPObject;
import junit.framework.TestCase;

/**
 * Created by wenshao on 21/02/2017.
 */
public class JSONPParseTest extends TestCase {
    public void test_f() throws Exception {
        String text = "callback ({'id':1, 'name':'idonans'} );";

        JSONPObject jsonpObject = JSON.parseObject(text, JSONPObject.class);
        assertEquals("callback", jsonpObject.getFunction());

        assertEquals(1, jsonpObject.getParameters().size());
        JSONObject param = (JSONObject) jsonpObject.getParameters().get(0);
        assertEquals(1, param.get("id"));
        assertEquals("idonans", param.get("name"));

        String json = JSON.toJSONString(jsonpObject);
        System.out.println(json);
    }
}
