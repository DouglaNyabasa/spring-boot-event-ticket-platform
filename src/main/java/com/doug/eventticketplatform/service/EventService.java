package com.doug.eventticketplatform.service;

import com.doug.eventticketplatform.model.Event;
import com.doug.eventticketplatform.request.CreateEventRequest;

import java.util.UUID;

public interface EventService {

    Event createEvent(UUID organizerId, CreateEventRequest event);
}
