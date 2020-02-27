package com.coding.jprotobuf;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Created by xuelu
 * 2019/11/26.
 */
public class MyDto {

    @Protobuf
    private String key;

    @Protobuf
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyDto{");
        sb.append("key='").append(key).append('\'');
        sb.append(", value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
