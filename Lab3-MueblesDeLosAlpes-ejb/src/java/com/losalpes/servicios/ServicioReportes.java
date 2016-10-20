/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.entities.Pais;
import com.losalpes.entities.RegistroVenta;
import com.losalpes.entities.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lvalbuena
 */
@Stateless
public class ServicioReportes implements IServicioReportes{
    
    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    @EJB
    private IServicioPersistenciaMockLocal persistencia;
    
    /**
     * La entidad encargada de persistir en la base de datos
     */
    @PersistenceContext
    private EntityManager em;

    
    @Override
    public List<RegistroVenta> historialCompras(String usuario) {
        Query query = this.em.createNamedQuery("RegistroVenta.historialCompras");
        query.setParameter("nombre", usuario);
        return (List<RegistroVenta>) query.getResultList();
        
    }

    @Override
    public List<RegistroVenta> tresMueblesMasVendidos() {
        return (List<RegistroVenta>) persistencia.findAll(RegistroVenta.class);
    }

    @Override
    public List<Usuario> topCompradoresPais(Pais pais) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
