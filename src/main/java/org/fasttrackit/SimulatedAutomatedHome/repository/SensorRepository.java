package org.fasttrackit.SimulatedAutomatedHome.repository;

import org.fasttrackit.SimulatedAutomatedHome.model.Sensor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends CrudRepository<Sensor, Long> {

}
