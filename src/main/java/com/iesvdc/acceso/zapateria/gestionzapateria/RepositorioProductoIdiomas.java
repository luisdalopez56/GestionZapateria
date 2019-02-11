package com.iesvdc.acceso.zapateria.gestionzapateria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProductoIdiomas extends JpaRepository<ProductoIdioma, Long> {

}
