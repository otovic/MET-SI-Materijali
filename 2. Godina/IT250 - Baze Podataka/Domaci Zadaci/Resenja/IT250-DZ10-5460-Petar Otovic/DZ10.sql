SELECT indeks, ime, prezime, tip_studiranja 
FROM student 
INNER JOIN smer ON smer.smer_id = student.smer_id
WHERE smer.smer_naziv = 'Softversko inzenjerstvo' 

SELECT * FROM student
INNER JOIN overa ON student.indeks = overa.indeks
WHERE overa.ocena = 5

SELECT * FROM profesor
INNER JOIN angazovanje on profesor.profesor_id = angazovanje.profesor_id
WHERE angazovanje.predmet_id = 'MA101'