package com.hiddenleaf.util;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Raghunathan
 *
 */
@Component
public class StringUtil implements interfaceCSVDataTypeValidatorParseData {

	// --dd/mm/yyyy
	public static final String DATE_PATTERN = "[dd-MM-yyyy]";
	// -- all chars
	// ^[^<>{}\"/|;:.,~!?@#$%^=&*\\]\\\\()\\[¿§«»ω⊙¤°℃℉€¥£¢¡®©A-Za-z0-9_+]*$
	public static final String REG_EXPP_ALPHA_NUMERIC_SPECIAL = "^[a-zA-Z0-9/_&\\s.,()-]*$";

	public static final String REG_EXPP_NUMERIC_SPECIAL = "^[0-9]*$"; // -- "-?[0-9]+"

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

	private static Map<String, Boolean> TRUE_FALSE_VALUES = getTrueFalseValues();

	static TemporalAccessor parseDate(String dateAsString) {
		return FORMATTER.parseBest(dateAsString, LocalDate::from, YearMonth::from, Year::from);
	}

	public static final boolean isNullOrEmpty(String str) {
		if (str != null && !str.trim().isEmpty())
			return false;
		return true;
	}

	public static final boolean isNullOrEmptyZero(String str) {
		if (str != null && !str.trim().isEmpty()) {
			str = str.trim();
			if (!str.equals("0")) {
				return false;
			}
		}
		return true;
	}

