package jpaTest.repository;

import jpaTest.entity.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Worker repository.
 */
@Repository
public interface WorkerRepository extends JpaRepository<WorkerEntity,Integer> {
    WorkerEntity findByWorkerId(int id);
}
