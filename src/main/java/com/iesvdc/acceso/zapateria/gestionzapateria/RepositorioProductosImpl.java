package com.iesvdc.acceso.zapateria.gestionzapateria;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class RepositorioProductosImpl implements RepositorioProductosCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Producto> findById(String id) {        
          Query query = entityManager.createNativeQuery("SELECT * FROM zapateria.producto " +
                "WHERE id LIKE ?", Producto.class);
    		query.setParameter(1, id + "%");

        return query.getResultList();
    }

}
