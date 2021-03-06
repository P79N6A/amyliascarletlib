package com.amyliascarlet.jsontest.bvt.path;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Assert;

import com.amyliascarlet.lib.json.JSONPath;

public class JSONPath_field_access_filter_in_string extends TestCase {

    public void test_list_in() throws Exception {
        JSONPath path = new JSONPath("[name in ('ljw2083')]");

        List<Entity> entities = new ArrayList<Entity>();
        entities.add(new Entity(1001, "ljw2083"));
        entities.add(new Entity(1002, "wenshao"));
        entities.add(new Entity(1003, "yakolee"));
        entities.add(new Entity(1004, null));

        List<Object> result = (List<Object>) path.eval(entities);
        Assert.assertEquals(1, result.size());
        Assert.assertSame(entities.get(0), result.get(0));
    }
    
    public void test_list_not_in() throws Exception {
        JSONPath path = new JSONPath("[name not in ('ljw2083')]");
        
        List<Entity> entities = new ArrayList<Entity>();
        entities.add(new Entity(1001, "ljw2083"));
        entities.add(new Entity(1002, "wenshao"));
        entities.add(new Entity(1003, "yakolee"));
        entities.add(new Entity(1004, null));
        
        List<Object> result = (List<Object>) path.eval(entities);
        Assert.assertEquals(3, result.size());
        Assert.assertSame(entities.get(1), result.get(0));
        Assert.assertSame(entities.get(2), result.get(1));
        Assert.assertSame(entities.get(3), result.get(2));
    }
    
    public void test_list_in_2() throws Exception {
        JSONPath path = new JSONPath("[name in ('ljw2083', 'yakolee')]");
        
        List<Entity> entities = new ArrayList<Entity>();
        entities.add(new Entity(1001, "ljw2083"));
        entities.add(new Entity(1002, "wenshao"));
        entities.add(new Entity(1003, "yakolee"));
        entities.add(new Entity(1004, null));
        
        List<Object> result = (List<Object>) path.eval(entities);
        Assert.assertEquals(2, result.size());
        Assert.assertSame(entities.get(0), result.get(0));
        Assert.assertSame(entities.get(2), result.get(1));
    }
    
    public void test_list_in_3() throws Exception {
        JSONPath path = new JSONPath("[name in ('ljw2083', 'yakolee',null)]");
        
        List<Entity> entities = new ArrayList<Entity>();
        entities.add(new Entity(1001, "ljw2083"));
        entities.add(new Entity(1002, "wenshao"));
        entities.add(new Entity(1003, "yakolee"));
        entities.add(new Entity(1004, null));
        
        List<Object> result = (List<Object>) path.eval(entities);
        Assert.assertEquals(3, result.size());
        Assert.assertSame(entities.get(0), result.get(0));
        Assert.assertSame(entities.get(2), result.get(1));
        Assert.assertSame(entities.get(3), result.get(2));
    }

    public static class Entity {

        private Integer id;
        private String  name;

        public Entity(Integer id, String name){
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
