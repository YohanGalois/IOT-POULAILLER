import json

import matplotlib.pyplot as plt

with open('nourbacgen.json', 'r') as f:
    json_dict = json.load(f)
    a = []
    b = []
    for entries in json_dict:
        a.append(entries['_source']['Valeur'])
        b.append(entries['_source']['TimeStamp'])
        a = [float(i) for i in a]
        b = [float(i) for i in b]
        a = sorted(a)
        b = sorted(b)
Total = [row for row in a]
dernieres_sem = Total[-(24 * 7):]
dernier_mois = Total[-(24 * 30):]
dernier_an = Total[-(24 * 365):]
dernieres_X_sem = b[-(24 * 7):]
dernier_X_mois = b[-(24 * 30):]
dernier_X_an = b[-(24 * 365):]
plt.plot(b, Total)
plt.savefig("graphs/NourG_total.png")
plt.plot(dernieres_X_sem, dernieres_sem)
plt.savefig("graphs/NourG_sem.png")
plt.plot(dernier_X_mois, dernier_mois)
plt.savefig("graphs/NourG_mois.png")
plt.plot(dernier_X_an, dernier_an)
plt.savefig("graphs/NourG_an.png")
