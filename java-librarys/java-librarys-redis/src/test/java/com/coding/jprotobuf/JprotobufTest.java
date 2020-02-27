package com.coding.jprotobuf;

import com.alibaba.fastjson.JSON;
import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.google.common.io.BaseEncoding;

import java.io.IOException;

/**
 * Created by xuelu
 * 2019/11/26.
 */
public class JprotobufTest {

    public static void main(String[] args) {
        MyDto myDto = new MyDto();
        myDto.setKey("key");
        myDto.setValue("value");

        Codec<MyDto> simpleTypeCodec = ProtobufProxy
                .create(MyDto.class);
        try {
            byte[] encode = simpleTypeCodec.encode(myDto);
            System.out.println(encode.length);
            System.out.println(JSON.toJSONString(myDto).getBytes().length);

            System.out.println(BaseEncoding.base64().encode(encode).length());
            System.out.println(BaseEncoding.base64().encode(JSON.toJSONString(myDto).getBytes()).length());

            System.out.println(new String(encode).length());
            System.out.println(JSON.toJSONString(myDto).length());

            MyDto newStt = simpleTypeCodec.decode(encode);
            System.out.println(newStt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
