package org.fasttrackit.SimulatedAutomatedHome.repository;

import org.fasttrackit.SimulatedAutomatedHome.model.Event;
import org.fasttrackit.SimulatedAutomatedHome.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
