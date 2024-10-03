package com.riwi.hero_training.domain.entities;

import com.riwi.hero_training.domain.enums.Difficulty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "missions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The mission name is mandatory.")
    @Size(max = 100, message = "The mission name must not exceed 100 characters.")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "The mission description is mandatory.")
    @Size(max = 500, message = "The mission description must not exceed 500 characters.")
    @Column(nullable = false, length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @CreatedBy
    private Long created_by;

    @Column
    private Long evaluate;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private UserEntity teacher;

    @ManyToMany
    @JoinTable(
            name = "mission_students",
            joinColumns = @JoinColumn(name = "mission_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<StudentEntity> students;
}
