class OdevniPredmet {
    #stanje = 'skinuto'
    #velicina = 'S'
    #brend = ''

    constructor(stanje, velicina, brend) {
        this.stanje = stanje
    }

    static racunajCenu() {
        throw new console.error("Ovo je apstraktna metoda i ne moze da se pozove!");
    }

    get getStanje() {
        return this.stanje
    }

    get getVelicina() {
        return this.velicina
    }

    get getBrend() {
        return this.brend
    }

    set setStanje(stanje) {
        this.stanje = stanje
    }

    set setVelicina(velicina) {
        this.velicina = velicina
    }

    set setBrend(brend) {
        this.brend = brend
    }
}

class Odelo extends OdevniPredmet {
    #vrsta = ''

    constructor(vrsta, stanje, velicina, brend) {
        super(stanje, velicina, brend)
        this.vrsta = vrsta
    }

    get getVrsta() {
        return this.vrsta
    }

    set setVrsta(vrsta) {
        this.vrsta = vrsta
    }

    static racunajCenu() {
        let cena = Math.random() * (10000 - 5000) + 5000
    }
}

class Majica extends OdevniPredmet {
    #tip = ''

    Majica(tip) {
        this.tip = tip
    }

    get getTip() {
        return this.tip
    }

    set setTip(tip) {
        this.tip = tip
    }

    static racunajCenu() {
        let cena = Math.random() * (3000 - 500) + 500
    }
}

const proizvodi = new Map()
let id = 0

function generisiOdelo() {
    let stanje = document.getElementById('odelostanje').value
    let velicina = document.getElementById('odelovelicina').value
    let brend = document.getElementById('odelobrend').value
    let vrsta = document.getElementById('odelovrsta').value

    if(stanje == '') {
        alert('Popunite sva polja!')
        return
    }
    if(velicina == '') {
        alert('Popunite sva polja!')
        return
    }
    if(brend == '') {
        alert('Popunite sva polja!')
        return
    }
    if(vrsta == '') {
        alert('Popunite sva polja!')
        return  
    }

    if(!['obuceno', 'skinuto'].includes(stanje.toLowerCase())) {
        alert("Stanje moze biti samo obuceno ili skinuto!")
        return
    }

    if(!['s', 'm', 'l', 'xl', 'xxl', 'xxxl'].includes(velicina.toLowerCase())) {
        alert("Unesite ispravnu velicinu! (s, m, l, xl, xxl, xxxl)")
        return
    }

    let odelo = new Odelo(vrsta, stanje, velicina, brend)

    proizvodi.set(++id, odelo)

    let html = document.getElementById('odelores')

    console.log(proizvodi)

    html.innerHTML = html.innerHTML + 
    "<div class='odelo'><b>ODELO</b><p>Stanje: {stanje}</p><p>Velicina: {velicina}</p><p>Brend: {brend}</p><p>Vrsta: {vrsta}</p></div>"
    .replace("{stanje}", stanje)
    .replace("{velicina}", velicina)
    .replace("{brend}", brend)
    .replace("{vrsta}", vrsta)
}

function generisiMajicu() {
    let stanje = document.getElementById('majicastanje').value
    let velicina = document.getElementById('majicavelicina').value
    let brend = document.getElementById('majicabrend').value
    let tip = document.getElementById('majicatip').value

    if(stanje == '') {
        alert('Popunite sva polja!')
        return
    }
    if(velicina == '') {
        alert('Popunite sva polja!')
        return
    }
    if(brend == '') {
        alert('Popunite sva polja!')
        return
    }
    if(tip == '') {
        alert('Popunite sva polja!')
        return  
    }

    if(!['obuceno', 'skinuto'].includes(stanje.toLowerCase())) {
        alert("Stanje moze biti samo obuceno ili skinuto!")
        return
    }

    if(!['s', 'm', 'l', 'xl', 'xxl', 'xxxl'].includes(velicina.toLowerCase())) {
        alert("Unesite ispravnu velicinu! (s, m, l, xl, xxl, xxxl)")
        return
    }

    let odelo = new Majica(tip, stanje, velicina, brend)

    proizvodi.set(++id, odelo)

    let html = document.getElementById('majicares')

    console.log(proizvodi)

    html.innerHTML = html.innerHTML + 
    "<div class='odelo'><b>MAJICA</b><p>Stanje: {stanje}</p><p>Velicina: {velicina}</p><p>Brend: {brend}</p><p>Vrsta: {vrsta}</p></div>"
    .replace("{stanje}", stanje)
    .replace("{velicina}", velicina)
    .replace("{brend}", brend)
    .replace("{vrsta}", tip)
}