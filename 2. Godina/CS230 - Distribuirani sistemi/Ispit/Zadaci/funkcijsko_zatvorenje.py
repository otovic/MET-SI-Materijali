#verovatno ne

def spoljasnja_funkcija(x):
    def unutrasnja_funkcija(y):
        return x + y
    return unutrasnja_funkcija

prolaz = spoljasnja_funkcija(10)
print(prolaz(20))