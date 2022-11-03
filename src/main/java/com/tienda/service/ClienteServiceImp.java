package com.tienda.service;

import com.tienda.dao.ClienteDao;
import com.tienda.dao.CreditoDao;
import com.tienda.domain.Cliente;
import com.tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ClienteServiceImp implements ClienteService {
    //se definen los metodos del CRUD

    //se utiliza una anotacion autowired para que el objeto ClienteDao
    //si ya esta en memoria se use, si no se crea(singleton)
    @Autowired
    private ClienteDao clienteDao;
     @Autowired
    private CreditoDao creditoDao;

    //Metodo que retorna la lista de clientes
    @Override
    @Transactional(readOnly=true)
    
    public List<Cliente> getClientes() {
        return (List<Cliente>)clienteDao.findAll();
    }

    //Dado un cliente.id se busca en la tabla y se retorna todo el objeto (segundo cliente es el objeto)
    //Si el objeto cliente viene vacio entonces Cliente es vacio
    
    @Override
    @Transactional(readOnly=true)
    public Cliente getCliente(Cliente cliente){
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    //si el cliente .id tiene valor se busca y se actualiza
    // si no tiene valor inserta el objeto en la tabla
    @Override
    @Transactional
    public void save(Cliente cliente){
        Credito credito = cliente.getCredito();
        credito=creditoDao.save(credito);
        cliente.setCredito(credito);
        
        clienteDao.save(cliente);
    }

    //Elimina el registro
    @Override
    @Transactional
    public void delete(Cliente cliente){
        clienteDao.delete(cliente);
    }

}
