package rva.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name="Racun.findAll", query="SELECT a FROM Racun a")
public class Racun implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "RACUN_ID_GENERATOR", sequenceName = "RACUN_SEQ", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RACUN_ID_GENERATOR")
  private Integer id;

  private String naziv;

  private String oznaka;

  private String opis;

  @OneToOne
  private Tip_racuna tipRacuna;

  @ManyToOne
  private Klijent klijent;

  public Racun() {
  }

  public Klijent getKlijent() {
    return klijent;
  }

  public void setKlijent(Klijent klijent) {
    this.klijent = klijent;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNaziv() {
    return naziv;
  }

  public void setNaziv(String naziv) {
    this.naziv = naziv;
  }

  public String getOznaka() {
    return oznaka;
  }

  public void setOznaka(String oznaka) {
    this.oznaka = oznaka;
  }

  public String getOpis() {
    return opis;
  }

  public void setOpis(String opis) {
    this.opis = opis;
  }

  public Tip_racuna getTipRacuna() {
    return tipRacuna;
  }

  public void setTipRacuna(Tip_racuna tip_racuna) {
    this.tipRacuna = tip_racuna;
  }


}
