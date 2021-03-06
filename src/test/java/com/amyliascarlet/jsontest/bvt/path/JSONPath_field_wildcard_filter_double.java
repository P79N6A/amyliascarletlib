package com.amyliascarlet.jsontest.bvt.path;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.JSONPath;
import com.amyliascarlet.lib.json.TypeReference;
import com.amyliascarlet.lib.json.parser.Feature;
import junit.framework.TestCase;

import java.util.Collection;
import java.util.Map;

public class JSONPath_field_wildcard_filter_double extends TestCase {

    public void test_list_map_0() throws Exception {
        Map<String, Value> jsonObject = JSON.parseObject(text, new TypeReference<Map<String, Value>>(){}, Feature.OrderedField);

        Collection array = (Collection) JSONPath.eval(jsonObject, "$.*[score>0]");
        assertEquals("[{\"score\":0.8951322155668501},{\"score\":0.7237896928683851},{\"score\":0.3467174233072834}]", JSON.toJSONString(array));
    }

    public void test_list_map_1() throws Exception {
        Map<String, Value> jsonObject = JSON.parseObject(text, new TypeReference<Map<String, Value>>(){}, Feature.OrderedField);

        Collection array = (Collection) JSONPath.eval(jsonObject, "$.*[score<0]");
        assertEquals("[{\"score\":-0.3453003960431523}]", JSON.toJSONString(array));
    }

    public void test_list_map_2() throws Exception {
        Map<String, Value> jsonObject = JSON.parseObject(text, new TypeReference<Map<String, Value>>(){}, Feature.OrderedField);

        Collection array = (Collection) JSONPath.eval(jsonObject, "$.*[score=0]");
        assertEquals("[{\"score\":0.0},{\"score\":0.0},{\"score\":0.0},{\"score\":0.0},{\"score\":0.0},{\"score\":0.0},{\"score\":0.0}]", JSON.toJSONString(array));
    }

    public static class Value {
        public double score;
    }

    public static final String text = "{\n" +
            "\t\"risk_sexy_trade_stream_plus\": {\n" +
            "\t\t\"score\": 0\n" +
            "\t},\n" +
            "\t\"chemical_medicine_stream_plus\": {\n" +
            "\t\t\"score\": 0\n" +
            "\t},\n" +
            "\t\"gambling_trade_stream_plus\": {\n" +
            "\t\t\"score\": 0\n" +
            "\t},\n" +
            "\t\"politics_stream_plus\": {\n" +
            "\t\t\"score\": 0.89513221556685012\n" +
            "\t},\n" +
            "\t\"risk_tool_gun_stream_plus\": {\n" +
            "\t\t\"score\": 0\n" +
            "\t},\n" +
            "\t\"sex_model_stream_plus\": {\n" +
            "\t\t\"score\": 0.7237896928683851\n" +
            "\t},\n" +
            "\t\"risk_tool_cheat_stream_plus\": {\n" +
            "\t\t\"score\": 0\n" +
            "\t},\n" +
            "\t\"risk_tool_certif_stream_plus\": {\n" +
            "\t\t\"score\": 0\n" +
            "\t},\n" +
            "\t\"gamble_model_stream_plus\": {\n" +
            "\t\t\"score\": -0.3453003960431523\n" +
            "\t},\n" +
            "\t\"risk_tool_vpn_stream_plus\": {\n" +
            "\t\t\"score\": 0\n" +
            "\t},\n" +
            "\t\"vpndetect_stream_plus\": {\n" +
            "\t\t\"score\": 0.3467174233072834\n" +
            "\t}\n" +
            "}";

}
