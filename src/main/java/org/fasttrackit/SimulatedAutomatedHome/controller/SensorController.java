package org.fasttrackit.SimulatedAutomatedHome.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.fasttrackit.SimulatedAutomatedHome.service.SensorService;
import org.fasttrackit.SimulatedAutomatedHome.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sensors") // http://host:port/sensors

@AllArgsConstructor
@NoArgsConstructor
public class SensorController {
    @Autowired
    private SensorService sensorService;

    @GetMapping() // GET http://host:port/sensors
    public List<Sensor> getAllSensor(@RequestParam(required = false) String name) {
        return sensorService.getAllSensor(name);
    }

    @GetMapping("/{id}") // GET http://host:port/sensors/1
    public Sensor geSensorById(@PathVariable long id) {
        return sensorService.getSensorById(id);
    }

    @PostMapping
    public Sensor addNewSensor(@RequestBody Sensor sensor) {
        return sensorService.add(sensor);
    }

    @DeleteMapping("/{id}")
    public Sensor deleteById(@PathVariable long id) {
        return sensorService.delete(id);
    }

    @PutMapping("/{id}")
    public Sensor updateSensor(@RequestBody Sensor sensor, @PathVariable long id) {
        return sensorService.update(sensor, id);
    }

}
