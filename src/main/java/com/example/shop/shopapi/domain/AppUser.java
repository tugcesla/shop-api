package com.example.shop.shopapi.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "app_user")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id")
    private Role role;
}
