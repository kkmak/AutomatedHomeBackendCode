package org.fasttrackit.SimulatedAutomatedHome.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity

public class Room {
    @Id
    @GeneratedValue
    public long id;
    @OneToMany(mappedBy = "room", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    public List<Event> eventList;
    @OneToMany(mappedBy = "room", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})    public List<Sensor> sensorList;
    @Column
    public String roomName;

}
