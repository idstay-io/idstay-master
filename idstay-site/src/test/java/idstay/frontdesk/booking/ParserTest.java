package idstay.frontdesk.booking;

import idstay.frontdesk.booking.parser.Parser;
import idstay.frontdesk.booking.parser.ParserFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 29.
 */

import static org.hamcrest.Matchers.*;

public class ParserTest {
    private String expediaStr = "Travel arrangements provided through Expedia\n" +
            "Reservation ID: 744739184\tGuest: Kenji Tanaka\tBooked on: Oct 23 2016 02:26PST\n" +
            "81 (902) 5044193\n" +
            "tnk-kens@jcom.home.ne.jp\n" +
            "Room Type Code: Standard Double Room\n" +
            "Room Type Name:\t\tStandard Double Room - Room Only NR\n" +
            "Pricing Model: Per Day Pricing\n" +
            "Payment Instructions: Expedia collects payment from traveler: Hotel invoices Expedia.\n" +
            "Check-In\tCheck-Out\tAdults\tKids/Ages\tRoom Nights\tHotel Conf\n" +
            "Jan 02 2017\tJan 04 2017\t2\t0\t2\t\n" +
            "Special Request\n" +
            "1 double or 1 twin bed , Non-Smoking\n" +
            "Daily Rate - Package - 46,964 KRW\n" +
            "Mon, Jan 02\tTue, Jan 03\t\n" +
            "Rate Code: RoomOnlyNR\t\t\n" +
            "Discount: Airtel 40%off (min 2nights) 50da\n" +
            "Extra Person:\t0 KRW\n" +
            "Taxes:\t9,392 KRW\n" +
            "Extra Charges:\t0 KRW";

    @Test
    public void foo() {
        Parser expedia = ParserFactory.getParser(expediaStr);
        assertThat(expedia, is(notNullValue()));

        assertThat(expedia.getReservationID(), is("744739184"));
        assertThat(expedia.getGuest(), is("Kenji Tanaka"));
        assertThat(expedia.getPhone(), is("81 (902) 5044193"));
        assertThat(expedia.getEmail(), is("tnk-kens@jcom.home.ne.jp"));
        assertThat(expedia.getCheckIn(), is("Jan 02 2017"));
        assertThat(expedia.getCheckOut(), is("Jan 04 2017"));
        assertThat(expedia.getKids(), is("0"));
        assertThat(expedia.getAdults(), is("2"));
        assertThat(expedia.getSpecialRequest(), is("1 double or 1 twin bed , Non-Smoking"));


//        BookingController controller = new BookingController();
//
//        OtaInvoiceDto form = new OtaInvoiceDto();
//        form.setInvoiceStr(expediaStr);
//        controller.parsOtaInvoice(form);
//        assertThat(form.getOtaName(), is(Ota.Expedia));

    }

}