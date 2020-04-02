package rva.ctrls;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rva.dtos.racunInputDto;
import rva.jpa.Klijent;
import rva.jpa.Racun;
import rva.jpa.Tip_racuna;
import rva.repository.KlijentRepository;
import rva.repository.RacunRepository;
import rva.repository.Tip_racunaRepository;

@Api(tags = {"Racun CRUD operacije"})
@RestController
public class RacunRestController {

  @Autowired
  private RacunRepository racunRepository;

  @Autowired
  private KlijentRepository klijentRepository;

  @Autowired Tip_racunaRepository tip_racunaRepository;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @ApiOperation(value = "Vraca kolekciju svih racuna iz baze podataka")
  @GetMapping("racun")
  @CrossOrigin
  public Collection<Racun> getRacuns() {
    return racunRepository.findAll();
  }

  @ApiOperation(value = "Vraca racun iz baze podataka ciji je id vrednost prosledjena kao path varijabla")
  @CrossOrigin
  @GetMapping("racun/{id}")
  public Racun getRacun(@PathVariable("id") Integer id) {
    return racunRepository.getOne(id);
  }


  @ApiOperation(value = "Vraca racun iz baze podataka ciji je id vrednost prosledjena kao path varijabla")
  @CrossOrigin
  @GetMapping("racun/lk/{data}")
  public List<Racun> getRacunsByKlijent(@PathVariable("data") Integer data) {
    return racunRepository.findAllByKlijent_BrojLk(data);
  }

  @ApiOperation(value = "Br¡se klijenta iz baze podataka ciji je id vrednost prosledjena kao path varijabla")
  @CrossOrigin
  @DeleteMapping("racun/{id}")
  public ResponseEntity<Racun> deleteRacun(@PathVariable ("id") Integer id) {
    if (!racunRepository.existsById(id))
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    racunRepository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  // insert
  @PostMapping("racun")
  @CrossOrigin
  @ApiOperation(value = "Upisuje klijenta u bazu podataka")
  public ResponseEntity<Racun> insertRacun(@RequestBody racunInputDto data) {
    if (!racunRepository.existsById(data.getId())) {
      Klijent klijent = klijentRepository.getOne(data.getKlijent_id());
      Tip_racuna tip_racuna = tip_racunaRepository.getOne(data.getTip_racuna_id());
      Racun racun = new Racun();
      BeanUtils.copyProperties(data, racun);
      racun.setKlijent(klijent);
      racun.setTipRacuna(tip_racuna);
      racunRepository.save(racun);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.CONFLICT);
  }

  // update
  @CrossOrigin
  @PutMapping("racun")
  @ApiOperation(value = "Modifikuje postojeceg klijenta u bazi podataka")
  public ResponseEntity<Racun> updateRacun(@RequestBody Racun racun) {
    if (!racunRepository.existsById(racun.getId()))
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    racunRepository.save(racun);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
