echo $(curl -s -XPOST "http://localhost:9200/"$1"/_search?scroll="$3"m" -H 'Content-Type: application/json' -d' { "size": '$2', "query": { "match_all": {} } }') | jq '.hits' | jq '.hits' > "$4.json"


