#Nivo 3 - Istražiti pojam funkcijskog zatvorenja – dati primer u Python jeziku i nekom drugom programskom jeziku. Navesti izvor.

# Funkcijsko Zatvorenje je koncept u Python-u koji se koristi kako bi funckija zadrzala vrednost neke promenljive za dalje koriscenje cak i
# kada se izvrsenje te funkcije zavrsilo.
# IZVOR: https://www.programiz.com/python-programming/closure

def spoljasnja_funkcija(x):
    def unutrasnja_funkcija(y):
        return x * y
    return unutrasnja_funkcija

prolaz = spoljasnja_funkcija(10)
print(prolaz(5))