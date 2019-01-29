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
public interface RepositorioProductos extends JpaRepository<Producto, Long> {

	// Con un repo custom
	List<Producto> findById(String id);
	// Con namedQueries
	List<Producto> findByCategoria(@Param("categoria") String categoria);
 
}
