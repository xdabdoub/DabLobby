package me.yhamarsheh.dablobby.utilities;

import org.bukkit.ChatColor;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ChatUtils {

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String dateDifference(GregorianCalendar x, GregorianCalendar y) {
        int years = y.get(Calendar.YEAR) - x.get(Calendar.YEAR);
        int months = y.get(Calendar.MONTH) - x.get(Calendar.MONTH);
        int days = y.get(Calendar.DAY_OF_MONTH) - x.get(Calendar.DAY_OF_MONTH);

        return ((years > 0) ? years + " year" + ((years > 1) ? "s" : "") : "") + ((months > 0) ? months + " month" + ((months > 1) ? "s" : "") : "")
                + days + " day" + ((days > 1) ? "s" : "");
    }
}
