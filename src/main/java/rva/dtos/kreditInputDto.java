package rva.dtos;

public class kreditInputDto {
  private String opis;
  private String naziv;
  private String oznaka;
  private Integer klijent_id;

  public String getOpis() {
    return opis;
  }

  public void setOpis(String opis) {
    this.opis = opis;
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

  public Integer getKlijent_id() {
    return klijent_id;
  }

  public void setKlijent_id(Integer klijent_id) {
    this.klijent_id = klijent_id;
  }
}
