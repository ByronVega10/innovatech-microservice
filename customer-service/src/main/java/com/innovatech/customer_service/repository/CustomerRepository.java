package com.innovatech.customer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.innovatech.customer_service.model.Customer;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

    List<Customer> findByApellido(String apellido);

    Customer findByCorreo(String correo);

    List<Customer> findByNombreAndApellido(String nombre, String apellido);
    

}
