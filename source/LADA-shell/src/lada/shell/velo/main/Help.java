package lada.shell.velo.main;

public class Help {
	public static String getHelp() {
		return "\n" + 
				"Commands:\n" + 
				"	\n" + 
				"	use/load [module]\n" + 
				"		The 'use' command can be used to load a module from the module tree, to further use\n" + 
				"	\n" + 
				"	functions/list\n" + 
				"		Displays all functions contained in loaded module\n" + 
				"\n" + 
				"	show [module/all]\n" + 
				"		all: 	Lists all modules and their submodules\n" + 
				"		module: Lists submodules in a parent module\n" + 
				"	\n" + 
				"	set [var/function] [val]\n" + 
				"		var: 		Sets the variable named var to be val\n" + 
				"		function:	Loads a function number val from the current module\n" + 
				"		\n" + 
				"	run\n" + 
				"		Executes the currently loaded function with the variables which were set\n" + 
				"		\n" + 
				"	run [module] [function #] [parameters]\n" + 
				"		Executes a function in module with parameters\n" + 
				"	\n" + 
				"	report\n" + 
				"		Prints a report on the following:\n" + 
				"			- current module\n" + 
				"			- current function\n" + 
				"			- array of variables\n" + 
				"	\n" + 
				"	SYSTEM\n" + 
				"		if a command does not match any of the above defined, LADE will treat the input as a system command";				
	}
}
