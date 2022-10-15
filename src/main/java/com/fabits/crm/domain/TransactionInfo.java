package com.fabits.crm.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("TXN_INFO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionInfo implements Entity {
    @Id
    String id;
    String uccId;
    String clientId;
    @Column("isc_num")
    String iscNumber;
    BigDecimal quantity;
    @Column("avg_price")
    BigDecimal averagePrice;
}
