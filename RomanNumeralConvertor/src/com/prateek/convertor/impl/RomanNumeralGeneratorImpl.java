package com.prateek.convertor.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.prateek.convertor.RomanNumeralGenerator;

/**
 * @author Prateek Garg
 *
 */
public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {

	private static final Map<Integer, String> map = new TreeMap<Integer, String>((a, b) -> b.compareTo(a));
	static {
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
	}

	/*
	 * Method will take the integer as input and produces the corresponding
	 * roman numeral as ouput
	 * 
	 * @param number
	 * 
	 * @return String
	 * 
	 * @see com.prateek.convertor.RomanNumeralGenerator#generate(int)
	 */
	@Override
	public String generate(int number) {
		StringBuffer b = new StringBuffer();
		if (number > 3999 || number < 1) {
			return "Not a Valid Number for Roman Numeral";
		}
		Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
		int divideResults = number;
		while (it.hasNext()) {
			Entry<Integer, String> next = it.next();
			if (divideResults < next.getKey()) {
				continue;
			}
			int remainder = divideResults / next.getKey();
			for (int i = 0; i < remainder; i++) {
				b.append(next.getValue());
			}
			divideResults = divideResults % next.getKey();
		}
		return b.toString();
	}
}
