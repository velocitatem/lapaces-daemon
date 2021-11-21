# Usage
To better undedrstand a module and how it should be used, just press `CTRL + F` and search for the module name and function number like this `system/network 1` and you will get the sample output.

# `run physics/kinematics 0 distance 2 time 4`
```

	using module: physics==>kinematics


	set distance ( class java.lang.Double )  = 2.0


	set time ( class java.lang.Double )  = 4.0


	Module:		kinematics


	function:	0


	Variables:	[2.0, 4.0]


	Output: 0.5

```
# `run physics/kinematics 1 v0 2 v 3 t 3`
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
# `run physics/vectors 0 ax 1 ay 1`
```

	using module: physics==>vectors


	set ax ( class java.lang.Double )  = 1.0


	set ay ( class java.lang.Double )  = 1.0


	Module:		vectors


	function:	0


	Variables:	[1.0, 1.0]


	Output: 1.4142135623730951

```
# `run physics/vectors 1 ax 1 ay 1`
```

	using module: physics==>vectors


	set ax ( class java.lang.Double )  = 1.0


	set ay ( class java.lang.Double )  = 1.0


	Module:		vectors


	function:	1


	Variables:	[1.0, 1.0]


	Output: 45.0

```
# `run physics/vectors 2 theta 1.52 magnitude 1`
```

	using module: physics==>vectors


	set theta ( class java.lang.Double )  = 1.52


	set magnitude ( class java.lang.Double )  = 1.0


	Module:		vectors


	function:	2


	Variables:	[1.52, 1.0]


	Output: 0.05077448493357918i + 0.998710143975583j

```
# `run math/calculus 0 equation x*2 x 2`
```

	using module: math==>calculus


	set equation ( class java.lang.String )  = x*2


	set x ( class java.lang.Double )  = 2.0


	Module:		calculus


	function:	0


	Variables:	[x*2, 2.0]


	Output: 4.0

```
# `run math/calculus 1 equation Math.pow(2,x) x 2 order 1`
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
# `run math/calculus 2 equation Math.pow(2,x) x 3`
```

	using module: math==>calculus


	set equation ( class java.lang.String )  = Math.pow(2,x)


	set x ( class java.lang.Double )  = 3.0


	Module:		calculus


	function:	2


	Variables:	[Math.pow(2,x), 3.0]


	Output: y = 5.545177437227267x + (-8.6355323116818)

```
# `run math/operations 0 m1 2 b1 2 m2 -2 b2 2`
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
# `run math/operations 1 a 4`
```

	using module: math==>operations


	set a ( class java.lang.Double )  = 4.0


	Module:		operations


	function:	1


	Variables:	[4.0]


	Output: 24.0

```
# `run astronomy/navigation 0`
```

	using module: astronomy==>navigation


	Module:		navigation


	function:	0


	Variables:	[]


	Output: 2459539.357872801

```
# `run astronomy/navigation 1 year 2021 month 6 day 15 hour 12 minute 30 second 30 millis 5`
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
# `run computing/cryptography 0 type md2 body hello`
```

	using module: computing==>cryptography


	set type ( class java.lang.String )  = md2


	set body ( class java.lang.String )  = hello


	Module:		cryptography


	function:	0


	Variables:	[md2, hello]


	Output: a9046c73e00331af68917d3804f70655

```
# `run computing/sorting 0 array arr(-0.5,-2,3,-40)`
```

	using module: computing==>sorting


	set array ( class [Ljava.lang.String; )  = [Ljava.lang.String;@772bc4c9


	Module:		sorting


	function:	0


	Variables:	[[Ljava.lang.String;@772bc4c9]


	Output: [-40.0, -2.0, -0.5, 3.0]

```
# `run computing/sorting 1 array arr(-0.5,-2,3,-40)`
```

	using module: computing==>sorting


	set array ( class [Ljava.lang.String; )  = [Ljava.lang.String;@34ea86ff


	Module:		sorting


	function:	1


	Variables:	[[Ljava.lang.String;@34ea86ff]


	Output: [-40.0, -2.0, -0.5, 3.0]

```
# `run computing/sorting 2 array arr(-0.5,-2,3,-40)`
```

	using module: computing==>sorting


	set array ( class [Ljava.lang.String; )  = [Ljava.lang.String;@4bcf08ae


	Module:		sorting


	function:	2


	Variables:	[[Ljava.lang.String;@4bcf08ae]


	Output: [-40.0, -2.0, -0.5, 3.0]

```
# `run computing/sorting 3 array arr(-0.5,-2,3,-40)`
```

	using module: computing==>sorting


	set array ( class [Ljava.lang.String; )  = [Ljava.lang.String;@626b9092


	Module:		sorting


	function:	3


	Variables:	[[Ljava.lang.String;@626b9092]


	Output: [-40.0, -2.0, -0.5, 3.0]

```
# `run system/network 0 ip 127.0.0.1`
```

	using module: system==>network


	set ip ( class java.lang.String )  = 127.0.0.1


	Module:		network


	function:	0


	Variables:	[127.0.0.1]


	Output: [631, 1716, 6463, 38515, 45241, 57315, 57621]

```
# `run system/network 1 ip 127.0.0.1`
```

	using module: system==>network


	set ip ( class java.lang.String )  = 127.0.0.1


	Module:		network


	function:	1


	Variables:	[127.0.0.1]


	Output: [ip=127.0.0.1, hostname=localhost, openPorts=[631, 1716, 6463, 36318, 38515, 45241, 54950, 57315, 57621]]

```
# `run system/network 2 T 1`
```

	using module: system==>network


	set T ( class java.lang.Double )  = 1.0


	Module:		network


	function:	2


	Variables:	[1.0]


	Output: [10.0.1.12, 10.0.1.101, 10.0.1.103, 10.0.1.106]

```
# `run system/network 3 ip 127.0.01`
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
# `run system/network 7 url https://github.com`
```

	using module: system==>network


	set url ( class java.lang.String )  = https://github.com


	Module:		network


	function:	7


	Variables:	[https://github.com]


	Output: 140.82.121.3

```
