#!/bin/bash

echo $(curl -s -X PUT "http://localhost:9200/"$1 -H 'Content-Type: application/json' -d'
    {
        "settings" : {
            "index" : {
                "number_of_shards" : 5,
                "number_of_replicas" : 0
            }
        }
    }');

echo "HelloWorld";