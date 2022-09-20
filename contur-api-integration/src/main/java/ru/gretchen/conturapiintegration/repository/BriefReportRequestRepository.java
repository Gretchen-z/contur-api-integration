package ru.gretchen.conturapiintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gretchen.conturapiintegration.model.BriefReportRequestEntity;

@Repository
public interface BriefReportRequestRepository extends JpaRepository<BriefReportRequestEntity, Long> {
}
