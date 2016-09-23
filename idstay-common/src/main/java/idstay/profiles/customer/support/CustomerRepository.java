package idstay.profiles.customer.support;

import idstay.profiles.customer.IdstayCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<IdstayCustomer, Long>{
}
