package rva.helpers;

import rva.jpa.Tip_racuna;

public class racunData {
  private int id;
  private String naziv;
  private String opis;
  private String oznaka;
  private Tip_racuna tip_racuna;

  public racunData() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public Tip_racuna getTip_racuna() {
    return tip_racuna;
  }

  public void setTip_racuna(Tip_racuna tip_racuna) {
    this.tip_racuna = tip_racuna;
  }
}
