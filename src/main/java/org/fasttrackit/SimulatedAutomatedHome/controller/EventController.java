package org.fasttrackit.SimulatedAutomatedHome.controller;

import org.fasttrackit.SimulatedAutomatedHome.model.Sensor;
import org.fasttrackit.SimulatedAutomatedHome.service.EventService;
import org.fasttrackit.SimulatedAutomatedHome.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("events") // http://host:port/events

public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping() // GET http://host:port/sensors
    public List<Event> getAllEvent() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}") // GET http://host:port/sensors/1
    public Event getEventById(@PathVariable long id) {
        return eventService.geEventById(id);
    }

    @PostMapping
    public Event addNewEvent(@RequestBody Event event) {
        return eventService.add(event);
    }

    @DeleteMapping("/{id}")
    public Event deleteById(@PathVariable long id) {
        return eventService.delete(id);
    }
}
