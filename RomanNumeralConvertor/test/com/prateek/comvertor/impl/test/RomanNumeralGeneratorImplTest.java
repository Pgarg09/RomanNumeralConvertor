package com.prateek.comvertor.impl.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.prateek.convertor.RomanNumeralGenerator;
import com.prateek.convertor.impl.RomanNumeralGeneratorImpl;

public class RomanNumeralGeneratorImplTest {

	private static final Map<Integer, String> testMap = new HashMap<Integer, String>();
	@Before
	public void setUp() throws Exception {
		testMap.put(-1, "Not a Valid Number for Roman Numeral");
		testMap.put(0, "Not a Valid Number for Roman Numeral");
		testMap.put(7, "VII");
		testMap.put(13, "XIII");
		testMap.put(43, "XLIII");
		testMap.put(566, "DLXVI");
		testMap.put(99, "XCIX");
		testMap.put(90, "XC");
		testMap.put(279, "CCLXXIX");
		testMap.put(789, "DCCLXXXIX");
		testMap.put(7899, "Not a Valid Number for Roman Numeral");
		testMap.put(1333, "MCCCXXXIII");
		testMap.put(2378, "MMCCCLXXVIII");
		testMap.put(3999, "MMMCMXCIX");
		testMap.put(5637, "Not a Valid Number for Roman Numeral");
		testMap.put(1345, "MCCCXLV");
		testMap.put(2355, "MMCCCLV");
	}

	@Test
	public void generateTest() {
		Iterator<Entry<Integer, String>> iter = testMap.entrySet().iterator();
		RomanNumeralGenerator generator = new RomanNumeralGeneratorImpl();
		while(iter.hasNext()) {
			Entry<Integer, String> mapData = iter.next();
			Integer key = mapData.getKey();
			String value  = mapData.getValue();
			
			String returnGeneratedValue =  generator.generate(key);
			Assert.assertTrue("Condition is satistfied ", value.equals(returnGeneratedValue));
			
		}
		
	}

}
