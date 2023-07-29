package org.fasttrackit.SimulatedAutomatedHome.service;

import org.fasttrackit.SimulatedAutomatedHome.exception.ResourceNotFoundException;
import org.fasttrackit.SimulatedAutomatedHome.model.Event;
import org.fasttrackit.SimulatedAutomatedHome.model.Sensor;
import org.fasttrackit.SimulatedAutomatedHome.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.w3c.dom.events.EventException;

import java.util.ArrayList;
import java.util.List;

@Service

public class EventService {
    public List<Event> eventList;
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
        this.eventList = new ArrayList<>();
       // Event event = new Event(1, "Temperature", 23);
       // eventList.add(event);
        eventRepository.saveAll(eventList);
    }

    public List<Event> getAllEvents() {
        return eventList;
    }

    public Event add(Event event) {
        eventList.add(event);
        eventRepository.save(event);
        return event;
    }

    public Event geEventById(long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("event not found", id));
    }

    public Event delete(long id) {
        Event event = geEventById(id);
        eventRepository.deleteById(id);
        return event;
    }
}
