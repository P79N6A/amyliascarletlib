package com.amyliascarlet.jsontest.test.benchmark.decode;

import com.amyliascarlet.lib.json.JSON;
import com.amyliascarlet.lib.json.serializer.SerializerFeature;
import com.amyliascarlet.jsontest.test.benchmark.BenchmarkCase;
import com.amyliascarlet.jsontest.test.codec.Codec;

import data.media.MediaContent;

public class EishayDecodeByClassName extends BenchmarkCase {

    private final String text;

    public EishayDecodeByClassName(){
        super("EishayDecode");

        text = JSON.toJSONString(EishayDecodeBytes.instance.getContent(), SerializerFeature.WriteEnumUsingToString,
                                 SerializerFeature.SortField, SerializerFeature.WriteClassName);
        System.out.println(text);
        System.out.println();

        // JavaBeanMapping.getGlobalInstance().putDeserializer(Image.class, new ImageDeserializer());
        // JavaBeanMapping.getGlobalInstance().putDeserializer(Media.class, new MediaDeserializer());
    }

    @Override
    public void execute(Codec codec) throws Exception {
        MediaContent content = codec.decodeObject(text, MediaContent.class);
        if (content == null) {
            throw new Exception();
        }
    }

}
