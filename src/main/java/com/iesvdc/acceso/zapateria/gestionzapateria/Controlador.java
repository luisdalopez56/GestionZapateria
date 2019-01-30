/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.zapateria.gestionzapateria;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author profesor
 */
@RestController
@RequestMapping("/api")
public class Controlador {

    // Repositorios
	
    @Autowired
    RepositorioClientes repoClient;

    @Autowired
    RepositorioProductos repoProductos;

    @Autowired
    RepositorioCodPos repoCodPos;

    @Autowired
    RepositorioClienteDireccion repoClienteDireccion;
    
    @Autowired
    RepositorioProductoIdioma repoProductoIdioma;

    // Get All Clientes
    @GetMapping("/cliente")
    public List<Cliente> getAllAlumnos() {
        return repoClient.findAll();
    }
    
    @GetMapping("/cliente/nombre/{nombre}")
    public List<Cliente> getClienteByNombre(@PathVariable(value = "nombre") String nombre) {
        return repoClient.findByNombre(nombre);
    }

    @GetMapping("/cliente/apellidos/{apellidos}")
    public List<Cliente> getClienteByApellidos(@PathVariable(value = "apellidos") String apellidos) {
        return repoClient.findByApellidos(apellidos);
    }
    
    @GetMapping("/cliente/dni/{dni}")
    public List<Cliente> getClienteByDni(@PathVariable(value = "dni") int dni) {
        return repoClient.findByDni(dni);
    }

    //----------------------------------------------PRODUCTO----------------------------------------------

    // Get All Productos
    @GetMapping("/producto")
    public List<Producto> getAllProductos() {
    return repoProductos.findAll();
    }   
    
    // Get a Single Producto By id
    @GetMapping("/producto/{id}")
    public Producto getProductoById(@PathVariable(value = "id") Long productoId) {
        return repoProductos.findById(productoId)
                .orElseThrow(() -> new ResourceNotFoundException("Producto", "id", productoId));
    }
    
    // Get productos By Categoria
    @GetMapping("/producto/{categoria}")
    public List<Producto> getProductoByCategoria(@PathVariable(value = "id_categoria") String Id_categoria) {
        return repoProductos.findByCategoria(Id_categoria);
    }

    //Create new Producto
    @PostMapping(value="/producto", consumes={"application/json"})
    @ResponseBody public Producto createProducto(@Valid @RequestBody Producto producto) {
        System.out.println("\n\n\nINTENTANDO GUARDAR producto ID="+producto.getId_producto());
        return repoProductos.save(producto);
    }

    //-----------------------------------------------------------------------------------------------------

    //------------------------------------------PRODUCTO IDIOMA-----------------------------------------

    // Get All Producto_idioma
    @GetMapping("/producto_idioma")
    public List<ProductoIdioma> getProductoIdiomas() {
    return repoProductoIdioma.findAll();
    } 

    // Get a Single Producto_Id By id
    @GetMapping("/producto_idioma/{cod_idioma}")
    public ProductoIdioma getProductoIdiomaById(@PathVariable(value = "id") Long productoId) {
        return repoProductoIdioma.findById(productoId)
                .orElseThrow(() -> new ResourceNotFoundException("Producto", "id", productoId));
    }

    //Create new ProductoIdioma
    @PostMapping(value="/producto_idioma", consumes={"application/json"})
    @ResponseBody public ProductoIdioma createProductoIdioma(@Valid @RequestBody ProductoIdioma productoIdioma) {
        System.out.println("\n\n\nINTENTANDO GUARDAR productoIdioma ID="+productoIdioma.getCod_idioma());
        return repoProductoIdioma.save(productoIdioma);
    }

    //-----------------------------------------------------------------------------------------------------



