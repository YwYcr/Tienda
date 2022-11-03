
package com.tienda.service;

import com.tienda.domain.Cliente;
import java.util.List;

public interface ClienteService {
    //se definen los metodos del CRUD
    
    //Metodo que retorna la lista de clientes
    public List<Cliente> getClientes();
    
    //Dado un cliente.id se busca en la tabla y se retorna todo el objeto (segundo cliente es el objeto)
    //Si el objeto cliente viene vacio entonces Cliente es vacio
    public Cliente getCliente(Cliente cliente);
    
    //si el cliente .id tiene valor se busca y se actualiza
    // si no tiene valor inserta el objeto en la tabla
    public void save(Cliente cliente);
    
    
    //Elimina el registro
    public void delete(Cliente cliente);
    
    
}
