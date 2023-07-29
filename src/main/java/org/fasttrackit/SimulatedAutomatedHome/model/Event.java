package org.fasttrackit.SimulatedAutomatedHome.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Data
@Entity()
public class Event {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String triggerSensor;
    @Column
    private long dataSensor;
    @JsonIgnore
    @ManyToOne //COUNTRY_ID -> FK -> COUNTRY(ID)
    private Room room;

    public Event(long id, String triggerSensor, long dataSensor) {
        this.id = id;
        this.triggerSensor = triggerSensor;
        this.dataSensor = dataSensor;
    }
}
