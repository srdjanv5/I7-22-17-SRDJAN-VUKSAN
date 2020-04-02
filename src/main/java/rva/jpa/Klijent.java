package rva.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@NamedQuery(name = "Klijent.findAll", query = "SELECT a FROM Klijent a")
public class Klijent implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "KLIJENT_ID_GENERATOR", sequenceName = "KLIJENT_SEQ", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KLIJENT_ID_GENERATOR")
  private Integer id;

  private String ime;

  private String prezime;

  private Integer brojLk;

  @OneToOne
  private Kredit kredit;

  public Klijent() {
  }

  public void setBrojLk(Integer brojLk) {
    this.brojLk = brojLk;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getIme() {
    return ime;
  }

  public void setIme(String ime) {
    this.ime = ime;
  }

  public String getPrezime() {
    return prezime;
  }

  public void setPrezime(String prezime) {
    this.prezime = prezime;
  }

  public int getBrojLk() {
    return brojLk;
  }

  public void setBrojLk(int broj_lk) {
    this.brojLk = broj_lk;
  }

  public Kredit getKredit() {
    return kredit;
  }

  public void setKredit(Kredit kredit) {
    this.kredit = kredit;
  }
}
