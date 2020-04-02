drop table if exists kredit cascade;
drop table if exists tip_racuna cascade;
drop table if exists racun cascade;
drop table if exists klijent cascade;
drop sequence if exists tip_racuna_seq;
drop sequence if exists klijent_seq;
drop sequence if exists racun_seq;
drop sequence if exists kredit_seq;

create table kredit
(
    id     integer      not null,
    naziv  varchar(100) not null,
    oznaka varchar(20),
    opis   varchar(500)
);

create table tip_racuna
(
    id     integer      not null,
    naziv  varchar(100) not null,
    oznaka varchar(20),
    opis   varchar(500)
);


create table racun
(
    id         integer      not null,
    naziv      varchar(100) not null,
    oznaka     varchar(20),
    opis       varchar(500),
    tip_racuna integer      not null,
    klijent    integer      not null
);


create table klijent
(
    id      integer not null,
    ime     varchar(50),
    prezime varchar(50),
    broj_lk int     not null,
    kredit  int     not null
);

alter table klijent
    add constraint PK_klijent primary key (id);
alter table kredit
    add constraint PK_kredit primary key (id);
alter table racun
    add constraint PK_racun primary key (id);
alter table tip_racuna
    add constraint PK_tip_racuna primary key (id);

alter table racun
    add constraint FK_tip_racuna
        foreign key (tip_racuna) references tip_racuna (id);
alter table racun
    add CONSTRAINT FK_klijent
        FOREIGN KEY (klijent) REFERENCES klijent (id);

ALTER table klijent
    add CONSTRAINT FK_kredit
        FOREIGN KEY (kredit) REFERENCES kredit (id);

create index IDXFK_racun_tip_racuna on racun (tip_racuna);
create index IDXFK_racun_klijent on racun (klijent);
create index IDXFK_klijent_kredit on klijent (kredit);

create sequence klijent_seq increment 1;
create sequence racun_seq increment 1;
create sequence tip_racuna_seq increment 1;
create sequence kredit_seq increment 1;
