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
public class RepositorioProductoIdiomaImpl implements RepositorioProductoIdiomaCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ProductoIdioma> findAll() {
        Query query = entityManager.createNativeQuery("SELECT * FROM zapateria.producto_idioma ", ProductoIdioma.class);

        return query.getResultList();
    }

    @Override
    public List<ProductoIdioma> findById(String cod_idioma) {
        Query query = entityManager.createNativeQuery("SELECT * FROM zapateria.producto_idioma " +
                "WHERE cod_idioma LIKE ?", ProductoIdioma.class);
    		query.setParameter(1, cod_idioma + "%");

        return query.getResultList();
    }

}