package ru.gretchen.conturapiintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gretchen.conturapiintegration.model.req.address.ParsedAddressRFEntity;

@Repository
public interface ParsedAddressRFRepository extends JpaRepository<ParsedAddressRFEntity, Long> {
}
