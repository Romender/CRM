package com.fabits.crm.upload.helper;

import com.fabits.crm.exception.MissingMandatoryFieldsException;
import com.fabits.crm.upload.UploadType;
import com.fabits.crm.upload.headers.Headers;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public interface UploadHelper<T extends Persistable<? extends Serializable>, B> {

    B getBuilder();

    default B fillData(Map<String, String> data, B object) {
        getHeaders().getHeaderInformation().forEach((key, valueType) -> {
            if (Objects.nonNull(data.get(key))) {
                String value = data.get(key);
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
        List<String> currHeaders = Arrays.stream(headers).map(String::toUpperCase)
                .collect(Collectors.toList());
        if (!currHeaders.containsAll(getHeaders().getMandatoryHeaders())) {
            throw new MissingMandatoryFieldsException(getHeaders().getMandatoryHeaders().stream()
                    .filter(x -> !currHeaders.contains(x)).collect(Collectors.toList()));
        }
        return true;
    }

}