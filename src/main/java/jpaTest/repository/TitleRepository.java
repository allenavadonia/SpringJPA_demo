package jpaTest.repository;

import jpaTest.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<TitleEntity,Integer> {
    void deleteByWorkerRefId(int id);
}
