package com.e_chem.internet_shop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ElementCollection
    @CollectionTable(
            name = "user_addresses",
            joinColumns = @JoinColumn(name = "user_id"),
            foreignKey = @ForeignKey(name = "user_address_fk"))
    private List<Address> address;
    @ElementCollection
    @CollectionTable(
            name = "user_phones",
            joinColumns = @JoinColumn(name = "user_id"),
            foreignKey = @ForeignKey(name = "user_phone_fk"))
    private List<PhoneNumber> phoneNumberList = new ArrayList<>();

    private LocalDateTime created = LocalDateTime.now();
    enum Role{
        ADMIN, GUEST, CLIENT, MANAGER;
    }
}
