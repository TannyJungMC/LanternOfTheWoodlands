package tannyjung.lanternofthewoodlands.procedures;

public class FontConvertThinProcedure {
	public static String execute(String text) {
		if (text == null)
			return "";
		double count = 0;
		String single_character = "";
		String converted = "";
		while (count < (text).length()) {
			if (true) {
				single_character = text.substring((int) count, (int) (count + 1));
				if (true) {
					if ((single_character).equals("A")) {
						single_character = "\uD835\uDDA0";
					} else if ((single_character).equals("B")) {
						single_character = "\uD835\uDDA1";
					} else if ((single_character).equals("C")) {
						single_character = "\uD835\uDDA2";
					} else if ((single_character).equals("D")) {
						single_character = "\uD835\uDDA3";
					} else if ((single_character).equals("E")) {
						single_character = "\uD835\uDDA4";
					} else if ((single_character).equals("F")) {
						single_character = "\uD835\uDDA5";
					} else if ((single_character).equals("G")) {
						single_character = "\uD835\uDDA6";
					} else if ((single_character).equals("H")) {
						single_character = "\uD835\uDDA7";
					} else if ((single_character).equals("I")) {
						single_character = "\uD835\uDDA8";
					} else if ((single_character).equals("J")) {
						single_character = "\uD835\uDDA9";
					} else if ((single_character).equals("K")) {
						single_character = "\uD835\uDDAA";
					} else if ((single_character).equals("L")) {
						single_character = "\uD835\uDDAB";
					} else if ((single_character).equals("M")) {
						single_character = "\uD835\uDDAC";
					} else if ((single_character).equals("N")) {
						single_character = "\uD835\uDDAD";
					} else if ((single_character).equals("O")) {
						single_character = "\uD835\uDDAE";
					} else if ((single_character).equals("P")) {
						single_character = "\uD835\uDDAF";
					} else if ((single_character).equals("Q")) {
						single_character = "\uD835\uDDB0";
					} else if ((single_character).equals("R")) {
						single_character = "\uD835\uDDB1";
					} else if ((single_character).equals("S")) {
						single_character = "\uD835\uDDB2";
					} else if ((single_character).equals("T")) {
						single_character = "\uD835\uDDB3";
					} else if ((single_character).equals("U")) {
						single_character = "\uD835\uDDB4";
					} else if ((single_character).equals("V")) {
						single_character = "\uD835\uDDB5";
					} else if ((single_character).equals("W")) {
						single_character = "\uD835\uDDB6";
					} else if ((single_character).equals("X")) {
						single_character = "\uD835\uDDB7";
					} else if ((single_character).equals("Y")) {
						single_character = "\uD835\uDDB8";
					} else if ((single_character).equals("Z")) {
						single_character = "\uD835\uDDB9";
					}
					if ((single_character).equals("0")) {
						single_character = "\uD835\uDFE2";
					} else if ((single_character).equals("1")) {
						single_character = "\uD835\uDFE3";
					} else if ((single_character).equals("2")) {
						single_character = "\uD835\uDFE4";
					} else if ((single_character).equals("3")) {
						single_character = "\uD835\uDFE5";
					} else if ((single_character).equals("4")) {
						single_character = "\uD835\uDFE6";
					} else if ((single_character).equals("5")) {
						single_character = "\uD835\uDFE7";
					} else if ((single_character).equals("6")) {
						single_character = "\uD835\uDFE8";
					} else if ((single_character).equals("7")) {
						single_character = "\uD835\uDFE9";
					} else if ((single_character).equals("8")) {
						single_character = "\uD835\uDFEA";
					} else if ((single_character).equals("9")) {
						single_character = "\uD835\uDFEB";
					}
					if ((single_character).equals(":")) {
						single_character = "\u2236";
					} else if ((single_character).equals(">")) {
						single_character = "\u25B9";
					}
				}
				converted = converted + "" + single_character;
			}
			count = count + 1;
		}
		return converted;
	}
}
