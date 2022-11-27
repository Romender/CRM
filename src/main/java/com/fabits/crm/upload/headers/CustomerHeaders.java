package com.fabits.crm.upload.headers;

import com.fabits.crm.domain.Customer;
import com.fabits.crm.exception.HeaderConfigurationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static com.fabits.crm.upload.headers.Convertors.BIG_DECIMAL_CONVERTOR;
import static com.fabits.crm.upload.headers.Convertors.LOCAL_DATE_CONVERTOR;
import static com.fabits.crm.upload.headers.Convertors.NO_CONVERTOR;
import static com.fabits.crm.upload.headers.HeaderType.MANDATORY;
import static com.fabits.crm.upload.headers.HeaderType.OPTIONAL;

@Component
public class CustomerHeaders implements Headers {
    private static final Map<String, HeaderValueType> headers = new HashMap<>();
    private static final Class<Customer.CustomerBuilder> clazz = Customer.CustomerBuilder.class;

    static {
        try {
            headers.put("NAME", new HeaderValueType(MANDATORY, clazz.getMethod("name", String.class), NO_CONVERTOR));
            headers.put("MOBILE", new HeaderValueType(MANDATORY, clazz.getMethod("mobile", String.class), NO_CONVERTOR));
            headers.put("EMAIL", new HeaderValueType(MANDATORY, clazz.getMethod("emailId", String.class), NO_CONVERTOR));
            headers.put("PANNUMBER", new HeaderValueType(MANDATORY, clazz.getMethod("panNumber", String.class), NO_CONVERTOR));
            headers.put("DOB", new HeaderValueType(MANDATORY, clazz.getMethod("dateOfBirth", LocalDate.class), LOCAL_DATE_CONVERTOR));
            headers.put("BANKACCOUNTNUMBER", new HeaderValueType(MANDATORY, clazz.getMethod("bankAccountNumber", String.class), NO_CONVERTOR));
            headers.put("BANKNAME", new HeaderValueType(OPTIONAL, clazz.getMethod("bankName", String.class), NO_CONVERTOR));
            headers.put("IFSCCODE", new HeaderValueType(MANDATORY, clazz.getMethod("ifscCode", String.class), NO_CONVERTOR));
            headers.put("ACCOUNTTYPE", new HeaderValueType(OPTIONAL, clazz.getMethod("accountType", String.class), NO_CONVERTOR));
            headers.put("LEDGERBALANCE", new HeaderValueType(OPTIONAL, clazz.getMethod("ledgerBalance", BigDecimal.class), BIG_DECIMAL_CONVERTOR));
            headers.put("CORRESPONDENCEADDRESS", new HeaderValueType(OPTIONAL, clazz.getMethod("correspondenceStreet", String.class), NO_CONVERTOR));
            headers.put("CORRESPONDENCECITY", new HeaderValueType(OPTIONAL, clazz.getMethod("correspondenceCity", String.class), NO_CONVERTOR));
            headers.put("CORRESPONDENCESTATE", new HeaderValueType(OPTIONAL, clazz.getMethod("correspondenceState", String.class), NO_CONVERTOR));
            headers.put("CORRESPONDENCEPINCODE", new HeaderValueType(OPTIONAL, clazz.getMethod("correspondencePinCode", String.class), NO_CONVERTOR));
            headers.put("PERMANENTADDRESS", new HeaderValueType(MANDATORY, clazz.getMethod("permanentStreet", String.class), NO_CONVERTOR));
            headers.put("PERMANENTCITY", new HeaderValueType(MANDATORY, clazz.getMethod("permanentCity", String.class), NO_CONVERTOR));
            headers.put("PERMANENTCOUNTRY", new HeaderValueType(MANDATORY, clazz.getMethod("permanentCountry", String.class), NO_CONVERTOR));
            headers.put("PERMANENTPINCODE", new HeaderValueType(MANDATORY, clazz.getMethod("permanentCity", String.class), NO_CONVERTOR));
            headers.put("PERMANENTSTATE", new HeaderValueType(MANDATORY, clazz.getMethod("permanentState", String.class), NO_CONVERTOR));
            headers.put("DEACTIVATIONDATE", new HeaderValueType(OPTIONAL, clazz.getMethod("deactivationDate", LocalDate.class), LOCAL_DATE_CONVERTOR));
            headers.put("CLIENTID", new HeaderValueType(MANDATORY, clazz.getMethod("clientId", String.class), NO_CONVERTOR));
            headers.put("UCCID", new HeaderValueType(MANDATORY, clazz.getMethod("uccId", String.class), NO_CONVERTOR));

        } catch (NoSuchMethodException e) {
           throw new HeaderConfigurationException(e);
        }
    }

    @Override
    public Map<String, HeaderValueType> getHeaderInformation() {
        return headers;
    }

}
