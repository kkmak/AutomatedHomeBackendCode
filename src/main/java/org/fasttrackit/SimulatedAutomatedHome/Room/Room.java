package org.fasttrackit.SimulatedAutomatedHome.Room;

import lombok.*;
import org.fasttrackit.SimulatedAutomatedHome.Event.Event;
import org.fasttrackit.SimulatedAutomatedHome.Sensor.Sensor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Room {
    public List<Sensor> sensorList;
    public List<Event> eventList;
}
