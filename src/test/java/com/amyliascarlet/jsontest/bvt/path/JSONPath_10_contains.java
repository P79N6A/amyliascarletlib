package com.amyliascarlet.jsontest.bvt.path;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONPath;
import junit.framework.TestCase;

public class JSONPath_10_contains extends TestCase {

    public void test(){
        String json = "{\n" +
                "    \"queryScene\":{\n" +
                "        \"scene\":[\n" +
                "            {\n" +
                "                \"innerSceneId\":3,\n" +
                "                \"name\":\"场景绑8测试-笑幽\",\n" +
                "                \"sceneSetId\":8,\n" +
                "                \"formInfo\":\"{}\",\n" +
                "                \"queryDataSet\":{\n" +
                "                    \"dataSet\":[\n" +
                "                        {\n" +
                "                            \"id\":6,\n" +
                "                            \"sceneId\":3,\n" +
                "                            \"name\":\"测试商品集\",\n" +
                "                            \"dataSetRuleCode\":null,\n" +
                "                            \"resourceId\":null,\n" +
                "                            \"udsOffer\":{\n" +
                "                                \"offer\":[\n" +
                "\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\":5,\n" +
                "                            \"sceneId\":3,\n" +
                "                            \"name\":\"测试卖家集\",\n" +
                "                            \"dataSetRuleCode\":null,\n" +
                "                            \"resourceId\":null,\n" +
                "                            \"udsOffer\":{\n" +
                "                                \"offer\":[\n" +
                "\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        assertTrue(JSONPath.contains(JSON.parseObject(json), "$.queryScene.scene.queryDataSet.dataSet"));
        assertFalse(JSONPath.contains(JSON.parseObject(json), "$.queryScene.scene.queryDataSet.dataSet.abcd"));
        assertTrue(JSONPath.contains(JSON.parseObject(json), "$.queryScene.scene.queryDataSet.dataSet.name"));
    }

//    public void test_path_2() throws Exception {
////        File file = new File("/Users/wenshao/Downloads/test");
////        String jsontest = FileUtils.readFileToString(file);
//        String jsontest = "{\"returnObj\":[{\"$ref\":\"$.subInvokes.com\\\\.alipay\\\\.cif\\\\.user\\\\.UserInfoQueryService\\\\@findUserInfosByCardNo\\\\(String[])[0].response[0]\"}]}";
//        JSON.parseObject(jsontest);
//    }

}
