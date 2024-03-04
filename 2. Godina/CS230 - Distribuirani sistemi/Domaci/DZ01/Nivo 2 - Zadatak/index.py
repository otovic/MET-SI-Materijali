# Nivo 2: Napraviti novo virtuelno okruženje u Python-u pod nazivom venv. Instalirati paket flask. 
# Napraviti Flask aplikaciju sa rutama za stranicu "static", 
# koja se nalazi u funkciji prva_strana u kojoj treba ukucati zadat HTML kod.

from flask import Flask, render_template

app = Flask(__name__, template_folder='content')

@app.route('/')
def prva_strana():
    return render_template('static.html')

app.run()