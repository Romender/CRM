package com.fabits.crm.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table("NON_CLIENT_MASTER")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NonRegisteredClient implements Persistable<String> {
    @Id
    String id;
    String name;
    String mobile;
    String emailId;

    @JsonIgnore
    @Transient
    boolean isNew;

    @Override
    public boolean isNew() {
        return false;
    }
}
