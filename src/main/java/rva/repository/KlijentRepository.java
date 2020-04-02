package rva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.jpa.Klijent;

public interface KlijentRepository extends JpaRepository<Klijent, Integer> {

  Klijent findKlijentByBrojLk(Integer data);

}