    @PostMapping(value="/cliente", consumes={"application/json"})
    @ResponseBody public Cliente createCliente(@Valid @RequestBody Cliente cliente) {
        System.out.println("\n\n\nINTENTANDO GUARDAR CLIENTE DNI="+cliente.getDni());
        return repoClient.save(cliente);
    }
    
    
    // UPDATE CLIENTE
    @PutMapping(value="/cliente/{id}", consumes={"application/json"})
    @ResponseBody public Cliente updateCliente(
    			@PathVariable(value = "id") Long clienteId, 
    			@Valid @RequestBody Cliente cliente) {
        // System.out.println("\n\n\nINTENTANDO ACTUALIZAR CLIENTE DNI="+cliente.getDni());
        Cliente new_cli = repoClient.findById(clienteId).orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", clienteId));
        new_cli.setApellidos(cliente.getApellidos());
        new_cli.setNombre(cliente.getNombre());
        new_cli.setDni(cliente.getDni());
        //new_cli.setClienteDireccionList(cliente.getClienteDireccionList());
        return repoClient.save(new_cli);
    }

    // DELETE CLIENTE
    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable(value = "id") Long clienteId) {
        Cliente cliente = repoClient.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", clienteId));

        repoClient.delete(cliente);

        return ResponseEntity.ok().build();
    }

    // Get All CodPos
    @GetMapping("/codpos")
    public List<CodPos> getAllCodPos() {
        return repoCodPos.findAll();
    }
    
    @PostMapping(value="/codpos", consumes={"application/json"})
    @ResponseBody public CodPos createCodPos(@Valid @RequestBody CodPos codpos) {
        System.out.println("\n\n\nINTENTANDO GUARDAR CODPOS CP="+codpos.getCp());
        return repoCodPos.save(codpos);
    }
/*
    @DeleteMapping("/codpos/{cp}")
    public ResponseEntity<?> deleteCodPos(@PathVariable(value = "cp") Long cp) {
        CodPos codpos = repoCodPos.findById(cp)
                .orElseThrow(() -> new ResourceNotFoundException("CodPos", "cp", cp));

        repoCodPos.delete(codpos);

        return ResponseEntity.ok().build();
    }
*/
    
    /*
    // Get All ClienteDireccion
    @GetMapping("/cliente/direccion")
    public List<ClienteDireccion> getAllClienteDireccion() {
        return repoClienteDireccion.findAll();
    }*/
    
    // Get All ClienteDireccion
    @GetMapping("/cliente/{idCli}/direccion")
    public List<ClienteDireccion> getClienteDireccionByCliente(@PathVariable(value = "idCli") Long idCli) {
    	Cliente cliente = repoClient.findById(idCli).get();
        return cliente.getClienteDireccionList();
    }



    
    @PostMapping(
    			value="/cliente/{idCli}/direccion", 
    			consumes={"application/json"})
    @ResponseBody List<ClienteDireccion> postClienteDireccion(
    		@PathVariable(value = "idCli") Long idCli,
    		@Valid @RequestBody ClienteDireccion cli_dir){
    	Cliente cli = repoClient.findById(idCli).orElseThrow(() 
    			-> new ResourceNotFoundException("Cliente", "id", idCli));
    	cli_dir.setIdCliente(cli);
    	repoClienteDireccion.save(cli_dir);
    	return cli.getClienteDireccionList();
    }
    
    @DeleteMapping(
			value="/cliente/{idCli}/direccion/{idDirCli}")
    @ResponseBody List<ClienteDireccion> deleteClienteDireccion(
	@PathVariable(value = "idCli") Long idCli,
	@PathVariable(value = "idDirCli") Long idDirCli){
    		
	ClienteDireccion cli_dir = repoClienteDireccion.findById(idDirCli).orElseThrow(() 
			-> new ResourceNotFoundException("ClienteDireccion", "idDirCli", idDirCli));;
	
	repoClienteDireccion.delete(cli_dir);
	
	Cliente cli = repoClient.findById(idCli).orElseThrow(() 
			-> new ResourceNotFoundException("Cliente", "id", idCli));
	
    return cli.getClienteDireccionList();
    
    
}
    

    /*
    @DeleteMapping("/codpos/{cp}")
    public ResponseEntity<?> deleteCodPos2(@PathVariable(value = "cp") Long cp) {
        CodPos codpos = repoCodPos.findById(cp)
                .orElseThrow(() -> new ResourceNotFoundException("CodPos", "cp", cp));

        repoCodPos.delete(codpos);

        return ResponseEntity.ok().build();
    }
	*/

    /*
    // Get All Notes
    @GetMapping("/cliente/{id}")
    public List<ClienteDireccion> getDireccions(Long id) {
        return repoClient.();
    }
     */
}
