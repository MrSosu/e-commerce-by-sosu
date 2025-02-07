package com.sosu.ordini.repositories;

import com.sosu.ordini.domain.entities.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Long> {

    List<Ordine> findByCarrello_Id(Long idCarrello);

}
