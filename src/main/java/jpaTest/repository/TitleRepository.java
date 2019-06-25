package jpaTest.repository;

import jpaTest.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<TitleEntity,Integer> {
}
