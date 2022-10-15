package com.fabits.crm.domain;

import com.fabits.crm.annotation.CsvField;
import com.fabits.crm.annotation.Datatype;
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
import java.time.LocalDate;

@Table("CUSTOMER_MASTER")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {

    @CsvField(name = "DP-Id")
    @Id
    String clientId;

    @CsvField(name = "UCC")
    String uccId;

    @CsvField(name = "Client Name")
    String name;

    @CsvField(name = "Mobile No")
    String mobile;

    @CsvField(name = "Email Id")
    String emailId;

    @CsvField(name = "PAN No")
    @Column("pan_num")
    String panNumber;

    @CsvField(name = "DOB", datatype = Datatype.DATE, format = "dd/mm/yyyy")
    @Column("dob")
    LocalDate dateOfBirth;

    @CsvField(name = "Account No")
    @Column("acc_num")
    String bankAccountNumber;

    @CsvField(name = "Primary Bank")
    @Column("bank")
    String bankName;

    @CsvField(name = "IFSC")
    @Column("ifsc")
    String ifscCode;

    @CsvField(name = "Account Type")
    @Column("acct_type")
    String accountType;

    @Column("act_date")
    LocalDate activationDate;
    @Column("balance")
    BigDecimal ledgerBalance;
    @Column("dec_date")
    LocalDate deactivationDate;
    @Column("corr_street")
    String correspondenceStreet;
    @Column("corr_city")
    String correspondenceCity;
    @Column("corr_state")
    String correspondenceState;
    @Column("corr_pin")
    String correspondencePinCode;
    @Column("per_street")
    String permanentStreet;
    @Column("per_city")
    String permanentCity;
    @Column("per_state")
    String permanentState;
    @Column("per_pin")
    String permanentPinCode;

}
