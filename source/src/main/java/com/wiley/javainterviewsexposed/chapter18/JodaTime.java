package com.wiley.javainterviewsexposed.chapter18;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JodaTime {

    @Test
    public void javaCalendar() {
        final Calendar now = Calendar.getInstance();
        final Calendar lastMonth = Calendar.getInstance();
        lastMonth.add(Calendar.MONTH, -1);

        assertTrue(lastMonth.before(now));
    }

    @Test
    public void dateTime() {
        final DateTime now = new DateTime();
        final DateTime lastWeek = new DateTime().minusDays(7);

        assertEquals(now.getDayOfWeek(), lastWeek.getDayOfWeek());
    }

    @Test
    public void withDateAndCalendar() {
        final Calendar nowCal = Calendar.getInstance();
        final DateTime nowDateTime = new DateTime(nowCal);

        final DateTime tenSecondsFuture = nowDateTime.plusSeconds(10);

        nowCal.add(Calendar.SECOND, 10);
        assertEquals(tenSecondsFuture.toDate(), nowCal.getTime());
    }

    @Test
    public void duration() {
        final DateTime dateTime1 = new DateTime(2010, 1, 1, 0, 0, 0, 0); // midnight, January 1 2010
        final DateTime dateTime2 = new DateTime(2010, 2, 1, 0, 0, 0, 0); // midnight, February 1 2010

        final Duration duration = new Duration(dateTime1, dateTime2);

        final DateTime dateTime3 = new DateTime(2010, 9, 1, 0, 0, 0, 0);
        final DateTime dateTime4 = dateTime3.withDurationAdded(duration, 1);

        assertEquals(2, dateTime4.getDayOfMonth());
        assertEquals(10, dateTime4.getMonthOfYear());
    }

    @Test
    public void period() {
        final DateTime dateTime1 = new DateTime(2011, 2, 1, 0, 0, 0, 0);
        final DateTime dateTime2 = new DateTime(2011, 3, 1, 0, 0, 0, 0);

        final Period period = new Period(dateTime1, dateTime2);

        final DateTime dateTime3 = new DateTime(2012, 2, 1, 0, 0, 0, 0);
        final DateTime dateTime4 = dateTime3.withPeriodAdded(period, 1);

        assertEquals(1, dateTime4.getDayOfMonth());
        assertEquals(3, dateTime4.getMonthOfYear());
    }

    @Test
    public void simpleDateFormat() {
        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DAY_OF_MONTH, 17);

        final SimpleDateFormat formatter = new SimpleDateFormat("'The date is 'dd MMMM");

        assertEquals(
                "The date is 17 July",
                formatter.format(cal.getTime()));
    }

    @Test
    public void jodaFormat() {
        final DateTime dateTime = new DateTime()
                .withMonthOfYear(7)
                .withDayOfMonth(17);

        final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendLiteral("The date is ")
                .appendDayOfMonth(2)
                .appendLiteral(' ')
                .appendMonthOfYearText()
                .toFormatter();

        assertEquals("The date is 17 July", formatter.print(dateTime));
    }
}
