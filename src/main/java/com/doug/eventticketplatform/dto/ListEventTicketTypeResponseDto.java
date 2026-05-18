package com.doug.eventticketplatform.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListEventTicketTypeResponseDto {

    private UUID id;
    private String name;
    private  Double price;
    private String description;
    private Integer totalAvailable;
}
