package org.fasttrackit.SimulatedAutomatedHome.service;


import org.fasttrackit.SimulatedAutomatedHome.exception.ResourceNotFoundException;
import org.fasttrackit.SimulatedAutomatedHome.model.Sensor;
import org.fasttrackit.SimulatedAutomatedHome.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorService {
    public final SensorRepository sensorRepository;
    public List<Sensor> sensorList;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
        this.sensorList = new ArrayList<>();
        sensorRepository.saveAll(sensorList);

    }

    public List<Sensor> getAllSensor() {
        return sensorRepository.findAll();
    }

    public List<Sensor> getAllSensor(String name) {
        return sensorRepository.filterSensors(name);
    }


    public List<Sensor> getAllSensorByRoom(String roomWhereIsIt) {
        return sensorRepository.filterSensorsByRoom(roomWhereIsIt);
    }

    public Sensor add(Sensor sensor) {
        sensorRepository.save(sensor);
        return sensor;
    }

    public Sensor getSensorById(long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("sensor not found", id));
    }

    public Sensor delete(long id) {
        Sensor sensor = getSensorById(id);
        sensorRepository.deleteById(id);
        return sensor;
    }

    public Sensor update(Sensor sensor, long id) {
        Sensor existingSensor = getSensorById(id);
        return add(Sensor.builder()
                .id(id)
                .name(existingSensor.getName())
                .minimumValue(sensor.getMinimumValue())
                .maximumValue(sensor.getMaximumValue())
                .roomWhereIsIt(existingSensor.getRoomWhereIsIt())
                .build());
    }
}