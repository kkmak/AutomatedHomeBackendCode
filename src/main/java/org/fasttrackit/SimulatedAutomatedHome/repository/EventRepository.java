package org.fasttrackit.SimulatedAutomatedHome.repository;

import org.fasttrackit.SimulatedAutomatedHome.model.Event;
import org.fasttrackit.SimulatedAutomatedHome.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
   // @Query("select a from Event a where (:id = null or lower(a.id) like lower(concat('%',:id,'%')))")
    //List<Sensor> filterSensors(@Param("id") String id);
}
