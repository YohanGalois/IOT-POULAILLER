import Lum_Hum_Temp
import NourB
import Nour_Globale
import xlsxwriter
import statistics
import json

workbook = xlsxwriter.Workbook('Stats.xlsx')

worksheet = workbook.add_worksheet()

worksheet.write('A1', 'moyenne temperature')
worksheet.write('B1', str(statistics.mean(Lum_Hum_Temp.temperature))+"°C")

worksheet.write('A3', 'minimum gamelle Globale')
worksheet.write('B3', str(min(Nour_Globale.a))+"g")

worksheet.write('A5', 'Mediane gamelle bac')
worksheet.write('B5', str(statistics.median(NourB.a))+"g")

with open('poules.json', 'r') as f:
    json_dict = json.load(f)
    a = []
    b = []
    for entries in json_dict:
        a.append(entries['_source']['Poids'])
        a = [float(i) for i in a]
        a = sorted(a)

worksheet.write('A7', 'Moyenne poids poules')
worksheet.write('B7', str(statistics.mean(a))+"kg")

workbook.close()
