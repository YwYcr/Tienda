
package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;

public interface ArticuloService {
    //se definen los metodos del CRUD
    
    //Metodo que retorna la lista de articulos
    public List<Articulo> getArticulos(boolean activos);
    
    //Dado un articulo.id se busca en la tabla y se retorna todo el objeto (segundo articulo es el objeto)
    //Si el objeto articulo viene vacio entonces Articulo es vacio
    public Articulo getArticulo(Articulo articulo);
    
    //si el articulo .id tiene valor se busca y se actualiza
    // si no tiene valor inserta el objeto en la tabla
    public void save(Articulo articulo);
    
    
    //Elimina el registro
    public void delete(Articulo articulo);
    
    
}
