package org.fasttrackit.SimulatedAutomatedHome.repository;

import org.fasttrackit.SimulatedAutomatedHome.model.Sensor;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor>findByName(String sensorName);

    @Query("select s from Sensor s where (:name = null or lower(s.name) like lower(concat('%',:name,'%')))")
    List<Sensor> filterSensors(@Param("name") String name);
}
