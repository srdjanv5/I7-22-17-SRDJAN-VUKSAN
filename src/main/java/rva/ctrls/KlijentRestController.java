package rva.ctrls;

import java.util.ArrayList;
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
import rva.dtos.klijentOutputDto;
import rva.helpers.racunData;
import rva.jpa.Klijent;
import rva.jpa.Racun;
import rva.repository.KlijentRepository;
import rva.repository.RacunRepository;

@Api(tags = {"Klijent CRUD operacije"})
@RestController
public class KlijentRestController {

	@Autowired
	private KlijentRepository klijentRepository;

	@Autowired
  private RacunRepository racunRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@ApiOperation(value = "Vraca kolekciju svih klijenata iz baze podataka")
  @CrossOrigin
	@GetMapping("klijent")
	public Collection<Klijent> getKlijents() {
		return klijentRepository.findAll();
	}

	@ApiOperation(value = "Vraca klijenta iz baze podataka ciji je id vrednost prosledjena kao path varijabla")
  @CrossOrigin
	@GetMapping("klijent/{id}")
	public Klijent getKlijent(@PathVariable("id") Integer id) {
		return klijentRepository.getOne(id);
	}

	@ApiOperation(value = "Vraca klijenta iz baze podataka koji u imenu sadrzi string prosledjen kao path varijabla")
  @CrossOrigin
	@GetMapping("klijent/lk/{broj_lk}")
	public Klijent getKlijentByBrojLk(@PathVariable ("broj_lk") Integer data) {
		Klijent klijent =  klijentRepository.findKlijentByBrojLk(data);
    return klijent;
	}

	@ApiOperation(value = "Brise klijenta iz baze podataka ciji je id vrednost prosledjena kao path varijabla")
	@CrossOrigin
	@DeleteMapping("klijent/{id}")
	public ResponseEntity<Klijent> deleteKlijent(@PathVariable ("id") Integer id) {
		if (!klijentRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		klijentRepository.deleteById(id);
		if(id == -100)
			jdbcTemplate.execute(" INSERT INTO \"klijent\" (\"id\", \"ime\", \"prezime\", \"broj_lk\", \"kredit\") VALUES (-100, 'Testan', 'Testovic', '00000000', -20) ");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// insert
	@PostMapping("klijent")
	@CrossOrigin
	@ApiOperation(value = "Upisuje klijenta u bazu podataka")
	public ResponseEntity<Klijent> insertKlijent(@RequestBody Klijent klijent) {
		if (!klijentRepository.existsById(klijent.getId())) {
			klijentRepository.save(klijent);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	// update
	@CrossOrigin
	@PutMapping("klijent")
	@ApiOperation(value = "Modifikuje postojeceg klijenta u bazi podataka")
	public ResponseEntity<Klijent> updateKlijent(@RequestBody Klijent klijent) {
		if (!klijentRepository.existsById(klijent.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		klijentRepository.save(klijent);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
