package org.fasttrackit.SimulatedAutomatedHome.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.fasttrackit.SimulatedAutomatedHome.model.Sensor;
import org.fasttrackit.SimulatedAutomatedHome.service.EventService;
import org.fasttrackit.SimulatedAutomatedHome.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("events") // http://host:port/events
@AllArgsConstructor
@NoArgsConstructor

public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping() // GET http://host:port/sensors
    public List<Event> getAllEvent() {
        return eventService.getAllEvents();
    }

    @PostMapping
    public Event addNewEvent(@RequestBody Event event) {
        return eventService.add(event);
    }
}
