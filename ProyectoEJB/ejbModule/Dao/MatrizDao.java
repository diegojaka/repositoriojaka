package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entidades.Operacion;
@Stateless
@LocalBean
public class MatrizDao {
	@PersistenceContext(unitName = "PruebaPU")
	EntityManager entityManager;

	public List<Operacion> cargarLista() {
		List<Operacion> listaOpera = new ArrayList<Operacion>();
		try {
			Query query = entityManager.createQuery("SELECT r FROM Operacion r");
			listaOpera = (List<Operacion>) query.getResultList();
		} catch (Exception e) {
		  
		}
		return listaOpera;
	}

}
