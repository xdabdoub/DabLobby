package me.yhamarsheh.dablobby.utilities;

import org.bukkit.ChatColor;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ChatUtils {

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String dateDifference(GregorianCalendar x, GregorianCalendar y) {
        int years = x.get(GregorianCalendar.YEAR) - y.get(GregorianCalendar.YEAR);
        int months = x.get(GregorianCalendar.MONTH) - y.get(GregorianCalendar.MONTH);
        int days = x.get(GregorianCalendar.DAY_OF_MONTH) - y.get(GregorianCalendar.DAY_OF_MONTH);

        if (days < 0) {
            months--;
            days += y.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        }

        if (months < 0) {
            years--;
            months += 12;
        }

        return ((years > 0) ? years + " year" + ((years > 1) ? "s " : " ") : "") + ((months > 0) ? months + " month" + ((months > 1) ? "s " : " ") : "")
                + days + " day" + ((days > 1) ? "s " : "");
    }
}
