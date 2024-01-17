INSERT INTO pretplatnik (`jedinstveni_broj_pretplatnika`, `ime`, `prezime`, `broj_kreditne_kartice`, `adresa`, `telefon`) VALUES
(3, 'Stevan', 'Planic', '3333-4444-5555-6666', 'Cara Lazara 10', '0634567890'),
(2, 'Miomir', 'Dragovic', '2222-3333-4444-5555', 'Knez Mihailova 25', '0623456789'),
(1, 'Zelimir', 'Prodanovic', '1111-2222-3333-4444', 'Bulevar Despota Stefana 15', '0612345678'),
(4, 'Petar', 'Petrovic', '4444-5555-6666-7777', 'Trg Republike 7', '0645678901'),
(5, 'Zeljko', 'Zeljkovic', '5555-6666-7777-8888', 'Cara Nemanje 22', '0656789012');

INSERT INTO kreditna_kartica (broj_kreditne_kartice, jedinstveni_broj_pretplatnika, tip, datum_isteka)
VALUES
('1111-2222-3333-4444', 1, 'MasterCard', '2024-12-31'),
('2222-3333-4444-5555', 2, 'Visa', '2023-11-30'),
('3333-4444-5555-6666', 3, 'American Express', '2025-08-31'),
('4444-5555-6666-7777', 4, 'Discover', '2022-10-31'),
('5555-6666-7777-8888', 5, 'Diners Club', '2026-05-31');

INSERT INTO `pozorisni_komad`(`ime_pozorisnog_komada`) 
VALUES 
('Stefan Nemanja'),
('Cele Kula'),
('Picasso');

INSERT INTO `producent`(`producent_id`, `ime_producenta_`) 
VALUES 
(1,'Maksim Svetlanovic'),
(2,'Gradimir Eror');

INSERT INTO `trupa`(`ime_trupe`) 
VALUES 
('Star Wars'),
('Kraljevski Teatar');

INSERT INTO `narodno_pozoriste`(`ime_narodnog_pozorista`) 
VALUES 
('Pozoriste Bora Stankovic'),
('Pozoriste Bojan Stupica'),
('Pozoriste na Terazijama');

INSERT INTO `predstava` (`predstava_id`, `ime_predstave`, `producent_id`, `ime_trupe`, `ime_pozorisnog_komada`, `datum_odrzavanja`, `cena_ulaznice`, `max_mesta`) VALUES
(21, 'Ne Gledam Rijaliti', 1, 'Kraljevski Teatar', 'Picasso', '2034-09-25', 2200, 233),
(20, 'Seherzada', 2, 'Star Wars', 'Stefan Nemanja', '2014-08-24', 2100, 400),
(18, 'Ana Karenjina', 2, 'Star Wars', 'Picasso', '2015-06-22', 1900, 200),
(19, 'Nindza Kornjace', 1, 'Kraljevski Teatar', 'Cele Kula', '2033-07-23', 2000, 150),
(16, 'Nindza Kornjace', 2, 'Star Wars', 'Cele Kula', '2016-04-20', 1700, 100),
(17, 'Nindza Kornjace', 1, 'Kraljevski Teatar', 'Stefan Nemanja', '2032-05-21', 1800, 200),
(15, 'Ne Gledam Rijaliti', 1, 'Kraljevski Teatar', 'Picasso', '2031-03-19', 1600, 500),
(14, 'Seherzada', 2, 'Star Wars', 'Stefan Nemanja', '2017-02-18', 1500, 400),
(13, 'Zlocin i kazna', 1, 'Kraljevski Teatar', 'Cele Kula', '2030-01-17', 1400, 300),
(12, 'Ana Karenjina', 2, 'Star Wars', 'Picasso', '2018-12-16', 1300, 70),
(11, 'Nindza Kornjace', 1, 'Kraljevski Teatar', 'Stefan Nemanja', '2029-11-15', 1200, 145),
(10, 'Nindza Kornjace', 2, 'Star Wars', 'Cele Kula', '2019-10-14', 1100, 233),
(9, 'Zlocin i kazna', 1, 'Kraljevski Teatar', 'Picasso', '2028-09-13', 1000, 200),
(8, 'Ne Gledam Rijaliti', 2, 'Star Wars', 'Stefan Nemanja', '2020-08-12', 900, 200),
(7, 'Seherzada', 1, 'Kraljevski Teatar', 'Cele Kula', '2027-07-11', 800, 15),
(6, 'Nindza Kornjace', 2, 'Star Wars', 'Picasso', '2021-06-10', 700, 60),
(5, 'Nindza Kornjace', 1, 'Kraljevski Teatar', 'Stefan Nemanja', '2026-05-09', 600, 323),
(4, 'Zlocin i kazna', 2, 'Star Wars', 'Cele Kula', '2022-04-08', 500, 1111),
(3, 'Seherzada', 1, 'Kraljevski Teatar', 'Picasso', '2025-03-07', 400, 123),
(2, 'Zlocin i kazna', 2, 'Star Wars', 'Stefan Nemanja', '2023-02-06', 300, 200),
(1, 'Ana Karenjina', 1, 'Kraljevski Teatar', 'Cele Kula', '2024-01-05', 200, 100),
(22, 'Ne Gledam Rijaliti', 2, 'Star Wars', 'Cele Kula', '2013-10-26', 2300, 200),
(23, 'Ne Gledam Rijaliti', 1, 'Kraljevski Teatar', 'Stefan Nemanja', '2035-11-27', 2400, 100);

