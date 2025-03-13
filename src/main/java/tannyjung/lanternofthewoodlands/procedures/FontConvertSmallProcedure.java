package tannyjung.lanternofthewoodlands.procedures;

public class FontConvertSmallProcedure {
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
					if ((single_character).equals("0")) {
						single_character = "\u2070";
					} else if ((single_character).equals("1")) {
						single_character = "\u00B9";
					} else if ((single_character).equals("2")) {
						single_character = "\u00B2";
					} else if ((single_character).equals("3")) {
						single_character = "\u00B3";
					} else if ((single_character).equals("4")) {
						single_character = "\u2074";
					} else if ((single_character).equals("5")) {
						single_character = "\u2075";
					} else if ((single_character).equals("6")) {
						single_character = "\u2076";
					} else if ((single_character).equals("7")) {
						single_character = "\u2077";
					} else if ((single_character).equals("8")) {
						single_character = "\u2078";
					} else if ((single_character).equals("9")) {
						single_character = "\u2079";
					}
				}
				converted = converted + "" + single_character;
			}
			count = count + 1;
		}
		return converted;
	}
}
