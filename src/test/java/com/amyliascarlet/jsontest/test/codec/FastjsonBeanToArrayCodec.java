package com.amyliascarlet.jsontest.test.codec;

import java.io.OutputStream;
import java.util.Collection;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.parser.DefaultJSONParser;
import com.amyliascarlet.lib.json.parser.Feature;
import com.amyliascarlet.lib.json.parser.ParserConfig;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;

public class FastjsonBeanToArrayCodec implements Codec {
    private int serializerFeatures;
    
    public FastjsonBeanToArrayCodec() {
        serializerFeatures |= SerializerFeature.QuoteFieldNames.getMask();
        serializerFeatures |= SerializerFeature.SkipTransientField.getMask();
        serializerFeatures |= SerializerFeature.SortField.getMask();
        serializerFeatures |= SerializerFeature.DisableCircularReferenceDetect.getMask();
        serializerFeatures |= SerializerFeature.BeanToArray.getMask();
    }

    public String getName() {
        return "json-bean-to-array";
    }

    public <T> T decodeObject(String text, Class<T> clazz) {
        return (T) JSON.parseObject(text, clazz, Feature.DisableCircularReferenceDetect, Feature.SupportArrayToBean);
    }

    public <T> Collection<T> decodeArray(String text, Class<T> clazz) throws Exception {
        ParserConfig config = ParserConfig.global;
        DefaultJSONParser parser = new DefaultJSONParser(text, config);
        parser.config(Feature.DisableCircularReferenceDetect, true);
        parser.config(Feature.SupportArrayToBean, true);
        return parser.parseArray(clazz);
    }

    public final Object decodeObject(String text) {
        ParserConfig config = ParserConfig.global;
        DefaultJSONParser parser = new DefaultJSONParser(text, config);
        parser.config(Feature.DisableCircularReferenceDetect, true);
        parser.config(Feature.SupportArrayToBean, true);
        return parser.parse();
    }

    public final Object decode(String text) {
        ParserConfig config = ParserConfig.global;
        DefaultJSONParser parser = new DefaultJSONParser(text, config);
        parser.config(Feature.DisableCircularReferenceDetect, true);
        parser.config(Feature.SupportArrayToBean, true);
        return parser.parse();
    }

    // private JavaBeanSerializer serializer = new JavaBeanSerializer(Long_100_Entity.class);

    public String encode(Object object) throws Exception {
        return JSON.toJSONString(object, serializerFeatures);
    }

    @SuppressWarnings("unchecked")
    public <T> T decodeObject(byte[] input, Class<T> clazz) throws Exception {
        return (T) JSON.parseObject(input, clazz, Feature.SupportArrayToBean, Feature.DisableCircularReferenceDetect);
    }

    @Override
    public byte[] encodeToBytes(Object object) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void encode(OutputStream out, Object object) throws Exception {
        out.write(encodeToBytes(object));        
    }

}
