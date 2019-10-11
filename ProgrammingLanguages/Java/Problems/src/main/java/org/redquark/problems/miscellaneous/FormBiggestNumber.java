package org.redquark.problems.miscellaneous;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Anirudh Sharma
 *
 */
public class FormBiggestNumber {

	public static void main(String[] args) {

		// List to store numbers
		List<String> numbers = Arrays.asList("01", "34", "3", "98", "9", "76", "45", "4");
		
		for (int i = 0; i < numbers.size(); i++) {
			final Integer intS = Integer.parseInt(numbers.get(i));
			numbers.set(i, intS.toString());
		}

		Collections.sort(numbers, new Comparator<String>() {

			@Override
			public int compare(String x, String y) {

				// Form combination of Strings
				String XY = x + y;
				String YX = y + x;

				// sort the String elements
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});

		StringBuilder sb = new StringBuilder();
        for(String s : numbers) {
            sb.append(s);
        }
        String result = sb.toString();
        if(Long.parseLong(result) == 0) {
            result = "0";
        }
        
        System.out.println(result);
	}

}
