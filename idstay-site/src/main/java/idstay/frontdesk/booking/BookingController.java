package idstay.frontdesk.booking;

import idstay.frontdesk.booking.dto.OtaInvoiceDto;
import idstay.frontdesk.booking.id.BookingId;
import idstay.frontdesk.booking.id.StayId;
import idstay.frontdesk.booking.parser.Parser;
import idstay.frontdesk.booking.parser.ParserFactory;
import idstay.frontdesk.booking.request.BookingRequest;
import idstay.frontdesk.booking.request.StayInfo;
import idstay.frontdesk.bookingengine.BookingEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 11. 4.
 */
@Controller
public class BookingController {
    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
    private BookingEngine bookingEngine;

    @RequestMapping(value = "/1/ota_invoice", method = GET)
    public String ota_invoice(OtaInvoiceDto dto) {

        logger.info(dto.getOtaInvoice());
        return "/frontdesk/booking/ota_invoice";
    }

    @RequestMapping(value = "/1/ota_invoice", method = POST)
    public String parsOtaInvoice(OtaInvoiceDto dto) throws ParseException {
        logger.info(dto.getOtaInvoice());

        Parser parser = ParserFactory.getParser(dto.getOtaInvoice());

        Long roomId = 1L;

        BookingRequest bookingRequest = toBookingRequest(roomId, parser);

        bookingEngine.makeNewReservation(bookingRequest);

        return "/frontdesk/booking/ota_invoice";
    }


    private BookingRequest toBookingRequest(Long roomId, Parser parser) throws ParseException {
        BookingRequest bookingRequest = BookingRequest.newInstance();
        bookingRequest.roomId(roomId);
        bookingRequest.getStayInfo()
                .fromDate(parser.getCheckIn())
                .toDate(parser.getCheckOut())
                .adults(parser.getAdults())
                .kids(parser.getKids());

        bookingRequest.getGuestInfo()
                .guestName(parser.getGuest())
                .email(parser.getEmail())
                .phone(parser.getPhone());


        logger.info(bookingRequest.toString());
        return bookingRequest;
    }


    @Autowired
    public void setBookingEngine(final BookingEngine bookingEngine) {
        this.bookingEngine = bookingEngine;
    }
}
