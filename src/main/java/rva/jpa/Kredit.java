package rva.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name="Kredit.findAll", query="SELECT a FROM Kredit a")
public class Kredit implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "KREDIT_ID_GENERATOR", sequenceName = "KREDIT_SEQ", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KREDIT_ID_GENERATOR")
  private Integer id;
  private String naziv;
  private String oznaka;
  private String opis;

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

}
