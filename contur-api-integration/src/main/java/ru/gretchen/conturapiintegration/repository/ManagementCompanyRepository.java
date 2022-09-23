package ru.gretchen.conturapiintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gretchen.conturapiintegration.model.req.ManagementCompanyEntity;

@Repository
public interface ManagementCompanyRepository extends JpaRepository<ManagementCompanyEntity, Long> {
}
