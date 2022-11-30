echo $(curl -s -XPOST "http://localhost:9200/"$1"/_search" -H 'Content-Type: application/json' -d'  {
    "query": {
        "range" : {
            "'$2'" : {
                "gte" : '$3',
                "lte" : '$4'
            }
        }
    }
}') | jq '.hits' | jq '.hits' > "$5.json"
case $1 in 

"poules")
	echo $(jq -r 'map({ID,Poids,Nom}) | (first | keys_unsorted) as $keys | map([to_entries[] | .value]) as $rows | $keys,$rows[] | @csv' $4.json > $4.csv)
	break;;
	
"iopoules")
    echo $(jq -r 'map({ID,TimeStamp,Interval}) | (first | keys_unsorted) as $keys | map([to_entries[] | .value]) as $rows | $keys,$rows[] | @csv' $4.json > $4.csv)
	break;;
"humidite"|"nourrgen"|"nourbacglob"|"lumiere"|"temperature")
	echo $(jq -r 'map({ID,TimeStamp,Valeur}) | (first | keys_unsorted) as $keys | map([to_entries[] | .value]) as $rows | $keys,$rows[] | @csv' $4.json > $4.csv)
	break;;
esac

