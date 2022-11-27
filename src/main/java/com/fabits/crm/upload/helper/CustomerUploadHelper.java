package com.fabits.crm.upload.helper;

import com.fabits.crm.domain.Customer;
import com.fabits.crm.service.CustomerService;
import com.fabits.crm.upload.UploadType;
import com.fabits.crm.upload.headers.CustomerHeaders;
import com.fabits.crm.upload.headers.Headers;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
@AllArgsConstructor
public class CustomerUploadHelper implements UploadHelper<Customer , Customer.CustomerBuilder> {

    private final CustomerService customerService;

    private final CustomerHeaders headers;

    @Override
    public Customer.CustomerBuilder getBuilder() {
        return Customer.builder();
    }

    public Customer fromMap(Map<String, String> data) {
        return fillData(data, getBuilder()).build();
    }

    @Override
    public void persistData(Persistable<?> entity) {
        customerService.saveCustomer((Customer) entity);
    }

    @Override
    public UploadType forUploadType() {
        return UploadType.CUSTOMER;
    }

    @Override
    public Headers getHeaders() {
        return headers;
    }

}
