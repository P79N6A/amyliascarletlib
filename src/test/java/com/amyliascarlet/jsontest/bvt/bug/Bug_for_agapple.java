package com.amyliascarlet.jsontest.bvt.bug;

import java.util.Properties;

import com.amyliascarlet.lib.json.JSON;

import junit.framework.TestCase;

public class Bug_for_agapple extends TestCase {

    public void test_for_agapple() throws Exception {
        Entity entity = new Entity();
        entity.setProperties(new Properties());
        String text = JSON.toJSONString(entity);
        
        JSON.parseObject(text, Entity.class);
    }

    private static class Entity {

        private Properties properties;

        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }

    }
}
