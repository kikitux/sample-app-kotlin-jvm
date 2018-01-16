#!/usr/bin/env bash

#array for endpoints
declare -a ep

ep[0]=http://localhost:8080/hello
ep[1]=http://localhost:8080/greeting
ep[2]=http://localhost:8080/greetingData
ep[3]=http://localhost:8080/dbname
ep[4]=http://localhost:8080/sysdate

for x in {1..999}; do
  curl -s "${ep[$RANDOM % (${#ep[@]}+1) ]}"
  sleep 0.00$(( $RANDOM % 99 ))
done
