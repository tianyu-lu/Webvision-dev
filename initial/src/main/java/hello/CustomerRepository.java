package hello;

import org.springframework.

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);

    List<Customer> findByLastNameStartsWithIgnoreCase(String bauer);

    List<Customer> findAll();
}
