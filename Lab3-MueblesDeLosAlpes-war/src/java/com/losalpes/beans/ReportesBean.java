/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.entities.RegistroVenta;
import com.losalpes.entities.Usuario;
import com.losalpes.servicios.IServicioRegistroMockLocal;
import com.losalpes.servicios.IServicioReportes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author lvalbuena
 */
@ManagedBean
@ViewScoped
public class ReportesBean implements Serializable {
    
    /**
     * servicio de reportes
     */
    @EJB
    private IServicioReportes servicioReportes;
    
    @EJB
    private IServicioRegistroMockLocal registroMockLocal;
    
    /**
     * informacion del reporte de ventas
     */
    private List<RegistroVenta> reporteVentas;
    
    /**
     * lista de muebles mas vendidos
     */
    private List<RegistroVenta> mueblesVendidos;

    
    
    /**
     * 
     */
    private List<Usuario> listaUsuarios;
    
    /**
     * 
     */
    private String usuarioFiltro;

    

    

    
    
    /**
     * Constructor
     */
    public ReportesBean() {
        
    }
    
    /**
     * 
     */
    @PostConstruct
    public void init() {
        listaUsuarios = registroMockLocal.darClientes();
        mueblesVendidos = servicioReportes.tresMueblesMasVendidos();
        
        
    }
    
    /**
     * genera el reporte
     */
    public void consultar() {
        reporteVentas = servicioReportes.historialCompras(usuarioFiltro);
        
    }
    
    public List<RegistroVenta> getReporteVentas() {
        return reporteVentas;
    }

    public void setReporteVentas(List<RegistroVenta> reporteVentas) {
        this.reporteVentas = reporteVentas;
    }
    
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public String getUsuarioFiltro() {
        return usuarioFiltro;
    }

    public void setUsuarioFiltro(String usuarioFiltro) {
        this.usuarioFiltro = usuarioFiltro;
    }
    
    public List<RegistroVenta> getMueblesVendidos() {
        return mueblesVendidos;
    }

    public void setMueblesVendidos(List<RegistroVenta> mueblesVendidos) {
        this.mueblesVendidos = mueblesVendidos;
    }
    
}
