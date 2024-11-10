package stepDefinitions.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils extends Exception {

    public static String getCurrentDateTime(String format, String timeZoneId) {
        String dateTime = "";
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
            Instant instant = Instant.now();
            if (timeZoneId.equalsIgnoreCase("BST")) {
                timeZoneId = "Europe/London";
            }
            ZoneId id = ZoneId.of(timeZoneId);
            ZonedDateTime zdt = instant.atZone(id);
            dateTime = zdt.format(dateTimeFormatter);
        } catch (java.lang.Exception e) {
            logFail(e.getMessage());
        }
        return dateTime;
    }
}
