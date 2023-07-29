package org.fasttrackit.SimulatedAutomatedHome.service;

import org.fasttrackit.SimulatedAutomatedHome.exception.ResourceNotFoundException;
import org.fasttrackit.SimulatedAutomatedHome.model.Room;
import org.fasttrackit.SimulatedAutomatedHome.model.Sensor;
import org.fasttrackit.SimulatedAutomatedHome.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    public List<Room> roomList = new ArrayList<>();
    public RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
        this.roomList = new ArrayList<>();
       // Room room = new Room(1,null,null,"Living Room");
        //roomList.add(room);
        roomRepository.saveAll(roomList);
    }

    public List<Room> getAllRooms() {
        return roomList;
    }

    public Room add(Room room) {
        roomList.add(room);
        roomRepository.save(room);
        return room;
    }

    public Room getRoomById   (long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("room not found", id));
    }

    public Room delete(long id) {
        Room room = getRoomById(id);
        roomRepository.deleteById(id);
        return room;
    }
}
