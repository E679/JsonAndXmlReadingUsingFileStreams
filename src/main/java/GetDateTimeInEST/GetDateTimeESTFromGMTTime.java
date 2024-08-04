package GetDateTimeInEST;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class GetDateTimeESTFromGMTTime {
    public static void main(String[] args) {

        getDateTimeinESTFromGMTTime();
    }

    private static void getDateTimeinESTFromGMTTime() {
        //SimpleDateFormat gmtdate= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//        SimpleDateFormat gmtdate= new SimpleDateFormat(format);
//        gmtdate.setTimeZone(TimeZone.getTimeZone("GMT"));
//
//        try {
//            Date date = gmtdate.parse("04/08/2024");
//            SimpleDateFormat estdate= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//            estdate.setTimeZone(TimeZone.getTimeZone("America/New_York"));
//            String estDateTime = estdate.format(date);
//            System.out.println(estDateTime);
//
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
    }
}
