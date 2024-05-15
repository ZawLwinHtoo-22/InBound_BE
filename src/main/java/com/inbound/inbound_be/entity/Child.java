package com.inbound.inbound_be.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Child {

//    ch = child

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ch_id;
    private String ch_name;
    private LocalDate ch_dob;
    private String ch_gender;
    private String ch_gu_Name;
    private String ch_rs;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private Integer version;

    @ManyToOne
    @JoinColumn(name = "i_person_fk")
    private InsuredPerson insuredPerson;

}
