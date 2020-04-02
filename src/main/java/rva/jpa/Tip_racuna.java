package rva.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name="Tip_racuna.findAll", query="SELECT a FROM Tip_racuna a")
public class Tip_racuna implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "TIP_RACUNA_ID_GENERATOR", sequenceName = "TIP_RACUNA_SEQ", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIP_RACUNA_ID_GENERATOR")
  private Integer id;

  private String naziv;

  private String opis;

  private String oznaka;

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

  public String getOpis() {
    return opis;
  }

  public void setOpis(String opis) {
    this.opis = opis;
  }

  public String getOznaka() {
    return oznaka;
  }

  public void setOznaka(String oznaka) {
    this.oznaka = oznaka;
  }
}
