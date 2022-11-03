
package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //se definen los metodos del CRUD
    
    //Metodo que retorna la lista de categorias
    public List<Categoria> getCategorias(boolean activos);
    
    //Dado un categoria.id se busca en la tabla y se retorna todo el objeto (segundo categoria es el objeto)
    //Si el objeto categoria viene vacio entonces Categoria es vacio
    public Categoria getCategoria(Categoria categoria);
    
    //si el categoria .id tiene valor se busca y se actualiza
    // si no tiene valor inserta el objeto en la tabla
    public void save(Categoria categoria);
    
    
    //Elimina el registro
    public void delete(Categoria categoria);
    
    
}
