package ru.gretchen.conturapiintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gretchen.conturapiintegration.model.req.BranchEntity;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Long> {
}
