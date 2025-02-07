package com.sosu.ordini.repositories;

import com.sosu.ordini.domain.entities.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrelloRepository extends JpaRepository<Carrello, Long> {
}
