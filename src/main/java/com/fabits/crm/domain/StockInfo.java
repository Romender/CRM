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

import java.math.BigDecimal;
import java.time.LocalDate;

@Table("STOCK_INFO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StockInfo implements Persistable<String> {
    @Id
    @Column("isc_num")
    String iscNumber;
    String name;
    String symbol;
    @Column("close_date")
    LocalDate closedDate;
    @Column("pre_cl_val")
    BigDecimal preClosureValue;

    @JsonIgnore
    @Transient
    boolean isNew;

    @Override
    public String getId() {
        return iscNumber;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
