from flask import Flask, request, jsonify

app = Flask(__name__)

predmeti = [
    {
        'id': 1,
        'predmet': 'Svet Oko Nas',
        'sifra': 'SON220'
    },
]

@app.route('/predmeti/<id>', methods=['GET', 'POST', 'PUT', 'DELETE'])
def predmeti_base(id=None):
    try:
        if id == None or id == '' or str(id).isnumeric() == False:
            return 'Invalid ID'
        
        if request.method == 'GET':
            return jsonify(predmeti[int(id) - 1])
        
        if request.method == 'PUT':
            data = request.args.to_dict()
            changed = False
            
            for predmet in predmeti:
                if predmet['id'] == int(id):
                    if 'predmet' in data:
                        predmet['predmet'] = data['predmet']
                        changed = True

                    if 'sifra' in data:
                        predmet['sifra'] = data['sifra']
                        changed = True

            return changed and 'Predmet je uspesno izmenjen' or 'Nema izmena'
        
        if request.method == 'DELETE':
            for predmet in predmeti:
                if predmet == None:
                    continue
                if predmet['id'] == int(id):
                    predmeti.remove(predmet)
                    return 'Predmet je uspesno obrisan'

            return 'Ne postoji predmet sa tim ID-jem'
        
        return 'Zahtev je neispravan'
    
    except IndexError:
        return 'Neispravan ID'

@app.route('/predmeti', methods=['GET', 'POST'])
def predmeti_id(id=None):
    try:
        if request.method == 'GET':
            return jsonify(predmeti)
        
        if request.method == 'POST':
            data = request.args.to_dict()

            if 'predmet' not in data or 'sifra' not in data:
                return 'Predmet nije dodat, nedostaju podaci'
            
            for predmet in predmeti:
                if predmet == None:
                    continue
                if predmet['sifra'] == data['sifra']:
                    return 'Sifra vec postoji'
            
            predmeti.append({
                'id': len(predmeti) + 1,
                'predmet': data['predmet'],
                'sifra': data['sifra']
            })

            return 'Predmet je uspesno dodat'
        
        return 'Zahtev je neispravan'
        
    except Exception as e:
        return 'Greska: ' + str(e)