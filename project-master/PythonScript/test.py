import json
import matplotlib.pyplot as plt
import matplotlib
def function(name):
    
    with open(name, 'r') as f:
        json_dict = json.load(f)
    a=[]
    b=[]
    print(a,json_dict)
    for entries in json_dict:
        a.append(entries['_source']['Valeur'])
        b.append(entries['_source']['TimeStamp'])
    print(a)
    print(b)
    plt.plot(b, a)
    plt.show()
    plt.savefig(name, dpi='figure', format="jpg")


function('luxs.json')

