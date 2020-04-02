INSERT INTO "tip_racuna"("id", "naziv", "oznaka", "opis")
VALUES(nextval('tip_racuna_seq'), 'Tekući račun', 'Tekući račun','111');
INSERT INTO "tip_racuna"("id", "naziv", "oznaka", "opis")
VALUES(nextval('tip_racuna_seq'), 'Račun oročenog depozita', 'Račun oročenog depozita','112');
INSERT INTO "tip_racuna"("id", "naziv", "oznaka", "opis")
VALUES(nextval('tip_racuna_seq'), 'Štedni račun', 'Štedni račun','113');
INSERT INTO "tip_racuna"("id", "naziv", "oznaka", "opis")
VALUES(nextval('tip_racuna_seq'), 'Namjenski račun', 'Namjenski račun','114');
INSERT INTO "tip_racuna"("id", "naziv", "oznaka", "opis")
VALUES(nextval('tip_racuna_seq'), 'Devizni račun', 'Devizni račun','115');


INSERT INTO "kredit"("id","naziv","opis","oznaka")
VALUES(nextval('kredit_seq'), 'Stambeni kredit', 'Stambeni kredit','500');
INSERT INTO "kredit"("id","naziv","opis","oznaka")
VALUES(nextval('kredit_seq'), 'Nenamjenski kredit', 'Nenamjenski kredit','501');
INSERT INTO "kredit"("id","naziv","opis","oznaka")
VALUES(nextval('kredit_seq'), 'Namjenski kredit', 'Namjenski kredit','502');
INSERT INTO "kredit"("id","naziv","opis","oznaka")
VALUES(nextval('kredit_seq'), 'Potrošački kredit', 'Potrošački kredit','503');


INSERT INTO "klijent"("id", "ime", "prezime", "broj_lk", "kredit_id")
VALUES(nextval('klijent_seq'), 'Marko', 'Marković', '127813712',1);
INSERT INTO "klijent"("id", "ime", "prezime", "broj_lk","kredit_id")
VALUES(nextval('klijent_seq'), 'Petar', 'Petrovic', '127813812',2);
INSERT INTO "klijent"("id", "ime", "prezime", "broj_lk","kredit_id")
VALUES(nextval('klijent_seq'), 'Mile', 'Miletić', '127814712',2);
INSERT INTO "klijent"("id", "ime", "prezime", "broj_lk","kredit_id")
VALUES(nextval('klijent_seq'), 'Žarko', 'Žarković', '127833712',3);
INSERT INTO "klijent"("id", "ime", "prezime", "broj_lk","kredit_id")
VALUES(nextval('klijent_seq'), 'Ranko', 'Ranković', '127813722',4);


INSERT INTO "racun"("id", "naziv", "opis", "oznaka","tip_racuna_id","klijent_id")
VALUES(nextval('racun_seq'),'Tekući račun', 'Tekući račun','111',1,1);
INSERT INTO "racun"("id", "naziv", "opis", "oznaka","tip_racuna_id","klijent_id")
VALUES(nextval('racun_seq'),'Račun oročenog depozita', 'Račun oročenog depozita','112',2,2);
INSERT INTO "racun"("id", "naziv", "opis", "oznaka","tip_racuna_id","klijent_id")
VALUES(nextval('racun_seq'),'Štedni račun', 'Štedni račun','113',3,3);
INSERT INTO "racun"("id", "naziv", "opis", "oznaka","tip_racuna_id","klijent_id")
VALUES(nextval('racun_seq'),'Namjenski račun', 'Namjenski račun','114',4,4);
INSERT INTO "racun"("id", "naziv", "opis", "oznaka","tip_racuna_id","klijent_id")
VALUES(nextval('racun_seq'),'Devizni račun', 'Devizni račun','115',5,5);



