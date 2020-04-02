package rva.ctrls;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import rva.jpa.Tip_racuna;
import rva.repository.Tip_racunaRepository;

import java.util.Collection;

@Api(tags = {"Tip Racuna CRUD operacije"})
@RestController
public class Tip_racunaRestController {

  @Autowired
  private Tip_racunaRepository tip_racunaRepository;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @CrossOrigin
  @ApiOperation(value = "Vraca kolekciju svih tipova racuna iz baze podataka")
  @GetMapping("tip_racuna")
  public Collection<Tip_racuna> getTypes() {
    return tip_racunaRepository.findAll();
  }

  @ApiOperation(value = "Vraca tip rcuna iz baze podataka ciji je id vrednost prosledjena kao path varijabla")
  @GetMapping("tip_racuna/{id}")
  public Tip_racuna getType(@PathVariable("id") Integer id) {
    return tip_racunaRepository.getOne(id);
  }

  @ApiOperation(value = "Vraca tip racuna iz baze podataka koji u imenu sadrzi string prosledjen kao path varijabla")
  @GetMapping("tip_racuna/{naziv}")
  public Collection<Tip_racuna> getTypeByName(@PathVariable("naziv") String naziv) {
    return tip_racunaRepository.findByNaziv(naziv);
  }

  @ApiOperation(value = "Brise tip racuna iz baze podataka ciji je id vrednost prosledjena kao path varijabla")
  @CrossOrigin
  @DeleteMapping("tip_racuna/{id}")
  public ResponseEntity<Tip_racuna> deleteType(@PathVariable("id") Integer id) {
    if (!tip_racunaRepository.existsById(id))
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    tip_racunaRepository.deleteById(id);
    if (id == -100)
      jdbcTemplate.execute(" INSERT INTO \"tip_racuna\" (\"id\", \"naziv\", \"opis\", \"oznaka\") VALUES (-100, 'TestType', 'TestyT', '00000000', '0001') ");
    return new ResponseEntity<>(HttpStatus.OK);
  }

  // insert
  @PostMapping("tip_racuna")
  @CrossOrigin
  @ApiOperation(value = "Upisuje tip racuna u bazu podataka")
  public ResponseEntity<Tip_racuna> insertType(@RequestBody Tip_racuna tip_racuna) {
    System.out.println(tip_racuna.getId());
    if (!tip_racunaRepository.existsById(tip_racuna.getId())) {
      tip_racunaRepository.save(tip_racuna);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.CONFLICT);
  }

  // update
  @CrossOrigin
  @PutMapping("tip_racuna")
  @ApiOperation(value = "Modifikuje postojeci tip racuna u bazi podataka")
  public ResponseEntity<Tip_racuna> updateType(@RequestBody Tip_racuna tip_racuna) {
    if (!tip_racunaRepository.existsById(tip_racuna.getId()))
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    tip_racunaRepository.save(tip_racuna);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
