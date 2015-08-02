package Negocios;

import java.util.List;

import javax.ejb.Local;

import Entidades.Operacion;

@Local
public interface MatrizNegoLocal {

	List<Operacion> cargarLista();

}
