package com.doug.eventticketplatform.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketTypeResponseDto {

    private UUID id;

    private String name;

    private  Double price;

    private String description;

    private Integer totalAvailable;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
