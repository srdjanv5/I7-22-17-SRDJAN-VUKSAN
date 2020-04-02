package rva.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.jpa.Klijent;
import rva.jpa.Racun;

public interface RacunRepository extends JpaRepository<Racun, Integer> {

  List<Racun> findAllByKlijent_BrojLk(int data);

}

