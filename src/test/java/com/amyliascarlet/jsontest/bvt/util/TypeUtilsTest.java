package com.amyliascarlet.jsontest.bvt.util;

import com.amyliascarlet.lib.json.annotation.JSONType;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import com.amyliascarlet.lib.json.util.TypeUtils;
import com.amyliascarlet.jsontest.bvt.parser.deser.generic.GenericArrayTest;
import com.jsoniter.spi.GenericArrayTypeImpl;
import junit.framework.TestCase;

import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;

public class TypeUtilsTest extends TestCase {
    public void test_0() throws Exception {
        assertEquals(0, TypeUtils.getSerializeFeatures(Object.class));
        assertEquals(SerializerFeature.WriteMapNullValue.mask, TypeUtils.getSerializeFeatures(Model.class));
    }

    public void test_1() throws Exception {
        TypeUtils.checkPrimitiveArray((GenericArrayType) A.class.getField("values").getGenericType());
    }

    public void test_3() throws Exception {
        assertTrue(TypeUtils.isHibernateInitialized(new Object()));
    }

    public void test_2() throws Exception {
        Constructor<?> constructor = GenericArrayTypeImpl.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);

        Class[] classes = new Class[] {
            boolean[].class,
            byte[].class,
            short[].class,
            int[].class,
            long[].class,
            float[].class,
            double[].class,
            char[].class,
        };

        for (Class clazz : classes) {
            GenericArrayType type = (GenericArrayType) constructor.newInstance(clazz.getComponentType());
            assertEquals(clazz, TypeUtils.checkPrimitiveArray(type));
        }

    }

    @JSONType(serialzeFeatures = SerializerFeature.WriteMapNullValue)
    public static class Model {

    }

    public static class A<T extends Number> {
        public T[] values;
    }

    public static class VO extends GenericArrayTest.A {

    }
}
