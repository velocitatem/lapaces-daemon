# ladaQ 🪄
ladaQ is a library, but primarily used in [LADAshell](../LADA-shell).
## Setup 🧰
ladaQ relies on the following services for which you will need to get a **FREE** API key:
- [Opensky](https://opensky-network.org/login?view=registration)
- [NASA](https://api.nasa.gov)
- [AlphaVantage](https://www.alphavantage.co/support/#api-key)

Given you hava LADAshell installed, open the credentials file with your favorite editor
```vim /usr/bin/.lada/creds.json```
and enter your credentials in the following format:
```
{
    "opensky": "USERNAME:PASSWORD",
    "nasa": "GM7O.............4fqti4",
    "alphavantage": "20.........5R5"
}
```
now if you run `lada` you should not get any errors when using tell.
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
