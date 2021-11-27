# LADA Shell 🐚
LADA Shell is an interactive cli, used to access modules integrated in the LADA api.

## Install ⬇️

### Linux 🐧 and Mac 💻
Prerequisites `jre-openjdk` `nodejs`

1. `curl -L https://raw.githubusercontent.com/danalves24com/lapaces-daemon/main/source/LADA-shell/.install_lada.sh -o .install_lada.sh`
3. `sudo bash .install_lada.sh`
4. `lada` and you should be put into the LADA 🐚 which should look like the following:

```
lada>
```
### Windows


## Using LADA shell
To get started with using commands in the shell, run `help` or simply `-h`. If the command you enter is recognized by LADA, it will execute in its own environment, however if you were to type `lsblk`, you would get the system output of that command. Need more help? Check out [outputs](./outputs.md)
## Understanding modules 👾
To display all currently integrated modules, type `show all` into the prompt, and you will get an output similar to the following:
```
+ computing
 	+ cryptography
 	 	- [0]  hashing :: [type, body]
 	+ sorting
 	 	- [0]  insertion :: [array]
 	 	- [1]  bubble :: [array]
	 	- [2]  selection :: [array]
 	 	- [3]  merge :: [array]
+ system
 	+ network
 	 	- [0]  port-scan :: [ip]
 	 	- [1]  device-probe :: [ip]
 	 	- [2]  scan-network :: [T]	(scan duration proportional to 22600*T (ms))
 	 	- [3]  ping :: [ip]
 	 	- [4]  lan-ip :: []
 	 	- [5]  public-ip :: []
 	 	- [6]  private-ip :: []
 	 	- [7]  url-ip :: [url]
```
You must use modules in their full depth.

✖️ `use system`

✖️ `use network`

✔️ `use system/network`

### Syntax for execution ▶️
There are 2 ways you can run a module, a single-line or a more interactive multi-line approach.
To get the LAN IP of your device you can do one of the following:
1. signle-line
``` 
lada> run system/network 4


	using module: system==>network


	Module:		network


	Function:	4


	Variables:	[]


	Output: [10.0.1.106, 10.0.1.103]

```

2. multi-line

```
lada> use system/network

	using module: system==>network

lada> functions

	Functions contained in current module

	 [0]	port-scan :: [ip]
	 [1]	device-probe :: [ip]
	 [2]	scan-network :: [T]
	 [3]	ping :: [ip]
	 [4]	lan-ip :: []
	 [5]	public-ip :: []
	 [6]	private-ip :: []
	 [7]	url-ip :: [url]

lada> set function 4
lada> run

	Output: [10.0.1.106, 10.0.1.103]

    
```
### Help ❓
You can get the following by running `help` or `-h`. If you are still having issues, makes an issue 🥁.
```
Commands:
	
	use/load [module]
		The 'use' command can be used to load a module from the module tree, to further use
	
	functions/list
		Displays all functions contained in loaded module

	show [module/all]
		all: 	Lists all modules and their submodules
		module: Lists submodules in a parent module
		tell:	Shows all data modules which you can query
	
	set [var/function] [val]
		var: 		Sets the variable named var to be val
		function:	Loads a function number val from the current module
		
	run
		Executes the currently loaded function with the variables which were set
		
	run [module] [function #] [parameters]
		Executes a function in module with parameters
	
	report
		Prints a report on the following:
			- current module
			- current function
			- array of variables
	
	tell [function] [parameters]
		reports data based on given function and parameters. PRAMETERS ARE NON-DELARATIONAL! meaning that 'tell function a b' NOT 'tell function a=a b=b'		
 	
	SYSTEM
		if a command does not match any of the above defined, LADE will treat the input as a system command
```
