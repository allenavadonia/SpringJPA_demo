package jpaTest.repository;

import jpaTest.entity.BonusEntity;
import jpaTest.entity.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonusRepository extends JpaRepository<BonusEntity,Integer> {
    List<BonusEntity> findAllByWorkerRefId(WorkerEntity workerRefId);
}
