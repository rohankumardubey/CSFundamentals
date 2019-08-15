package org.redquark.features.java8.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 *
 */
public class DisplayZoneAndOffset {

	private static final boolean SORT_BY_REGION = false;

	public static void main(String[] args) {

		Map<String, String> sortedMap = new LinkedHashMap<>();
		Map<String, String> allZoneIdsAndTheirOffset = getAllZoneIdsandTheirOffset();

		// Sort map by key
		if (SORT_BY_REGION) {
			allZoneIdsAndTheirOffset.entrySet().stream().sorted(Map.Entry.comparingByKey())
					.forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));
		} else {
			allZoneIdsAndTheirOffset.entrySet().stream().sorted(Map.Entry.<String, String>comparingByValue().reversed())
					.forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));
		}

		// Print map
		sortedMap.forEach((k, v) -> {
			String out = String.format("%35s (UTC%s) %n", k, v);
			System.out.printf(out);
		});

		System.out.println("\n Total zone ids: " + sortedMap.size());
	}

	private static Map<String, String> getAllZoneIdsandTheirOffset() {

		Map<String, String> result = new HashMap<>();
		LocalDateTime localDateTime = LocalDateTime.now();

		for (String zoneId : ZoneId.getAvailableZoneIds()) {

			ZoneId id = ZoneId.of(zoneId);

			// LocalDateTime -> ZonedDateTime
			ZonedDateTime zonedDateTime = localDateTime.atZone(id);

			// ZonedDateTime -> ZoneOffset
			ZoneOffset zoneOffset = zonedDateTime.getOffset();

			// Replace Z to 00:00
			String offset = zoneOffset.getId().replaceAll("Z", "00:00");

			result.put(id.toString(), offset);
		}

		return result;
	}
}
