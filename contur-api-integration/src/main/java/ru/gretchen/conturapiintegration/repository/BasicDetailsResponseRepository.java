package ru.gretchen.conturapiintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gretchen.conturapiintegration.model.req.BasicDetailsResponseEntity;

@Repository
public interface BasicDetailsResponseRepository extends JpaRepository<BasicDetailsResponseEntity, Long> {
}
