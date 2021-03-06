package com.amyliascarlet.jsontest.bvt.bug;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class Bug_for_dubbo1 extends TestCase {

    public void test_0() throws Exception {
        String text;
        {
            HashSet<String> tigers = new HashSet<String>();
            tigers.add("老虎二");
            tigers.add("老虎大");
            HashMap<String, Collection<String>> tiger = new HashMap<String, Collection<String>>();
            tiger.put("老鼠", tigers);

            text = JSON.toJSONString(tiger, SerializerFeature.WriteClassName);
        }
        
        System.out.println(text);

        HashMap<String, Collection<String>> tigger2 = (HashMap<String, Collection<String>>) JSON.parse(text);
        Assert.assertEquals(1, tigger2.size());
        Assert.assertEquals(2, tigger2.get("老鼠").size());
    }
}
