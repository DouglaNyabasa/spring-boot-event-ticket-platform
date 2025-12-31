package com.doug.eventticketplatform.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false,nullable = false)
    private UUID id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @CreatedDate
    @Column(name = "created_at",updatable = false,nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;



}
