package Delegates;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Entidades.Operacion;
import Negocios.MatrizNegoLocal;

public class MatrizDg {
	
	MatrizNegoLocal matrizNegoLocal;
	Context context;
	
	public MatrizDg(){
		try {
			context = new InitialContext();
			matrizNegoLocal = (MatrizNegoLocal) context.lookup("java:global/ProyectoEAR/ProyectoEJB/MatrizNego!Negocios.MatrizNegoLocal");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Operacion> cargarLista() {
		return matrizNegoLocal.cargarLista();
	}

}
