# Napisati program koji predstavlja jednostavan preuzimač datoteka koji paralelno 
# preuzima više fajlova sa različitih URL-ova koristeći višenitni rad (multithreading). 
# Svaka nit (thread) treba da obradi preuzimanje jedne datoteke.

#pip isntall wget - za wget paket

import threading
import wget

def daunloud_file(url, file_nejm):
    try:
        print(f"Preuzimanje fajla: {file_nejm} sa {url}... \n")
        wget.download(url)
        print(f" Skinut fajl: {file_nejm}")
    except Exception as e:
        print(f"Greska prilikom preuzimanja fajla sa {url}: {e}")

urlovi = [
    "https://www.eparhija-sumadijska.org.rs/download/Juni2019/5_Pravoslavna_vera_Katihizis.pdf",
    "https://www.eparhija-sumadijska.org.rs/download/Juni2019/5_Pravoslavna_vera_Katihizis.pdf",
    "https://www.eparhija-sumadijska.org.rs/download/Juni2019/5_Pravoslavna_vera_Katihizis.pdf"
]

niti = []
for i, url in enumerate(urlovi):
    file_nejm = f"file{i+1}.txt"
    nit = threading.Thread(target=daunloud_file, args=(url, file_nejm))
    nit.start()
    niti.append(nit)

for nit in niti:
    nit.join()

print("Sva preuzimanja su završena.")