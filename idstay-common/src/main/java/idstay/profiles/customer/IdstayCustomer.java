package idstay.profiles.customer;

import javax.persistence.*;

@Entity
@Table(name="idstay_customer")
public class IdstayCustomer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="customer_id")
    private long id;
    private String email;
    private String name;

    protected IdstayCustomer() {}
    public IdstayCustomer(final String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

