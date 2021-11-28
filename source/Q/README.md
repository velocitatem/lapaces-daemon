# ladaQ 🪄
ladaQ is a library, but primarily used in [LADAshell](../LADA-shell).
## Setup 🧰

## LADAshell Usage 🐚
The command to invoke ladaQ is `tell`. To see what Q can tell you, run: 
```show tell```
which should give you an output similar to the following:
```
	+ cameras
		-  cameras :: [location]
	+ opensky 
		-  all-aircraft :: []
		-  arrivals :: [airport, days-back, days-forward]
		-  find-airport :: [query]
	+ finance
		-  forex :: [source, target]
	+ nasa
		-  satimg :: [lat, lon, y-m-d, ratio]
	+ world-bank
		-  country :: [query]
		-  indicator :: [indicator, country, start-year]
		-  find-indicator :: [query]
```
### Syntax
As seen in the output above, there are module and functions, but to run a function you dont need the module name, you can start by simply `tell [function]`. 
#### PARAMATERS ARE SIMPLE!
✖️ `tell country query Spain`

✖️ `tell Spain`

✔️ `tell country Spain`

## Examples
### Want an exhange rate from JPY to GBP? 💹
```
lada> tell forex JPY GBP
```
