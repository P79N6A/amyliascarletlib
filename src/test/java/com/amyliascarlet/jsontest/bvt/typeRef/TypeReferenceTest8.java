package com.amyliascarlet.jsontest.bvt.typeRef;

import java.util.Map;

import org.junit.Assert;
import junit.framework.TestCase;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.TypeReference;

public class TypeReferenceTest8 extends TestCase {

	public void test_typeRef() throws Exception {
		TypeReference<Map<String, Entity>> typeRef = new TypeReference<Map<String, Entity>>() {
		};

		Map<String, Entity> map = JSON.parseObject(
				"{\"value\":{\"id\":\"abc\",\"list\":[{\"id\":123}]}}", typeRef);

		Entity entity = map.get("value");
		Assert.assertNotNull(entity);
		Assert.assertEquals("abc", entity.getId());
		Assert.assertEquals(1, entity.getList().length);
		Assert.assertEquals(123, entity.getList()[0].getId());
	}

	public static class Entity {
		private String id;

		private A[] list;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public A[] getList() {
			return list;
		}

		public void setList(A[] list) {
			this.list = list;
		}

	}

	public static class A {
		private int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

	}

}
