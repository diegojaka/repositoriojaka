package Negocios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import Dao.MatrizDao;
import Entidades.Operacion;

/**
 * Session Bean implementation class MatrizNego
 */
@Stateless
@LocalBean
public class MatrizNego implements MatrizNegoLocal {
@EJB
MatrizDao matrizDao;
    /**
     * Default constructor. 
     */
    public MatrizNego() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Operacion> cargarLista() {
		return matrizDao.cargarLista();
	}

}