INSERT INTO `se_izvodi_u`(`ime_narodnog_pozorista`, `predstava_id`) 
VALUES 
('Pozoriste Bora Stankovic',1),
('Pozoriste Bojan Stupica',2),
('Pozoriste na Terazijama',3),
('Pozoriste Bora Stankovic',4),
('Pozoriste Bojan Stupica',5),
('Pozoriste na Terazijama',6),
('Pozoriste Bora Stankovic',7),
('Pozoriste Bojan Stupica',8),
('Pozoriste na Terazijama',9),
('Pozoriste Bora Stankovic',10),
('Pozoriste Bojan Stupica',11),
('Pozoriste na Terazijama',12),
('Pozoriste Bora Stankovic',13),
('Pozoriste Bojan Stupica',14),
('Pozoriste na Terazijama',15),
('Pozoriste Bora Stankovic',16),
('Pozoriste Bojan Stupica',17),
('Pozoriste na Terazijama',18),
('Pozoriste Bora Stankovic',19),
('Pozoriste Bojan Stupica',20),
('Pozoriste na Terazijama',21),
('Pozoriste Bora Stankovic',22),
('Pozoriste Bojan Stupica',23);

INSERT INTO `rezervacija`(`jedinstveni_broj_rezervacije`, `jedinstveni_broj_pretplatnika`, `predstava_id`, `datum_rezervacije`, `iznos_za_placanje`, `mesta_rezervisano`) 
VALUES 
(1,1,1,'2024-1-5','20000','100'),
(2,2,2,'2023-2-6','60000','200'),
(3,3,3,'2025-3-7','22000','55'),
(59,2,3,'2025-3-7','22000','55'),
(4,4,4,'2022-4-8','44500','89'),
(5,3,4,'2022-4-8','100000','200'),
(6,5,5,'2026-5-9','73800','123'),
(7,1,5,'2026-5-9','73800','123'),
(8,2,5,'2026-5-9','30000','50'),
(9,1,6,'2021-6-10','14000','20'),
(10,4,6,'2021-6-9','21000','30'),
(11,2,7,'2027-7-11','8000','10'),
(12,4,7,'2027-7-9','3200','4'),
(13,3,8,'2020-8-12','29700','33'),
(14,1,8,'2020-8-11','49500','55'),
(15,5,8,'2020-8-10','39600','44'),
(16,4,9,'2028-9-13','10000','10'),
(17,1,9,'2028-9-13','20000','20'),
(18,2,9,'2028-9-13','50000','50'),
(19,3,9,'2028-9-13','100000','100'),
(20,5,10,'2019-10-14','11000','10'),
(21,1,10,'2019-10-11','2200','2'),
(22,2,10,'2019-10-11','33000','33'),
(23,3,10,'2019-10-12','44000','44'),
(24,4,10,'2019-10-11','55000','55'),
(25,5,11,'2029-11-15','14400','12'),
(26,1,11,'2029-11-13','28800','24'),
(27,2,11,'2029-11-13','43200','36'),
(28,3,11,'2029-11-11','57600','48'),
(29,4,11,'2029-11-9','12000','10'),
(30,5,12,'2018-12-16','16900','13'),
(31,1,12,'2018-12-14','26000','20'),
(32,2,12,'2018-12-12','50700','20'),
(35,5,13,'2030-1-17','14000','10'),
(36,1,13,'2030-1-15','28000','20'),
(38,3,13,'2030-1-11','56000','40'),
(39,4,13,'2030-1-9','70000','50'),
(40,5,14,'2017-2-18','15000','10'),
(41,1,14,'2017-2-16','30000','20'),
(42,2,14,'2017-2-14','45000','30'),
(43,3,14,'2017-2-12','60000','40'),
(45,5,15,'2031-3-19','16000','10'),
(46,1,15,'2031-3-17','32000','20'),
(48,3,15,'2031-3-13','64000','40'),
(49,4,15,'2031-3-11','80000','50'),
(50,5,16,'2016-4-20','17000','10'),
(51,1,16,'2016-4-18','34000','20'),
(52,1,16,'2016-4-16','51000','30'),
(54,4,16,'2016-4-12','17000','10'),
(55,5,17,'2032-5-21','18000','10'),
(56,1,17,'2032-5-19','36000','20'),
(57,2,17,'2032-5-17','54000','30'),
(58,3,17,'2032-5-15','72000','40');