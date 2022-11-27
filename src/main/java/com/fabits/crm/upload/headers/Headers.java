package com.fabits.crm.upload.headers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface Headers {
    Map<String, HeaderValueType> getHeaderInformation();

    default List<String> getMandatoryHeaders() {
        return getHeaderInformation().entrySet().stream()
                .filter(x -> x.getValue().getHeaderType().equals(HeaderType.MANDATORY))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
