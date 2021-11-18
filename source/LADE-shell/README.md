# LADE Shell
LADE Shell is an interactive cli, used to access modules integrated in the LADE api.

## Install
Download the lade-shell installation script and .jar from [here](). Run the installation script:

```
bash .lade-installation
```

Once the sript is done, you can run lade with `lade`. Once you are in the terminal, it should look like the following:

```
lade>
```

### Using LADE shell
To get started with using commands in the shell, run `help` or simply `-h`. If the command you enter is recognized by LADE, it will execute in its own environment, however if you were to type `lsblk`, you would get the system output of that command.
#### Syntax for execution
There are 2 ways you can run a module, a single-line or a more interactive multi-line approach.
To get the LAN IP of your device you can do one of the following:
1. signle-line

``` 
lade> run system/network 4


	using module: system==>network


	Module:		network


	Function:	4


	Variables:	[]


	Output: [10.0.1.106, 10.0.1.103]

```


2. multi-line

```
lade> use system/network

	using module: system==>network

lade> functions

	Functions contained in current module

	 [0]	port-scan :: [ip]
	 [1]	device-probe :: [ip]
	 [2]	scan-network :: [T]
	 [3]	ping :: [ip]
	 [4]	lan-ip :: []
	 [5]	public-ip :: []
	 [6]	private-ip :: []
	 [7]	url-ip :: [url]

lade> set function 4
lade> run

	Output: [10.0.1.106, 10.0.1.103]

    
```

#### Examples
+ Hashing 
