package com.inbound.inbound_be.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter

public class InBound_Proposal {

//    in = inbound
//    i = insured person
//    a = agent
//    j = journey
//    e = estimate
//    ar = arrive
//    p_st = policy start
//    p_en = policy end
//    pro = proposal
//    co = coverage
//    pre = premium

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID in_proposal_id;
    private String j_from;
    private String j_to;
    private LocalDate e_ar_date;
    private LocalDate p_st_date;
    private LocalDate p_en_date;
    private LocalDate pro_date;
    private Integer co_plan;
    private Double pre_rate;
    private String passportNumber;
    private String passportCountry;
    private Integer age;
//    private UUID i_id_fk;
//    private UUID a_id_fk;

    @ManyToOne
    @JoinColumn(name = "i_id_fk")
    private InsuredPerson insuredPerson;

    @ManyToOne
    @JoinColumn(name = "a_id_fk")
    private Agent agent;


}
