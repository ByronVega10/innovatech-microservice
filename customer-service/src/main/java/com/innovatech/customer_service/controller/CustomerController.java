package com.innovatech.customer_service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.innovatech.customer_service.model.Customer;
import com.innovatech.customer_service.service.CustomerService;

@RestController
@RequestMapping("/api/clientes")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> listarCliente(){
        List<Customer> customers = customerService.findAll();
        if (customers.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers); 
    }

    @PostMapping
    public ResponseEntity<Customer> guardarCliente(@RequestBody Customer cliente){
        Customer  newCustomer = customerService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Customer> buscarCliente(@PathVariable Integer id){
        try{
            Customer customer = customerService.findbyId(id);
            return ResponseEntity.ok(customer);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> actualizarCliente(@PathVariable Integer id, @RequestBody Customer customer){
        try {
            Customer cust = customerService.findbyId(id);
            cust.setId(id);
            cust.setRun(customer.getRun());
            cust.setNombre(customer.getNombre());
            cust.setApellido(customer.getApellido());
            cust.setCorreo(customer.getCorreo());
            cust.setFechaNacimiento(customer.getFechaNacimiento());

            customerService.save(cust);
            return ResponseEntity.ok(customer);
            
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Long id){
        try {
            customerService.delet(id);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
}
