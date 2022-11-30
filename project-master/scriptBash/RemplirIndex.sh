#!/bin/bash
# exemple ./$0 "iopoules" "10" "198.58" "-14"

echo $1 $2 $3 $4;
types=$1;
echo $types;
va1='"'$2'"';
va2='"'$3'"';
va3='"'$4'"';
echo $va1;
case $1 in 
"poules")
	echo $(curl -s -XPOST "http://localhost:9200/"$types"/_doc" -H 'Content-Type: application/json' -d'
    	{
       		"ID":'$va1',
       		"Poids":'$va2',
       		"Nom":'$va3'
    	}');
	break;;
"iopoules")
   
	echo $(curl -s -XPOST "http://localhost:9200/"$types"/_doc" -H 'Content-Type: application/json' -d'
    	{
       		"ID":'$va1',
       		"TimeStamp":'$va2',
       		"Interval":'$va3'
    	}');
	break;;
"humidite"|"nourrgen"|"nourbacglob"|"lumiere"|"temperature")
	echo $(curl -s -XPOST "http://localhost:9200/"$types"/_doc" -H 'Content-Type: application/json' -d'
    	{
       		"ID":'$va1',
       		"TimeStamp":'$va2',
       		"Valeur":'$va3'
    	}')
	break;;
esac





