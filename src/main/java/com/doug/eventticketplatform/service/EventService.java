package com.doug.eventticketplatform.service;

import com.doug.eventticketplatform.model.Event;
import com.doug.eventticketplatform.request.CreateEventRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EventService {

    Event createEvent(UUID organizerId, CreateEventRequest event);
    Page<Event> listEventsForOrganizers(UUID organizerId, Pageable pageable);
}
