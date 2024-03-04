# Napisti funkciju write_text_to_file() koja od teksta unetog sa tastature upisuje u datoteku text.txt. 
# Zatim, napraviti wrapper funkciju koja proširuje funkcionalnost originalne funkcije 
# tako što upisuje tekst sve malim slovima.

def write_all_small_letters(func):
    def wrapper(n):
        return func(n.lower())
    return wrapper

@write_all_small_letters
def write_text_to_file(text):
    with open("tekst.txt", "w") as file:
        file.write(text)

write_text_to_file(input("Unesite tekst: "))