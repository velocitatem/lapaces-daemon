#!/bin/bash
mkdir .lada
touch .lada/lada
echo "#!/bin/bash" > .lada/lada
echo "java -jar /usr/bin/.lada/lada.jar /usr/bin/.lada/creds.json" > .lada/lada
touch .lada/creds.json
curl -L https://github.com/danalves24com/lapaces-daemon/releases/download/LSv5.6/lade-shell-v6.jar -o ./.lada/lada.jar
cp -r ./.lada /usr/bin
cp -r /bin/.lada/lada /usr/bin/lada
chmod +x /usr/bin/lada
