package ru.gretchen.conturapiintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gretchen.conturapiintegration.model.req.HeadEntity;

@Repository
public interface HeadRepository extends JpaRepository<HeadEntity, Long> {
}