	public static final boolean isNullOrEmptyOrZero(String str) {
		if (str != null && !str.trim().isEmpty()) {
			str = str.trim();
			if (str.contains(".") || str.contains("-") || StringUtil.parseLong(str) != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 */
	public StringUtil() {
		super();
	}

	/**
	 * 
	 * @param dateAsString
	 * @return
	 */
	public static final boolean isValidDate(String dateAsString) {
		try {
			parseDate(dateAsString);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static final boolean isValidInteger(String value) {
		if (value == null || value.trim().isEmpty()) {
			return false;
		}
		Pattern p = Pattern.compile(REG_EXPP_NUMERIC_SPECIAL);
		Matcher m = p.matcher(value);
		return m.matches();
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static final boolean isValidString(String value) {
		if (value == null) {
			return false;
		} else if (value.trim().isEmpty()) {
			return false;
		}
		Pattern p = Pattern.compile(REG_EXPP_ALPHA_NUMERIC_SPECIAL);
		Matcher m = p.matcher(value);
		return m.matches();
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static final boolean isValidInt(String value) {
		parseInt(value, 0);
		return false;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static final boolean isValid(String value) {
		parseBoolean(value);
		return false;
	}

	/**
	 * Replaces characters that are not allowed in a Java style string literal with
	 * their escape characters. Specifically quote ("), single quote ('), new line
	 * (\n), carriage return (\r), and backslash (\), and tab (\t) are escaped.
	 *
	 * @param s String to be escaped
	 * @return escaped String
	 * @throws NullPointerException if s is null.
	 */
	public static final String escapeJavaLiteral(String s) {
		int length = s.length();
		int newLength = length;
		// first check for characters that might
		// be dangerous and calculate a length
		// of the string that has escapes.
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			switch (c) {
			case '\"':
			case '\'':
			case '\n':
			case '\r':
			case '\t':
			case '\\': {
				newLength += 1;
			}
				break;
			}
		}
		if (length == newLength) {
			return s;
		}
		StringBuffer sb = new StringBuffer(newLength);
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			switch (c) {
			case '\"': {
				sb.append("\\\"");
			}
				break;
			case '\'': {
				sb.append("\\\'");
			}
				break;
			case '\n': {
				sb.append("\\n");
			}
				break;
			case '\r': {
				sb.append("\\r");
			}
				break;
			case '\t': {
				sb.append("\\t");
			}
				break;
			case '\\': {
				sb.append("\\\\");
			}
				break;
			default: {
				sb.append(c);
			}
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static final Integer parseInteger(String s) {
		if (s == null)
			return null;
		s = s.trim();
		int radix = 10;
		if (s.startsWith("0x") || s.startsWith("0X")) {
			radix = 16;
			s = s.substring(2);
		}
		if (s.startsWith("0c") || s.startsWith("0C")) {
			radix = 8;
			s = s.substring(2);
		}
		if (s.startsWith("0b") || s.startsWith("0B")) {
			radix = 2;
			s = s.substring(2);
		}
		return parseInteger(s, radix);
	}

	/**
	 * 
	 * @param s
	 * @param radix
	 * @return
	 */
	public static final Integer parseInteger(String s, int radix) {
		if (s == null)
			return null;
		s = s.trim();
		try {
			return Integer.valueOf(s, radix);
		} catch (NumberFormatException nfx) {
			return null;
		}
	}

	/**
	 * 
	 * @param s
	 * @param defaultValue
	 * @return
	 */
	public static final int parseInt(String s, int defaultValue) {
		Integer integer = parseInteger(s);
		if (integer != null)
			return integer.intValue();
		return defaultValue;
	}

	/**
	 * 
	 * @param s
	 * @param defaultValue
	 * @return
	 */
	public static final long parseLong(String longData) {
		try {
			return Long.parseLong(longData.trim());
		} catch (Exception exception) {
			return 0;
		}
	}

	/**
	 * 
	 * @param s
	 * @param defaultValue
	 * @return
	 */
	public static final double parseDouble(String doubleData) {

		try {
			return Double.parseDouble(doubleData.trim());
		} catch (Exception exception) {
			return 0;
		}
	}

	/**
	 * 
	 * @param s
	 * @param radix
	 * @param defaultValue
	 * @return
	 */
	public static final int parseInt(String s, int radix, int defaultValue) {
		Integer integer = parseInteger(s, radix);
		if (integer != null)
			return integer.intValue();
		return defaultValue;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static final Boolean parseBoolean(String s) {
		if (s == null)
			return null;
		s = s.trim();
		s = s.toLowerCase();
		return TRUE_FALSE_VALUES.get(s);
	}

	/**
	 * 
	 * @param s
	 * @param defaultValue
	 * @return
	 */
	public static final boolean parseBoolean(String s, boolean defaultValue) {
		Boolean b = parseBoolean(s);
		if (b != null)
			return b.booleanValue();
		return defaultValue;
	}

	/**
	 * 
	 * @return
	 */
	private static Map<String, Boolean> getTrueFalseValues() {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();

		map.put("true", Boolean.TRUE);
		map.put("t", Boolean.TRUE);
		map.put("yes", Boolean.TRUE);
		map.put("y", Boolean.TRUE);
		map.put("ok", Boolean.TRUE);
		map.put("sure", Boolean.TRUE);
		map.put("yeah", Boolean.TRUE);
		map.put("yup", Boolean.TRUE);
		map.put("1", Boolean.TRUE);
		map.put("affirmative", Boolean.TRUE);
		map.put("positive", Boolean.TRUE);

		map.put("false", Boolean.FALSE);
		map.put("f", Boolean.FALSE);
		map.put("no", Boolean.FALSE);
		map.put("n", Boolean.FALSE);
		map.put("0", Boolean.FALSE);
		map.put("not", Boolean.FALSE);
		map.put("nope", Boolean.FALSE);
		map.put("negative", Boolean.FALSE);

		return map;
	}

	public static String prepareLocation(HashMap<String, Long> binMap) {
		// TODO Auto-generated method stub
		String concadinated = null;
		if (binMap != null)
			for (Entry<String, Long> entry : binMap.entrySet())
				concadinated = (concadinated == null ? "" : concadinated + ",") + entry.getKey() + "("
						+ entry.getValue() + ")";
		return concadinated;
	}

	public static long parseLong(Long longData) {
		// TODO Auto-generated method stub
		try {
			return longData.longValue();
		} catch (Exception e) {
			return 0;
		}
	}

	public static final Boolean parseBoolean(Boolean s) {
		try {
			return s.booleanValue();
		} catch (Exception exception) {
			return false;
		}
	}

	public static String join(ArrayList<String> fields) {
		// TODO Auto-generated method stub
		String combined = "";
		for (String field : fields) {
			if (!isNullOrEmpty(field))
				combined += (combined.isEmpty() ? "" : ", ") + field;
		}
		return combined;
	}

	public static String join(String... fields) {
		// TODO Auto-generated method stub
		String combined = "";
		for (String field : fields) {
			if (!isNullOrEmpty(field))
				combined += (combined.isEmpty() ? "" : ", ") + field;
		}
		return combined;
	}

	public static final String handleNullorEmpty(String str) {
		return str == null ? "" : str.trim();
	}
	
	public static final boolean handleIsNull(Boolean bool) {
		if (bool == null)
			return false;
		return bool;
	}
	public static String checkNull(String str, String _default) {
		String result = null;
		try {
			if (str != null && str.trim().length() > 0 && !str.trim().equals("null")) {
				result = str.trim();
			} else {
				result = _default;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean isStringInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
	
	public static boolean isStringDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}

