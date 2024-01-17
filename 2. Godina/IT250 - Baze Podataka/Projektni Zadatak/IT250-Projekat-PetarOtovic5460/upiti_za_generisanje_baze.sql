/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     13.01.2024. 19:59:03                         */
/*==============================================================*/


drop table if exists kreditna_kartica;

drop table if exists narodno_pozoriste;

drop table if exists pozorisni_komad;

drop table if exists predstava;

drop table if exists pretplatnik;

drop table if exists producent;

drop table if exists rezervacija;

drop table if exists se_izvodi_u;

drop table if exists trupa;

/*==============================================================*/
/* Table: kreditna_kartica                                      */
/*==============================================================*/
create table kreditna_kartica
(
   broj_kreditne_kartice varchar(100) not null,
   jedinstveni_broj_pretplatnika int not null,
   tip                  varchar(50) not null,
   datum_isteka         date not null,
   primary key (broj_kreditne_kartice)
);

/*==============================================================*/
/* Table: narodno_pozoriste                                     */
/*==============================================================*/
create table narodno_pozoriste
(
   ime_narodnog_pozorista varchar(200) not null,
   primary key (ime_narodnog_pozorista)
);

/*==============================================================*/
/* Table: pozorisni_komad                                       */
/*==============================================================*/
create table pozorisni_komad
(
   ime_pozorisnog_komada varchar(100) not null,
   primary key (ime_pozorisnog_komada)
);

/*==============================================================*/
/* Table: predstava                                             */
/*==============================================================*/
create table predstava
(
   predstava_id         int AUTO_INCREMENT not null,
   producent_id         int not null,
   ime_trupe            varchar(150) not null,
   ime_pozorisnog_komada varchar(100) not null,
   ime_predstave        varchar(200) not null,
   datum_odrzavanja     date,
   cena_ulaznice        int,
   max_mesta            int not null,
   primary key (predstava_id)
);

/*==============================================================*/
/* Table: pretplatnik                                           */
/*==============================================================*/
create table pretplatnik
(
   jedinstveni_broj_pretplatnika int AUTO_INCREMENT not null,
   broj_kreditne_kartice varchar(100),
   ime                  varchar(100) not null,
   prezime              varchar(100) not null,
   adresa               varchar(100),
   telefon              varchar(50),
   primary key (jedinstveni_broj_pretplatnika)
);

/*==============================================================*/
/* Table: producent                                             */
/*==============================================================*/
create table producent
(
   producent_id         int AUTO_INCREMENT not null,
   ime_producenta      varchar(100) not null,
   primary key (producent_id)
);

/*==============================================================*/
/* Table: rezervacija                                           */
/*==============================================================*/
create table rezervacija
(
   jedinstveni_broj_rezervacije int AUTO_INCREMENT not null,
   jedinstveni_broj_pretplatnika int not null,
   predstava_id         int not null,
   datum_rezervacije    date not null,
   iznos_za_placanje    int not null,
   mesta_rezervisano    int not null,
   primary key (jedinstveni_broj_rezervacije)
);

/*==============================================================*/
/* Table: se_izvodi_u                                           */
/*==============================================================*/
create table se_izvodi_u
(
   ime_narodnog_pozorista varchar(200) not null,
   predstava_id         int not null,
   primary key (ime_narodnog_pozorista, predstava_id)
);

/*==============================================================*/
/* Table: trupa                                                 */
/*==============================================================*/
create table trupa
(
   ime_trupe            varchar(150) not null,
   primary key (ime_trupe)
);

alter table kreditna_kartica add constraint fk_pripada2 foreign key (jedinstveni_broj_pretplatnika)
      references pretplatnik (jedinstveni_broj_pretplatnika) on delete restrict on update restrict;

alter table predstava add constraint fk_izvodi foreign key (ime_trupe)
      references trupa (ime_trupe) on delete restrict on update restrict;

alter table predstava add constraint fk_organizuje foreign key (ime_pozorisnog_komada)
      references pozorisni_komad (ime_pozorisnog_komada) on delete restrict on update restrict;

alter table predstava add constraint fk_producira foreign key (producent_id)
      references producent (producent_id) on delete restrict on update restrict;

alter table pretplatnik add constraint fk_pripada foreign key (broj_kreditne_kartice)
      references kreditna_kartica (broj_kreditne_kartice) on delete restrict on update restrict;

alter table rezervacija add constraint fk_rezervisano foreign key (predstava_id)
      references predstava (predstava_id) on delete restrict on update restrict;

alter table rezervacija add constraint fk_rezervise foreign key (jedinstveni_broj_pretplatnika)
      references pretplatnik (jedinstveni_broj_pretplatnika) on delete restrict on update restrict;

alter table se_izvodi_u add constraint fk_se_izvodi_u foreign key (ime_narodnog_pozorista)
      references narodno_pozoriste (ime_narodnog_pozorista) on delete restrict on update restrict;

alter table se_izvodi_u add constraint fk_se_izvodi_u2 foreign key (predstava_id)
      references predstava (predstava_id) on delete restrict on update restrict;

DELIMITER //

CREATE TRIGGER before_insert_rezervacija
BEFORE INSERT ON rezervacija
FOR EACH ROW
BEGIN
    DECLARE remaining_seats INT;

    SELECT (pr.max_mesta - COALESCE(SUM(mesta_rezervisano), 0))
    INTO remaining_seats
    FROM rezervacija
    INNER JOIN predstava AS pr ON rezervacija.predstava_id = pr.predstava_id
    WHERE pr.predstava_id = NEW.predstava_id;

    IF NEW.mesta_rezervisano > remaining_seats THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ne mozete rezervisati vise mesta nego sto ima slobodnih!';
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER before_insert_predstava
BEFORE INSERT ON predstava
FOR EACH ROW
BEGIN
    DECLARE datum DATE;
    DECLARE komad VARCHAR(100);
    DECLARE broj_predstava INT;

    SET datum = NEW.datum_odrzavanja;
    SET komad = NEW.ime_pozorisnog_komada;
    
    SELECT COUNT(pr.predstava_id)
    INTO broj_predstava
    FROM predstava AS pr
    WHERE pr.datum_odrzavanja = datum AND pr.ime_pozorisnog_komada = komad;

    IF broj_predstava > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Vec je rezervisana predstava sa ovim pozorisnim komadom za navedeni datum!';
    END IF;
END //

DELIMITER ;