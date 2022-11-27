package com.fabits.crm.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

@Builder
@Getter
public class UploadFiles implements Persistable<String> {

    @Id
    private String id;

    private String fileName;

    private boolean status;

    private boolean isNew;


    @Override
    public boolean isNew() {
        return false;
    }
}
