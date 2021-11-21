#!/bin/bash

curl -L https://github.com/danalves24com/lapaces-daemon/releases/download/LSv5.0.01/lade-shell-v5.jar -o ./.lada/lada.jar
cp -r ./.lada /bin
cp -r /bin/.lada/lada /bin/lada
chmod +x /bin/lada
