package com.pattern.builder.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String code;

    @Enumerated(EnumType.STRING)
    private UserType type;
}

