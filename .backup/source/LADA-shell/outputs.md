# Usage
To better undedrstand a module and how it should be used, just press `CTRL + F` and search for the module name and function number like this `system/network 1` and you will get the sample output.

# `run physics/kinematics 0 distance=2 time=4`
```

	using module: physics==>kinematics


	set distance ( class java.lang.Double )  = 2.0


	set time ( class java.lang.Double )  = 4.0


	Module:		kinematics


	function:	0


	Variables:	[2.0, 4.0]


	Output: 0.5

```
# `run physics/kinematics 1 v0=2 v=3 t=3`
```

	using module: physics==>kinematics


	set v0 ( class java.lang.Double )  = 2.0


	set v ( class java.lang.Double )  = 3.0


	set t ( class java.lang.Double )  = 3.0


	Module:		kinematics


	function:	1


	Variables:	[2.0, 3.0, 3.0]


	Output: 7.5

```
# `run physics/vectors 0 ax=1 ay=1`
```

	using module: physics==>vectors


	set ax ( class java.lang.Double )  = 1.0


	set ay ( class java.lang.Double )  = 1.0


	Module:		vectors


	function:	0


	Variables:	[1.0, 1.0]


	Output: 1.4142135623730951

```
# `run physics/vectors 1 ax=1 ay=1`
```

	using module: physics==>vectors


	set ax ( class java.lang.Double )  = 1.0


	set ay ( class java.lang.Double )  = 1.0


	Module:		vectors


	function:	1


	Variables:	[1.0, 1.0]


	Output: 45.0

```
# `run physics/vectors 2 theta=1.52 magnitude=1`
```

	using module: physics==>vectors


	set theta ( class java.lang.Double )  = 1.52


	set magnitude ( class java.lang.Double )  = 1.0


	Module:		vectors


	function:	2


	Variables:	[1.52, 1.0]


	Output: 0.05077448493357918i + 0.998710143975583j

```
# `run math/calculus 0 equation=x*2 x=2`
```

	using module: math==>calculus


	set equation ( class java.lang.String )  = x*2


	set x ( class java.lang.Double )  = 2.0


	Module:		calculus


	function:	0


	Variables:	[x*2, 2.0]


	Output: 4.0

```
# `run math/calculus 2 equation=x*2 a=2 b=4 n=9000`
```

	using module: math==>calculus


	set equation ( class java.lang.String )  = x*2


	set a ( class java.lang.Double )  = 2.0


	set b ( class java.lang.Double )  = 4.0


	set n ( class java.lang.Double )  = 9000.0


	Module:		calculus


	function:	2


	Variables:	[x*2, 2.0, 4.0, 9000.0]


	Output: 12.00074074074074

```
# `run math/calculus 1 equation=Math.pow(2,x) x=2 order=1`
```

	using module: math==>calculus


	set equation ( class java.lang.String )  = Math.pow(2,x)


	set x ( class java.lang.Double )  = 2.0


	set order ( class java.lang.Double )  = 1.0


	Module:		calculus


	function:	1


	Variables:	[Math.pow(2,x), 2.0, 1.0]


	Output: 2.7725887230545254

```
# `run math/calculus 3 equation=Math.pow(2,x) x=3`
```

	using module: math==>calculus


	set equation ( class java.lang.String )  = Math.pow(2,x)


	set x ( class java.lang.Double )  = 3.0


	Module:		calculus


	function:	3


	Variables:	[Math.pow(2,x), 3.0]


	Output: y = 5.545177437227267x + (-8.6355323116818)

```
# `run math/operations 0 m1=2 b1=2 m2=-2 b2=2`
```

	using module: math==>operations


	set m1 ( class java.lang.Double )  = 2.0


	set b1 ( class java.lang.Double )  = 2.0


	set m2 ( class java.lang.Double )  = -2.0


	set b2 ( class java.lang.Double )  = 2.0


	Module:		operations


	function:	0


	Variables:	[2.0, 2.0, -2.0, 2.0]


	Output: [0.0, 2.0]

```
# `run math/operations 1 a=4`
```

	using module: math==>operations


	set a ( class java.lang.Double )  = 4.0


	Module:		operations


	function:	1


	Variables:	[4.0]


	Output: 24.0

```
# `run math/stats 0 x=arr[0,1,2,3] y=arr[1,2,3,4]`
```

	using module: math==>stats


	set x ( class [Ljava.lang.String; )  = [Ljava.lang.String;@665df3c6


	set y ( class [Ljava.lang.String; )  = [Ljava.lang.String;@68b6f0d6


	Module:		stats


	function:	0


	Variables:	[[Ljava.lang.String;@665df3c6, [Ljava.lang.String;@68b6f0d6]


	Output: y = 1.0x + (1.0)

```
# `run math/stats 1 array=arr[2,6,168,581,6,2,7,9,2,6,428]`
```

	using module: math==>stats


	set array ( class [Ljava.lang.String; )  = [Ljava.lang.String;@36f48b4


	Module:		stats


	function:	1


	Variables:	[[Ljava.lang.String;@36f48b4]


	Output: OneVarStats [xBar=110.63636363636364, sumX=1217.0, sumX2=549219.0, SD=203.61103738612636, n=11.0, minX=2.0, q1=2.0, med=6.0, q3=168.0, maxX=581.0, iqr=166.0, arr=[2.0, 2.0, 2.0, 6.0, 6.0, 6.0, 7.0, 9.0, 168.0, 428.0, 581.0]]

```
# `run math/stats 2 x=5 mu=4.5 sigma=0.05`
```

	using module: math==>stats


	set x ( class java.lang.Double )  = 5.0


	set mu ( class java.lang.Double )  = 4.5


	set sigma ( class java.lang.Double )  = 0.05


	Module:		stats


	function:	2


	Variables:	[5.0, 4.5, 0.05]


	Output: 10.0

```
# `run math/stats 3 z-score=1.5 direction=1`
```

	using module: math==>stats


	set z-score ( class java.lang.Double )  = 1.5


	set direction ( class java.lang.Double )  = 1.0


	Module:		stats


	function:	3


	Variables:	[1.5, 1.0]


	Output: 0.932944556673667

```
# `run math/stats 4 trials=400 prob=0.5`
```

	using module: math==>stats


	set trials ( class java.lang.Double )  = 400.0


	set prob ( class java.lang.Double )  = 0.5


	Module:		stats


	function:	4


	Variables:	[400.0, 0.5]


	Output: 0.5

```
# `run astronomy/navigation 0`
```

	using module: astronomy==>navigation


	Module:		navigation


	function:	0


	Variables:	[]


	Output: 2459551.316108634

```
# `run astronomy/navigation 1 year=2021 month=6 day=15 hour=12 minute=30 second=30 millis=5`
```

	using module: astronomy==>navigation


	set year ( class java.lang.Double )  = 2021.0


	set month ( class java.lang.Double )  = 6.0


	set day ( class java.lang.Double )  = 15.0


	set hour ( class java.lang.Double )  = 12.0


	set minute ( class java.lang.Double )  = 30.0


	set second ( class java.lang.Double )  = 30.0


	set millis ( class java.lang.Double )  = 5.0


	Module:		navigation


	function:	1


	Variables:	[2021.0, 6.0, 15.0, 12.0, 30.0, 30.0, 5.0]


	Output: 2459381.0211806134

```
# `run computing/cryptography 0 type=md2 body=hello`
```

	using module: computing==>cryptography


	set type ( class java.lang.String )  = md2


	set body ( class java.lang.String )  = hello


	Module:		cryptography


	function:	0


	Variables:	[md2, hello]


	Output: a9046c73e00331af68917d3804f70655

```
# `run computing/sorting 0 array=arr[-0.5,-2,3,-40]`
```

	using module: computing==>sorting


	set array ( class [Ljava.lang.String; )  = [Ljava.lang.String;@60a2630a


	Module:		sorting


	function:	0


	Variables:	[[Ljava.lang.String;@60a2630a]


	Output: [-40.0, -2.0, -0.5, 3.0]

```
# `run computing/sorting 1 array=arr[-0.5,-2,3,-40]`
```

	using module: computing==>sorting


	set array ( class [Ljava.lang.String; )  = [Ljava.lang.String;@29df4d43


	Module:		sorting


	function:	1


	Variables:	[[Ljava.lang.String;@29df4d43]


	Output: [-40.0, -2.0, -0.5, 3.0]

```
# `run computing/sorting 2 array=arr[-0.5,-2,3,-40]`
```

	using module: computing==>sorting


	set array ( class [Ljava.lang.String; )  = [Ljava.lang.String;@5dd91bca


	Module:		sorting


	function:	2


	Variables:	[[Ljava.lang.String;@5dd91bca]


	Output: [-40.0, -2.0, -0.5, 3.0]

```
# `run computing/sorting 3 array=arr[-0.5,-2,3,-40]`
```

	using module: computing==>sorting


	set array ( class [Ljava.lang.String; )  = [Ljava.lang.String;@40cb698e


	Module:		sorting


	function:	3


	Variables:	[[Ljava.lang.String;@40cb698e]


	Output: [-40.0, -2.0, -0.5, 3.0]

```
# `run linguistics/conversion 0 code=I3O2G5N`
```

	using module: linguistics==>conversion


	set code ( class java.lang.String )  = I3O2G5N


	Module:		conversion


	function:	0


	Variables:	[I3O2G5N]


	Output: India Three Oscar Two Golf Five November

```
# `run system/network 0 ip=127.0.0.1`
```

	using module: system==>network


	set ip ( class java.lang.String )  = 127.0.0.1


	Module:		network


	function:	0


	Variables:	[127.0.0.1]


	Output: [22, 631, 1716, 5600, 6463, 6464, 40111, 52394, 57621, 60009]

```
# `run system/network 1 ip=127.0.0.1`
```

	using module: system==>network


	set ip ( class java.lang.String )  = 127.0.0.1


	Module:		network


	function:	1


	Variables:	[127.0.0.1]


	Output: [ip=127.0.0.1, hostname=localhost, openPorts=[22, 631, 1716, 5600, 6463, 6464, 40111, 57344, 57621, 60009]]

```
# `run system/network 3 ip=127.0.01`
```

	using module: system==>network


	set ip ( class java.lang.String )  = 127.0.01


	Module:		network


	function:	3


	Variables:	[127.0.01]


	Output: true

```
# `run system/network 4`
```

	using module: system==>network


	Module:		network


	function:	4


	Variables:	[]


	Output: [10.0.1.106, 10.0.1.103]

```
# `run system/network 6`
```

	using module: system==>network


	Module:		network


	function:	6


	Variables:	[]


	Output: 127.0.1.1

```
# `run system/network 7 url=https://github.com`
```

	using module: system==>network


	set url ( class java.lang.String )  = https://github.com


	Module:		network


	function:	7


	Variables:	[https://github.com]


	Output: 140.82.121.3

```
