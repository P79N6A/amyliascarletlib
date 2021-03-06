package com.amyliascarlet.jsontest.bvt.path;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONPath;
import com.amyliascarlet.lib.json.util.IOUtils;
import junit.framework.TestCase;

import java.io.InputStream;
import java.io.InputStreamReader;

public class BookExtractTest extends TestCase {
    private String json;

    protected void setUp() throws Exception {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("json/book.json");
        InputStreamReader reader = new InputStreamReader(is);
        json = IOUtils.readAll(reader);
        IOUtils.close(reader);
    }

    public void test_0() throws Exception {
        assertEquals(4, JSONPath.extract(json, "$..book.length()"));
    }

    public void test_1() throws Exception {
        assertEquals("[\"reference\",\"Nigel Rees\",\"Sayings of the Century\",8.95,\"fiction\",\"Evelyn Waugh\",\"Sword of Honour\",12.99,\"fiction\",\"Herman Melville\",\"Moby Dick\",\"0-553-21311-3\",8.99,\"fiction\",\"J. R. R. Tolkien\",\"The Lord of the Rings\",\"0-395-19395-8\",22.99,\"red\",19.95,10]"
                , JSON.toJSONString(JSONPath.extract(json, "$..*")));
    }

    public void test_2() throws Exception {
        assertEquals("[\"Nigel Rees\",\"Evelyn Waugh\",\"Herman Melville\",\"J. R. R. Tolkien\"]", JSON.toJSONString(JSONPath.extract(json, "$.store.book[*].author")));
    }

    public void test_3() throws Exception {
        assertEquals("[\"Nigel Rees\",\"Evelyn Waugh\",\"Herman Melville\",\"J. R. R. Tolkien\"]", JSON.toJSONString(JSONPath.extract(json, "$..author")));
    }

    public void test_4() throws Exception {
        assertEquals("[8.95,12.99,8.99,22.99,19.95]", JSON.toJSONString(JSONPath.extract(json, "$..price")));
    }

    public void test_5() throws Exception {
        assertEquals("[8.95,12.99,8.99,22.99]", JSON.toJSONString(JSONPath.extract(json, "$..book.price")));
    }

    public void test_6() throws Exception {
        assertEquals("[[{\"category\":\"reference\",\"author\":\"Nigel Rees\",\"title\":\"Sayings of the Century\",\"price\":8.95},{\"category\":\"fiction\",\"author\":\"Evelyn Waugh\",\"title\":\"Sword of Honour\",\"price\":12.99},{\"category\":\"fiction\",\"author\":\"Herman Melville\",\"title\":\"Moby Dick\",\"isbn\":\"0-553-21311-3\",\"price\":8.99},{\"category\":\"fiction\",\"author\":\"J. R. R. Tolkien\",\"title\":\"The Lord of the Rings\",\"isbn\":\"0-395-19395-8\",\"price\":22.99}],{\"color\":\"red\",\"price\":19.95}]"
                , JSON.toJSONString(JSONPath.extract(json, "$.store.*")));
    }

    public void test_7() throws Exception {
        assertEquals("[8.95,12.99,8.99,22.99,19.95]"
                , JSON.toJSONString(JSONPath.extract(json, "$.store..price")));
    }

    public void test_8() throws Exception {
        assertEquals("{\"category\":\"fiction\",\"author\":\"Herman Melville\",\"title\":\"Moby Dick\",\"isbn\":\"0-553-21311-3\",\"price\":8.99}"
                , JSON.toJSONString(JSONPath.extract(json, "$..book[2]")));
    }

    public void test_9() throws Exception {
        assertEquals("{\"category\":\"fiction\",\"author\":\"J. R. R. Tolkien\",\"title\":\"The Lord of the Rings\",\"isbn\":\"0-395-19395-8\",\"price\":22.99}"
                , JSON.toJSONString(JSONPath.extract(json, "$..book[-1]")));
    }

    public void test_10() throws Exception {
        assertEquals("[{\"category\":\"reference\",\"author\":\"Nigel Rees\",\"title\":\"Sayings of the Century\",\"price\":8.95},{\"category\":\"fiction\",\"author\":\"Evelyn Waugh\",\"title\":\"Sword of Honour\",\"price\":12.99}]"
                , JSON.toJSONString(JSONPath.extract(json, "$..book[0,1]")));
    }

    public void test_11() throws Exception {
        assertEquals("[{\"category\":\"fiction\",\"author\":\"Herman Melville\",\"title\":\"Moby Dick\",\"isbn\":\"0-553-21311-3\",\"price\":8.99},{\"category\":\"fiction\",\"author\":\"J. R. R. Tolkien\",\"title\":\"The Lord of the Rings\",\"isbn\":\"0-395-19395-8\",\"price\":22.99}]"
                , JSON.toJSONString(JSONPath.extract(json, "$..book[?(@.isbn)]")));
    }

    public void test_12() throws Exception {
        assertEquals("[{\"category\":\"reference\",\"author\":\"Nigel Rees\",\"title\":\"Sayings of the Century\",\"price\":8.95},{\"category\":\"fiction\",\"author\":\"Herman Melville\",\"title\":\"Moby Dick\",\"isbn\":\"0-553-21311-3\",\"price\":8.99}]"
                , JSON.toJSONString(JSONPath.extract(json, "$.store.book[?(@.price < 10)]")));
    }

    public void test_13() throws Exception {
        assertEquals("[{\"category\":\"reference\",\"author\":\"Nigel Rees\",\"title\":\"Sayings of the Century\",\"price\":8.95},{\"category\":\"fiction\",\"author\":\"Herman Melville\",\"title\":\"Moby Dick\",\"isbn\":\"0-553-21311-3\",\"price\":8.99}]"
                , JSON.toJSONString(JSONPath.extract(json, "$..book[?(@.price <= $['expensive'])]")));
    }

    public void test_14() throws Exception {
        assertEquals("[{\"category\":\"reference\",\"author\":\"Nigel Rees\",\"title\":\"Sayings of the Century\",\"price\":8.95}]"
                , JSON.toJSONString(JSONPath.extract(json, "$..book[?(@.author =~ /.*REES/i)]")));
    }

    public void test_15() throws Exception {
        assertEquals("[{\"category\":\"reference\",\"author\":\"Nigel Rees\",\"title\":\"Sayings of the Century\",\"price\":8.95}]"
                , JSON.toJSONString(JSONPath.extract(json, "$..book[?(@.author =~ /.*REES/i)]")));
    }

    public void test_16() throws Exception {
        assertEquals("[{\"category\":\"fiction\",\"author\":\"Herman Melville\",\"title\":\"Moby Dick\",\"isbn\":\"0-553-21311-3\",\"price\":8.99}]"
                , JSON.toJSONString(JSONPath.extract(json, "$.store.book[?(@.price < 10 && @.category == 'fiction')]")));
    }

}
