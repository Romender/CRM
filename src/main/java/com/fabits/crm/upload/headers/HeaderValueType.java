package com.fabits.crm.upload.headers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.function.Function;

@AllArgsConstructor
@Getter
public class HeaderValueType {
    private final HeaderType headerType;
    private final Method method;
    private final Function<String, ? extends Serializable> function;
}
