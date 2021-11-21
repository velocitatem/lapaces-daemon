package lada.shell.velo.main;

public class Modules {
	public static Module[] modules = { 
			new Module("physics", new Module[] {
					new Module("kinematics", new Function[] { 
							ModuleFunctions.averageSpeed(), 
							ModuleFunctions.deltaT() 
					}),
					new Module("vectors", new Function[] {
							ModuleFunctions.complexVectorMagnitude(),
							ModuleFunctions.complexVectorThetaDegrees(),
							ModuleFunctions.complexVectorfromParams()
					})
			}), 
			new Module("math", new Module[] { 
					new Module("calculus", new Function[] { 
						ModuleFunctions.limit(),
						ModuleFunctions.numericalDifferentiation(), 
						ModuleFunctions.tangentLine() 
					}),
					new Module("operations", new Function[] {
						ModuleFunctions.sysLin(),
						ModuleFunctions.factorial()
					}),
					new Module("stats", new Function[] {
						ModuleFunctions.LSRL(),
						ModuleFunctions.OVS()
					})
			}),
			new Module("astronomy", new Module[] {
					new Module("navigation", new Function[] {
						ModuleFunctions.julianDay(),
						ModuleFunctions.julianDay1()
							
					})
			}),
			new Module("computing", new Module[] {
					new Module("cryptography", new Function[] {
						ModuleFunctions.hashFunctions() 	
					}),
					new Module("sorting", ModuleFunctions.sort())
			}),
			new Module("system", new Module[] {
					new Module("network", new Function[] {
						ModuleFunctions.portScan(),
						ModuleFunctions.deviceProbe(),
						ModuleFunctions.scanNetwork(),
						ModuleFunctions.ping(),
						ModuleFunctions.getLanIP(),
						ModuleFunctions.getPublicIP(),
						ModuleFunctions.getPrivateIP(),
						ModuleFunctions.urlIP()
					})
			})
			

	};
}
