package com.example.demo.annotations.nullable;


import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by xuelu
 * 2020-06-17.
 */
public class NullableService {

    @Nullable
    public String hello(){
        return null;
    }

    @Nonnull
    public String hi(){
        return null;
    }
}
