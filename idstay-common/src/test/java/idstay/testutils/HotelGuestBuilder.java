package idstay.testutils;

import idstay.profiles.hotelguest.HotelGuest;

public class HotelGuestBuilder {
    private Long id;
    private String firstName;
    private String lastName;
    private String guestName;
    private String email;

    public HotelGuestBuilder() {
        firstName = "minsoo";
        lastName = "KIM";
        guestName = "KIM minsoo";
    }

    public static HotelGuestBuilder hotelGuest(){
        return new HotelGuestBuilder();
    }

    public HotelGuestBuilder id(Long id){
        this.id = id;
        return this;
    }

    public HotelGuestBuilder firstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public HotelGuestBuilder lastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public HotelGuestBuilder email(String email){
        this.email = email;
        return this;
    }

    public HotelGuest build(){
        HotelGuest hotelGuest = new HotelGuest(guestName);
        hotelGuest.setEmail(email);
        hotelGuest.setFirstName(firstName);
        hotelGuest.setLastName(lastName);

        return hotelGuest;
    }

}
