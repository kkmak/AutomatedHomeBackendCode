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
    public String name;

    @Column
    public long minimumValue;

    @Column
    public long actualValue;

    @Column
    public long maximumValue;

    @Column
    public String roomWhereIsIt;


    public boolean isAlerting() {
        return actualValue < minimumValue || actualValue > maximumValue;
    }
}
