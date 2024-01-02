SELECT * from profesor
INNER JOIN angazovanje ON profesor.profesor_id = angazovanje.angazovanje_id
GROUP BY angazovanje.profesor_id
HAVING COUNT(angazovanje.profesor_id) > 1