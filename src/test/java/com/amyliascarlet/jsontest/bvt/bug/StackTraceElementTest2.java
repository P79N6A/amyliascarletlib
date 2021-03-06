package com.amyliascarlet.jsontest.bvt.bug;

import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;


public class StackTraceElementTest2 extends TestCase {
    public void test_stackTrace2() throws Exception {
        String text = "{\"@type\":\"java.lang.StackTraceElement\",\"className\":\"java.lang.EasyThread\",\"fileName\":\"EasyThread.java\",\"lineNumber\":1503,\"methodName\":\"getStackTrace\",\"nativeMethod\":false}";
        JSON.parseObject(text, StackTraceElement.class);
    }
}
