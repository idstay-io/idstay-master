package idstay.customer;

import javax.persistence.*;

@Entity
public class Customer {
    @Ids
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="customer_id")
    private long id;
    private String email;
    private String name;

    protected Customer() {}
    public Customer(final String email) {
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

