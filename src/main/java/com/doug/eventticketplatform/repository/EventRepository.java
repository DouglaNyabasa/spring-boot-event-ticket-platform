package com.doug.eventticketplatform.repository;

import com.doug.eventticketplatform.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Page<Event> findByOrganizerId(UUID organizerId, Pageable pageable);
}
