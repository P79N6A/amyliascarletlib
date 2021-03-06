package com.amyliascarlet.jsontest.bvt.bug;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.TypeReference;

import junit.framework.TestCase;

public class Bug_for_issue_280 extends TestCase {

    public void test_for_issue() throws Exception {
        TypeReference<Respone<User>> type= new TypeReference<Respone<User>>() {};  

        Respone<User> resp = JSON.parseObject("{\"code\":\"\",\"data\":\"\",\"msg\":\"\"}", type);
        Assert.assertNull(resp.data);
    }

    public static class Respone<T> {

        public String code;
        public String msg;
        public T      data;
    }

    public static class User {

    }
}
