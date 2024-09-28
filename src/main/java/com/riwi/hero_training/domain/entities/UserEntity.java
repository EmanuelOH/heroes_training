package com.riwi.hero_training.domain.entities;

import com.riwi.hero_training.domain.enums.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Email
    @Column(length = 100, nullable = false)
    private String email;

    @Size(min = 6, max = 20)
    @Column(length = 20, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Roles role;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<StudentEntity> student;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<TeacherEntity> teacher;
}
