import matplotlib.pyplot as plt
import json


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
dernieres_24h = Total[-24:]
dernier_mois = Total[-(24 * 30):]
dernier_an = Total[-(24 * 365):]
dernieres_X_24h = b[-24:]
dernier_X_mois = b[-(24 * 30):]
dernier_X_an = b[-(24 * 365):]

plt.plot(b, Total)
plt.savefig("graphs/NourB_total.png")
plt.plot(dernieres_X_24h, dernieres_24h)
plt.savefig("graphs/NourB_24h.png")
plt.plot(dernier_X_mois, dernier_mois)
plt.savefig("graphs/NourB_mois.png")
plt.plot(dernier_X_an, dernier_an)
plt.savefig("graphs/NourB_an.png")
