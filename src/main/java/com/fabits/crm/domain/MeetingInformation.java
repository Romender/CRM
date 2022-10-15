package com.fabits.crm.domain;

import com.fabits.crm.constants.ClientType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("Meeting_master")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MeetingInformation {
    @Id
    String id;
    LocalDateTime meetingTime;
    ClientType clientType;
    String clientId;
    String employeeId;
    String meetingNotes;

}
