package com.examen.spring.batch.config;

import org.springframework.batch.item.ItemProcessor;

import com.examen.spring.batch.entity.Cliente;

public class ClienteProcessor implements ItemProcessor<Cliente,Cliente> {

    @Override
    public Cliente process(Cliente cliente) throws Exception {
        //if(customer.getCountry().equals("China")) {
          //  return customer;
        //}
        return cliente;
        
    }
}
