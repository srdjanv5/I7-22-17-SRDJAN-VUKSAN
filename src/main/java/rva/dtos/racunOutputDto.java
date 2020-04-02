package rva.dtos;

public class racunOutputDto {
  private int id;
  private String naziv;
  private String oznaka;
  private String opis;
  private int tip_racuna_id;

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

  public int getTip_racuna_id() {
    return tip_racuna_id;
  }

  public void setTip_racuna_id(int tip_racuna_id) {
    this.tip_racuna_id = tip_racuna_id;
  }


}
