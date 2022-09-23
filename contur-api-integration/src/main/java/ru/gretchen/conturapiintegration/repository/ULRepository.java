package ru.gretchen.conturapiintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gretchen.conturapiintegration.model.req.ULEntity;

@Repository
public interface ULRepository extends JpaRepository<ULEntity, Long> {
}
