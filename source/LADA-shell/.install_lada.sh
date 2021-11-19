#!/bin/bash

curl -L https://github.com/danalves24com/lapaces-daemon/releases/download/v4.0.0/lade-shell-v4.jar -o ./.lada/lada.jar
cp -r ./.lada /bin
cp -r /bin/.lada/lada /bin/lada
chmod +x /bin/lada
