package com.amyliascarlet.jsontest.bvt.parser.number;

import com.amyliascarlet.lib.json.JSON;
import junit.framework.TestCase;

/**
 * Created by wenshao on 24/04/2017.
 */
public class NumberEmtpyObjectTest extends TestCase {
    public void test_for_emptyObj() throws Exception {
        Model model = JSON.parseObject("{\"val\":{}}", Model.class);
        assertNull(model.val);
    }

    public static class Model {
        public Number val;
    }
}
