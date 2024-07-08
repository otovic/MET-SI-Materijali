#prvo se poziva prva funckija koja prima drugu funkciju kao argument
#prosledjeni tekst se pretvara u mala slova i upisuje u datoteku

def prva_funkcija(func):
    def wrapper(text):
        return func(text.lower())
    return wrapper

@prva_funkcija
def druga_funckija(text):
    with open("wrapper_funkcija.txt", "w") as fw:
        fw.write(text)

druga_funckija("Ovo je tekst koji ce biti upisan u datoteku")