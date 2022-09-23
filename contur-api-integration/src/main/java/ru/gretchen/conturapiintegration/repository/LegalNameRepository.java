package ru.gretchen.conturapiintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gretchen.conturapiintegration.model.req.LegalNameEntity;

@Repository
public interface LegalNameRepository extends JpaRepository<LegalNameEntity, Long> {
}
