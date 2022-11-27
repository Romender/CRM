package com.fabits.crm.upload.helper;

import com.fabits.crm.upload.UploadType;
import com.fabits.crm.upload.headers.HeaderValueType;
import com.fabits.crm.upload.headers.Headers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Persistable;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public interface UploadHelper<T extends Persistable<? extends Serializable>, B> {

    B getBuilder();

    default B fillData(Map<String, String> data, B object) {
        getHeaders().getHeaderInformation().entrySet().forEach(entry -> {
            if (Objects.nonNull(data.get(entry.getKey()))) {
                String value = data.get(entry.getKey());
                HeaderValueType valueType = entry.getValue();
                try {
                    valueType.getMethod().invoke(object, valueType.getFunction().apply(value));
                } catch (IllegalAccessException | InvocationTargetException e) {
                   e.printStackTrace();
                }
            }
        });
        return object;
    }

    T fromMap(Map<String, String> data);

    void persistData(Persistable<?> entity);

    UploadType forUploadType();

    Headers getHeaders();

    default boolean verifyHeaders(String[] headers) {
        return  Arrays.stream(headers).map(String::toUpperCase)
                .collect(Collectors.toList()).containsAll(getHeaders().getMandatoryHeaders());
    }

}