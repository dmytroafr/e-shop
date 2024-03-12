//package com.e_chem.internet_shop.domain;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.List;
//@Entity
//@Table(name = "agents")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Agent {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long id;
//
//    @Column(nullable = false)
//    private String name;
//    private String type;
//    private Long code;
//    private Long vat;
//    @Embedded
//    private Address address;
//
//    @ElementCollection
//    @CollectionTable(name = "agent_phones", joinColumns = @JoinColumn(name = "agent_id"))
//    private List<PhoneNumber> phoneNumberList = new ArrayList<>();
//}
