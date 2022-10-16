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
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("COURIER_MASTER")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourierMaster implements Persistable<String> {
    @Id
    String id;
    @Column("comp_name")
    String companyName;
    @Column("cnt_prsn")
    String contactPerson;
    String mobile;
    String street;
    String city;
    String state;
    String pinCode;
    @JsonIgnore
    @Transient
    boolean isNew;

    @Override
    public boolean isNew() {
        return isNew;
    }
}
