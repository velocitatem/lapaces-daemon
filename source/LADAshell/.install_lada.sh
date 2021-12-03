#!/bin/bash
mkdir .lada
touch .lada/lada
echo "#!/bin/bash" > .lada/lada
echo "java -jar /usr/bin/.lada/lada.jar /usr/bin/.lada/creds.json" > .lada/lada
touch .lada/creds.json
curl -L https://github.com/danalves24com/lapaces-daemon/releases/download/v7/lada-shell-v7.jar -o ./.lada/lada.jar
cp -r ./.lada /usr/bin
cp -r /usr/bin/.lada/lada /usr/bin/lada
chmod +x /usr/bin/lada
