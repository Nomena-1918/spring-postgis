package org.demo.springpostgis.repository;

import org.demo.springpostgis.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    @Query("SELECT s FROM us_states s")
    List<State> findAllStates();
}
