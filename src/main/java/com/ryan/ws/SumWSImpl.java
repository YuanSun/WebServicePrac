package com.ryan.ws;

import com.ryan.ws.dto.SumRequest;
import com.ryan.ws.dto.SumResponse;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class SumWSImpl implements SumWS {
    @Override
    public SumResponse calculateSum(SumRequest request) {
        int result = request.getNum1() + request.getNum2();
        SumResponse sumResponse = new SumResponse();
        sumResponse.setResult(result);
        return sumResponse;

    }

    public static Month convertMonthWithJoda(String monthStr) {
        DateTimeFormatter jodaFormatter = DateTimeFormat.forPattern("MMM");
        DateTime date = jodaFormatter.parseDateTime(monthStr);
        int monthValue = date.getMonthOfYear();

        return Month.of(monthValue);
    }

    public static Month convertMonthWithJavaTime(String monthStr) {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("MMM");
        List<String> MONTH_LIST = Arrays.asList("JAN", "FEB", "MAR",
                "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC");
        Optional<Integer> first = MONTH_LIST.stream()
                .filter(month -> month.equals(monthStr))
                .map(month -> MONTH_LIST.indexOf(month) + 1)
                .findFirst();
        if(first.isPresent()) {
            return Month.of(first.get());
        } else if (checkMonth(monthStr)){
            for (Month month : Month.values()) {
                if(month.name().equalsIgnoreCase(monthStr)) {
                    return month;
                }
            }
            throw new IllegalArgumentException("No such month");
        } else {
            throw new IllegalArgumentException("No such month");
        }
    }

    private static boolean checkMonth(String monthStr) {
        for(Month month: Month.values()) {
            if (month.name().equalsIgnoreCase(monthStr)) {
                return true;
            }
        }
        return false;
    }
}
