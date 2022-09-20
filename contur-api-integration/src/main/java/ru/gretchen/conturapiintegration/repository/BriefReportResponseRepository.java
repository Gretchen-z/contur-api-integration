package ru.gretchen.conturapiintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gretchen.conturapiintegration.model.briefreport.BriefReportResponseEntity;

@Repository
public interface BriefReportResponseRepository extends JpaRepository<BriefReportResponseEntity, Long> {
}
