#!/bin/bash
mkdir .lada
touch .lada/lada
echo "#!/bin/bash" > .lada/lada
echo "java -jar /bin/.lada/lada.jar" > .lada/lada
curl -L https://github.com/danalves24com/lapaces-daemon/releases/download/LSv5.0.01/lade-shell-v5.jar -o ./.lada/lada.jar
cp -r ./.lada /usr/bin
cp -r /bin/.lada/lada /usr/bin/lada
chmod +x /usr/bin/lada
