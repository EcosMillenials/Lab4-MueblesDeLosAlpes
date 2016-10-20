


package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.entities.Pais;
import com.losalpes.entities.RegistroVenta;
import com.losalpes.entities.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 * Contrato funcional de los servicios de reportes
 * 
 */
@Local
public interface IServicioReportes
{
    

    /**
     * retorna el historial de compras para un usuario dado
     * @param usuario
     * @return 
     */
    public List<RegistroVenta> historialCompras(String usuario);
    
    /**
     * Mostrar los tres (3) muebles más vendidos
     * @return 
     */
    public List<RegistroVenta> tresMueblesMasVendidos();
    
    /**
     * retornaa el top de los compradores para el pais dado
     * @param pais
     * @return 
     */
    public List<Usuario> topCompradoresPais(Pais pais);

    

}
