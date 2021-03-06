package com.amyliascarlet.jsontest.bvt.issue_1900;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.annotation.JSONField;
import com.amyliascarlet.lib.json.annotation.JSONType;
import junit.framework.TestCase;

public class Issue1941_JSONField_order extends TestCase {

    public void test_for_issue() throws Exception {
        String json = "{\"type\":\"floorV2\",\"templateId\":\"x123\",\"name\":\"floorname2\"}";
        FloorV2  a=(FloorV2) JSON.parseObject(json,Area.class);
        assertEquals("floorname2", a.name);
        assertEquals("x123", a.templateId);
    }

    @JSONType(seeAlso = {FloorV2.class}, typeKey = "type")
    public static interface Area {
    }

    @JSONType(typeName = "floorV2")
    public static class FloorV2 implements Area {
        @JSONField(ordinal = -1)
        public String type;
        public String templateId;
        public String name;
    }
}
