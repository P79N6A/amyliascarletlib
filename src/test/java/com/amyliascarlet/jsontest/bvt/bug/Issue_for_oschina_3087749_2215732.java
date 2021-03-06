package com.amyliascarlet.jsontest.bvt.bug;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONObject;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenshao on 29/12/2016.
 */
public class Issue_for_oschina_3087749_2215732 extends TestCase {
    public void test_for_issue() throws Exception {
        String json = "{\"datas\":[\"a\",\"b\"]}";
        JSONObject o = JSON.parseObject(json);
        o.toJavaObject(JsonBean.class);
    }

    public static class JsonBean {
        private List<String> datas = new ArrayList<String>();
        public List<String> getDatas() {
            return datas;
        }
    }
}
