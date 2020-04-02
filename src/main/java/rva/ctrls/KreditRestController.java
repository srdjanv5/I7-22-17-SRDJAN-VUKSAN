package rva.ctrls;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import rva.dtos.kreditInputDto;
import rva.jpa.Klijent;
import rva.jpa.Kredit;
import rva.repository.KlijentRepository;
import rva.repository.KreditRepository;

import java.util.Collection;

@Api(tags = {"Kredit CRUD operacije"})
@RestController
public class KreditRestController {

  @Autowired
  private KreditRepository kreditRepository;

  @Autowired
  private KlijentRepository klijentRepository;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @ApiOperation(value = "Vraca kolekciju svih klijenata iz baze podataka")
  @CrossOrigin
  @GetMapping("kredit")
  public Collection<Kredit> getTypes() {
    return kreditRepository.findAll();
  }

  @ApiOperation(value = "Vraca klijenta iz baze podataka ciji je id vrednost prosledjena kao path varijabla")
  @GetMapping("kredit/{id}")
  public Kredit getType(@PathVariable("id") Integer id) {
    return kreditRepository.getOne(id);
  }

  @ApiOperation(value = "Vraca klijenta iz baze podataka ciji je id vrednost prosledjena kao path varijabla")
  @GetMapping("kredit/klijent/{broj_lk}")
  public Kredit getByKlijent(@PathVariable("broj_lk") Integer broj_lk) {

   Klijent klijent = klijentRepository.findKlijentByBrojLk(broj_lk);
   Kredit kreda =  klijent.getKredit();
   return  kreda;
  }



  @ApiOperation(value = "Br¡se klijenta iz baze podataka ciji je id vrednost prosledjena kao path varijabla")
  @CrossOrigin
  @DeleteMapping("kredit/{id}")
  public ResponseEntity<Kredit> deleteType(@PathVariable ("id") Integer id) {
    if (!kreditRepository.existsById(id))
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    kreditRepository.deleteById(id);
    if(id == -100)
      jdbcTemplate.execute(" INSERT INTO \"kredit\" (\"id\", \"naziv\", \"opis\", \"oznaka\") VALUES (-100, 'TestType', 'TestyT', '00000000', '0001') ");
    return new ResponseEntity<>(HttpStatus.OK);
  }

  // insert
  @PostMapping("kredit")
  @CrossOrigin
  @ApiOperation(value = "Upisuje klijenta u bazu podataka")
  public ResponseEntity<Kredit> insertType(@RequestBody kreditInputDto data) {
      Klijent klijent = klijentRepository.getOne(data.getKlijent_id());
      if(klijent.getKredit() == null){
        Kredit kredit = new Kredit();
        BeanUtils.copyProperties(data,kredit);
        kreditRepository.save(kredit);
        klijent.setKredit(kredit);
        klijentRepository.save(klijent);
        return new ResponseEntity<>(HttpStatus.OK);
      }
      return  new ResponseEntity<>(HttpStatus.CONFLICT);


  }

  // update
  @CrossOrigin
  @PutMapping("kredit")
  @ApiOperation(value = "Modifikuje postojeceg klijenta u bazi podataka")
  public ResponseEntity<Kredit> updateType(@RequestBody Kredit kredit) {
    if (!kreditRepository.existsById(kredit.getId()))
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    kreditRepository.save(kredit);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
