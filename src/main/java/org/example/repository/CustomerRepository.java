package org.example.repository;

import org.example.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("select c from Customer c where c.name like :keyword or " +
            "c.email like :keyword or c.address like :keyword")
    List<Customer> findCustomerByKeyword(@Param("keyword") String keyword);
}
