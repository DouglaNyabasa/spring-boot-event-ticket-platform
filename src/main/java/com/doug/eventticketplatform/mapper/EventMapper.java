package com.doug.eventticketplatform.mapper;

import com.doug.eventticketplatform.dto.CreateEventRequestDto;
import com.doug.eventticketplatform.dto.CreateEventResponseDto;
import com.doug.eventticketplatform.dto.CreateTicketTypeRequestDto;
import com.doug.eventticketplatform.model.Event;
import com.doug.eventticketplatform.request.CreateEventRequest;
import com.doug.eventticketplatform.request.CreateTicketTypeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto requestDto);

    CreateEventRequest fromDto(CreateEventRequestDto requestDto);

    CreateEventResponseDto toDto(Event event);
}
