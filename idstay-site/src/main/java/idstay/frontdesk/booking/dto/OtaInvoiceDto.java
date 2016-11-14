package idstay.frontdesk.booking.dto;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 11. 4.
 */
public class OtaInvoiceDto {
    private String otaInvoice = "";

    public String getOtaInvoice() {
        return otaInvoice;
    }

    public void setOtaInvoice(String otaInvoice) {
        this.otaInvoice = otaInvoice;
    }

    public OtaInvoiceDto(){}
    public OtaInvoiceDto(final String otaInvoice) {
        this.otaInvoice = otaInvoice;
    }
}
