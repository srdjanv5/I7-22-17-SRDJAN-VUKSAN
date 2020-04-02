package rva.dtos;

import rva.helpers.racunData;
import java.util.List;

public class klijentOutputDto {
  private int id;
  private String ime;
  private String prezime;
  private List<racunData> racunList;


  public klijentOutputDto() {
  }

  public List<racunData> getRacunList() {
    return racunList;
  }

  public void setRacunList(List<racunData> racunList) {
    this.racunList = racunList;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
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


}
