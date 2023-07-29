package org.fasttrackit.SimulatedAutomatedHome.controller;

import org.fasttrackit.SimulatedAutomatedHome.model.Sensor;
import org.fasttrackit.SimulatedAutomatedHome.service.RoomService;
import org.fasttrackit.SimulatedAutomatedHome.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rooms") // http://host:port/rooms

public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping() // GET http://host:port/sensors
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}") // GET http://host:port/sensors/1
    public Room getRoomById(@PathVariable long id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    public Room addNewRoom(@RequestBody Room room) {
        return roomService.add(room);
    }

    @DeleteMapping("/{id}")
    public Room deleteById(@PathVariable long id) {
        return roomService.delete(id);
    }

}
