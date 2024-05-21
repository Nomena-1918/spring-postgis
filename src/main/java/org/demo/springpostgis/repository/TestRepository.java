package org.demo.springpostgis.repository;

import org.demo.springpostgis.model.TestClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestClass, Long> {
}
