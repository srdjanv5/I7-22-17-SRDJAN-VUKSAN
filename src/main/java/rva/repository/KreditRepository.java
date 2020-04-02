package rva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rva.jpa.Kredit;

import java.util.Collection;

public interface KreditRepository extends JpaRepository<Kredit, Integer> {

}

