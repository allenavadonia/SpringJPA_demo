package jpaTest.repository;

import jpaTest.entity.WorkerEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Worker repository.
 */
@Repository
public interface WorkerRepository extends JpaRepository<WorkerEntity,Integer> {
    WorkerEntity findByWorkerId(int id);
    List<WorkerEntity> findByFNameContainingOrLNameContaining(String fname, String lname);
}
