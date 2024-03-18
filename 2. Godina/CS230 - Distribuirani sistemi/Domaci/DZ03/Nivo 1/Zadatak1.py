# Napisati program koji predstavlja interceptor za logovanje koristeći dekorator koji beleži ulazak i izlazak 
# iz bilo koje funkcije koju dekoriše. Log treba da uključuje ime funkcije, prosleđene argumente i povratnu vrednost.

def log_decorator(func):
    def wrapper(*args, **kwargs):
        print(f"Pocetak funkcije {func.__name__}, prosledjeni argumenti: {args}, {kwargs}")
        
        result = func(*args, **kwargs)
        
        print(f"Kraj funkcije {func.__name__}, povratna vrednost: {result}")
        
        return result
    
    return wrapper

@log_decorator
def pokemon(a, b):
    return a + b

pokemon(2, 3)