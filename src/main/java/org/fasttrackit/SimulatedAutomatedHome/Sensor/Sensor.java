package org.fasttrackit.SimulatedAutomatedHome.Sensor;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sensor {
    public String sensorName;
    public long minimumValue;
    public long maximumValue;
    public String roomWhereIsIt;
}
