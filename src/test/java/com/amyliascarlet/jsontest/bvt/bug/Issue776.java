package com.amyliascarlet.jsontest.bvt.bug;

import com.amyliascarlet.lib.json.JSON;
import junit.framework.TestCase;

import java.util.Map;

/**
 * Created by wenshao on 16/8/30.
 */
public class Issue776 extends TestCase {
    public void test_for_issue() throws Exception {
        String str1 = "{\"v\":[\" \",\"abc\",\"x\",\"abc\"]}";

        Exception error = null;
        try {
            JSON.parseObject(str1,
                    new com.amyliascarlet.lib.json.TypeReference<Map<String, char[]>>() {
                    });
        } catch (Exception ex) {
            error = ex;
        }
        assertNotNull(error);
    }
}
