package com.inbound.inbound_be.entity;

import com.inbound.inbound_be.dto.ChildRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @OneToOne
    @JoinColumn(name = "i_person_fk")
    private InsuredPerson insuredPerson;
    public static Child of(ChildRequest request){
        Child child1 = new Child();
        child1.setCh_name(request.getCh_name());
        child1.setCh_dob(request.getCh_dob());
        child1.setCh_gender(request.getCh_gender());
        child1.setCh_gu_Name(request.getCh_gu_Name());
        child1.setCh_rs(request.getCh_rs());

        return child1;
    }
}
