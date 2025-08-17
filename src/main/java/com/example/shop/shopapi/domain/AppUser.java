package com.example.shop.shopapi.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="app_user")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true) private String username;
    @Column(nullable=false) private String password;
    @Column(nullable=false, unique=true) private String email;

    @ManyToOne(optional=false) @JoinColumn(name="role_id")
    private Role role;
}
