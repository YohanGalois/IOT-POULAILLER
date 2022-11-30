#!/bin/bash

echo $(curl -s -X DELETE "http://localhost:9200/"$1) 

