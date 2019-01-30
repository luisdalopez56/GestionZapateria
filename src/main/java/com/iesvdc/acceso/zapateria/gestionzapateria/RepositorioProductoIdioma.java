/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.zapateria.gestionzapateria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luisda
 */
@Repository
public interface RepositorioProductoIdioma extends JpaRepository<ProductoIdioma, Long> {

	List<ProductoIdioma> findAll();
	List<ProductoIdioma> findById(@Param("cod_idioma") String cod_idioma);
 
}
