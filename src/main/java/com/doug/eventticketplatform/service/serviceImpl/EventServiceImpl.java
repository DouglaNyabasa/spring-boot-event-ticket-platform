package com.doug.eventticketplatform.service.serviceImpl;

import com.doug.eventticketplatform.Exceptions.UserNotFoundException;
import com.doug.eventticketplatform.model.Event;
import com.doug.eventticketplatform.model.TicketType;
import com.doug.eventticketplatform.model.User;
import com.doug.eventticketplatform.repository.EventRepository;
import com.doug.eventticketplatform.repository.UserRepository;
import com.doug.eventticketplatform.request.CreateEventRequest;
import com.doug.eventticketplatform.service.EventService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class EventServiceImpl implements EventService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public EventServiceImpl(UserRepository userRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }


    @Override
    public Event createEvent(UUID organizerId, CreateEventRequest event) {
        User organizer = userRepository.findById(organizerId).orElseThrow(
                () -> new UserNotFoundException(
                        String.format("User with id " + organizerId + " not found")
                )
        );
        Event eventToCreate = new Event();

        List<TicketType> ticketTypesToCreate = event.getTicketTypes().stream().map(
             ticketType -> {
                 TicketType ticketTypeToCreate = new TicketType();
                 ticketTypeToCreate.setName(ticketType.getName());
                 ticketTypeToCreate.setPrice(ticketType.getPrice());
                 ticketTypeToCreate.setDescription(ticketType.getDescription());
                 ticketTypeToCreate.setTotalAvailable(ticketType.getTotalAvailable());
                 ticketTypeToCreate.setEvent(eventToCreate);
                 return ticketTypeToCreate;
             }
        ).toList();
        eventToCreate.setName(event.getName());
        eventToCreate.setStartTime(event.getStartTime());
        eventToCreate.setEndTime(event.getEndTime());
        eventToCreate.setVenue(event.getVenue());
        eventToCreate.setSalesStartTime(event.getSalesStart());
        eventToCreate.setSalesEndTime(event.getSalesEnd());
        eventToCreate.setStatus(event.getStatus());
        eventToCreate.setOrganizer(organizer);
        eventToCreate.setTicketTypes(ticketTypesToCreate);
        return eventRepository.save(eventToCreate);



    }

    @Override
    public Page<Event> listEventsForOrganizers(UUID organizerId, Pageable pageable) {

        return  eventRepository.findByOrganizerId(organizerId,pageable);
    }
}
