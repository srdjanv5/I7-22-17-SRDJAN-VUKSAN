package rva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rva.jpa.Tip_racuna;


import java.util.Collection;

public interface Tip_racunaRepository extends JpaRepository<Tip_racuna, Integer> {

  Collection<Tip_racuna> findByNaziv(String ime);

}


