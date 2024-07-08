def interceptor(func):
    def wrapper(*args, **kwargs):
        print(f"Pocetak wrapper funkcije sa imenom {func.__name__} i argumentima {args} i {kwargs}")

        result = func(*args, *kwargs)

        print(f"Rezultat posle unutrasnje funkcije {result}")

        return result
    return wrapper

@interceptor
def test_funkcija(a, b):
    return a + b

test_funkcija(5, 6)