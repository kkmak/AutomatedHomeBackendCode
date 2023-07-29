package org.fasttrackit.SimulatedAutomatedHome.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Sensor {
    @Id
    @GeneratedValue
    public  long id;
    @Column
    public String sensorName;
    @Column

    public long minimumValue;
    @Column

    public long maximumValue;
    @Column

    public String roomWhereIsIt;
    @JsonIgnore
    @ManyToOne //COUNTRY_ID -> FK -> COUNTRY(ID)
    private Room room;

    public Sensor(long id, String sensorName, long minimumValue, long maximumValue, String roomWhereIsIt) {
        this.id = id;
        this.sensorName = sensorName;
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
        this.roomWhereIsIt = roomWhereIsIt;
    }
}
