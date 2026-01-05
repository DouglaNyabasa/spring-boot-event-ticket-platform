package com.doug.eventticketplatform.request;


import com.doug.eventticketplatform.domain.EventStatus;
import com.doug.eventticketplatform.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequest {

    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String venue;
    private LocalDateTime salesStart;
    private LocalDateTime salesEnd;
    private EventStatus status;
    private List<CreateTicketTypeRequest> ticketTypes = new ArrayList<>();



}
