package com.amyliascarlet.jsontest.bvt.parser;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSON;

public class ParserSpecialCharTest_map extends TestCase {

    public void test_0() throws Exception {
        Assert.assertEquals("\0", JSON.parseObject("{'value':'\\0'}").getString("value"));
    }
    
    public void test_1() throws Exception {
        Assert.assertEquals("\1", JSON.parseObject("{'value':'\\1'}").getString("value"));
    }
    
    public void test_2() throws Exception {
        Assert.assertEquals("\2", JSON.parseObject("{'value':'\\2'}").getString("value"));
    }
    
    public void test_3() throws Exception {
        Assert.assertEquals("\3", JSON.parseObject("{'value':'\\3'}").getString("value"));
    }
    
    public void test_4() throws Exception {
        Assert.assertEquals("\4", JSON.parseObject("{'value':'\\4'}").getString("value"));
    }
    
    public void test_5() throws Exception {
        Assert.assertEquals("\5", JSON.parseObject("{'value':'\\5'}").getString("value"));
    }
    
    public void test_6() throws Exception {
        Assert.assertEquals("\6", JSON.parseObject("{'value':'\\6'}").getString("value"));
    }
    
    public void test_7() throws Exception {
        Assert.assertEquals("\7", JSON.parseObject("{'value':'\\7'}").getString("value"));
    }
    
    public void test_8() throws Exception {
        Assert.assertEquals("\b", JSON.parseObject("{'value':'\\b'}").getString("value"));
    }
    
    public void test_9() throws Exception {
        Assert.assertEquals("\t", JSON.parseObject("{'value':'\\t'}").getString("value"));
    }
    
    public void test_10() throws Exception {
        Assert.assertEquals("\n", JSON.parseObject("{'value':'\\n'}").getString("value"));
    }
    
    public void test_11() throws Exception {
        Assert.assertEquals("\u000B", JSON.parseObject("{'value':'\\v'}").getString("value"));
    }
    
    public void test_12() throws Exception {
        Assert.assertEquals("\f", JSON.parseObject("{'value':'\\f'}").getString("value"));
    }
    
    public void test_13() throws Exception {
        Assert.assertEquals("\r", JSON.parseObject("{'value':'\\r'}").getString("value"));
    }
    
    public void test_34() throws Exception {
        Assert.assertEquals("\"", JSON.parseObject("{'value':'\\\"'}").getString("value"));
    }
    
    public void test_39() throws Exception {
        Assert.assertEquals("'", JSON.parseObject("{'value':'\\''}").getString("value"));
    }
    
    public void test_47() throws Exception {
        Assert.assertEquals("/", JSON.parseObject("{'value':'\\/'}").getString("value"));
    }
    
    public void test_92() throws Exception {
        Assert.assertEquals("\\", JSON.parseObject("{'value':'\\\\'}").getString("value"));
    }
}
