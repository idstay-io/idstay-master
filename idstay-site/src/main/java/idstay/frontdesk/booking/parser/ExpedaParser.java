package idstay.frontdesk.booking.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 11. 5.
 */
public class ExpedaParser implements Parser {
    private String otaInvoice;
    private static final String OTA_CHECKER = "Expedia";
    private static final String TOKEN = "\t\n";
    private static final String TOKEN_RESERVATION_ID = "Reservation ID: ";
    private static final String TOKEN_GUEST = "Guest: ";
    private static final String TOKEN_BOOKED_ON = "Booked on: ";
    private static final String TOKEN_ROOM_TYPE_CODE = "Booked on: ";
    private static final String TOKEN_CHECK_IN = "Check-In";
    private static final String TOKEN_CHECK_OUT = "Check-Out";
    private static final String TOKEN_KIDS = "Kids/Ages";
    private static final String TOKEN_SPECIAL_REQUEST = "Special Request";
    private static final String TOKEN_ADULTS = "Adults";


    public ExpedaParser(final String otaInvoice) {
        this.otaInvoice = otaInvoice;
    }

    public String getReservationID() {
        return getParsString(TOKEN_RESERVATION_ID);
    }

    public String getGuest() {
        return getParsString(TOKEN_GUEST);
    }

    public String getBookedOn() {
        return getParsString(TOKEN_BOOKED_ON);
    }

    public String getPhone() {
        return getParsString(TOKEN_BOOKED_ON, 1);
    }

    public String getEmail() {
        return getParsString(TOKEN_BOOKED_ON, 2);
    }

    public int getCheckIn() {
        return toInt(getParsString(TOKEN_CHECK_IN, 6));
    }

    public int getCheckOut() {
        return toInt(getParsString(TOKEN_CHECK_OUT, 6));
    }

    public String getAdults() {
        return getParsString(TOKEN_ADULTS, 6);
    }

    public String getKids() {
        return getParsString(TOKEN_KIDS, 6);
    }

    public String getSpecialRequest() {
        return getParsString(TOKEN_SPECIAL_REQUEST, 1);
    }

    private String getParsString(final String token) {
        StringTokenizer tokenizer = new StringTokenizer(this.otaInvoice,TOKEN);

        while(tokenizer.hasMoreTokens()) {
            String str = tokenizer.nextToken();
            if(str.contains(token))
                return str.substring(token.length(), str.length());
        }
        return null;
    }

    private String getParsString(final String token, final int repeate) {
        StringTokenizer tokenizer = new StringTokenizer(this.otaInvoice,TOKEN);

        while(tokenizer.hasMoreTokens()) {
            if(tokenizer.nextToken().contains(token)){
                return getNextToken(tokenizer, repeate);
            }
        }
        return null;
    }

    private String getNextToken(StringTokenizer tokenizer, int repeate) {
        String nextString = "";
        for(int i=0; i<repeate; i++){
            nextString = tokenizer.nextToken();
        }
        return nextString;
    }

    private int toInt(final String date){
        SimpleDateFormat fromFormat = new SimpleDateFormat("MMM dd yyyy");
        SimpleDateFormat toFormat = new SimpleDateFormat("yyyyMMdd");

        String toFormatString = null;

        try {
            toFormatString= toFormat.format(fromFormat.parse(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return Integer.parseInt(toFormatString);
    }

}
