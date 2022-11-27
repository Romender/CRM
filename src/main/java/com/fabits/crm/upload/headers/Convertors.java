package com.fabits.crm.upload.headers;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

@UtilityClass
public class Convertors {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final Function<String, String> NO_CONVERTOR = String::toString;
    public static final Function<String, BigDecimal> BIG_DECIMAL_CONVERTOR = BigDecimal::new;
    public static final Function<String, LocalDate> LOCAL_DATE_CONVERTOR = x -> DATE_FORMATTER.parse(x, LocalDate::from);
}
