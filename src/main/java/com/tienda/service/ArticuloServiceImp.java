package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ArticuloServiceImp implements ArticuloService {
    //se definen los metodos del CRUD

    //se utiliza una anotacion autowired para que el objeto ArticuloDao
    //si ya esta en memoria se use, si no se crea(singleton)
    @Autowired
    private ArticuloDao articuloDao;

    //Metodo que retorna la lista de articulos
    @Override
    @Transactional(readOnly=true)
    
    public List<Articulo> getArticulos(boolean activos) {
       var lista = (List<Articulo>)articuloDao.findAll();
        
        if (activos)  {
            lista.removeIf(e -> !e.isActivo());
        } 
      return lista;  
     
        
    }

    //Dado un articulo.id se busca en la tabla y se retorna todo el objeto (segundo articulo es el objeto)
    //Si el objeto articulo viene vacio entonces Articulo es vacio
    
    @Override
    @Transactional(readOnly=true)
    public Articulo getArticulo(Articulo articulo){
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    //si el articulo .id tiene valor se busca y se actualiza
    // si no tiene valor inserta el objeto en la tabla
    @Override
    @Transactional
    public void save(Articulo articulo){
        articuloDao.save(articulo);
    }

    //Elimina el registro
    @Override
    @Transactional
    public void delete(Articulo articulo){
        articuloDao.delete(articulo);
    }

}
