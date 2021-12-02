package lada.shell.velo.main.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lada.shell.velo.main.Commands;

class VariablePassingv2 {

	ArrayList<String> parseCommand(String cmd) {
		ArrayList<String> r = new ArrayList<String>();
		String[] s = cmd.split("");
		boolean isopen = false;
		int lastIndex = 0, i = 0;
		for (String c : s) {
			if (!isopen) {
				switch (c) {
				case " ":
					String sus = cmd.substring(lastIndex, i + 1).trim();
					r.add(sus);
					lastIndex = i + 1;
					break;
				case "(":
					isopen = true;
					break;
				default:

					break;
				}
			} else {
				switch (c) {
				case ")":
					String sus = cmd.substring(lastIndex, i + 1).trim();
					r.add(sus);
					lastIndex = i + 1;
					isopen = false;
					break;
				default:
					break;
				}
			}
			i += 1;
		}
		return r;
	}

	@Test
	void test() {
		String[] variables = { "query", "code" };
		Object[] buff = new Object[24];
		String[] commands = { "set code=(something)", "set data=(This is something new)",
				"run this/module 2 data=(some data) code=752h2" };
		ArrayList<String> O = Commands.parseCommand(commands[2]);
		System.out.println(O);
	}

}
