package idstay.frontdesk.booking.parser;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 11. 5.
 */
public class ParserFactory {
    private static final String EXPEDIA_CHECKER = "Expedia";

    public static Parser getParser(final String otaInvoice) {
        if (otaInvoice.contains(EXPEDIA_CHECKER)) {
            return new ExpedaParser(otaInvoice);
        } else {
            return null;
        }
    }
}
