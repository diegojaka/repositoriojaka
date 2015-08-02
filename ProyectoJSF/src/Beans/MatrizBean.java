package Beans;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.swing.event.ChangeEvent;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;

import co.edu.itc.entidades.Roles;
import Delegates.MatrizDg;
import Entidades.Operacion;

@ManagedBean
@SessionScoped
public class MatrizBean {

	private int tamaMatriz;
	private int indices;
	private int numPruebas;
	private int numOperaciones;
	private String tipoOperacion;
	private boolean parametros;
	private List<Operacion> listaOperaciones;
	private List<SelectItem> opracionesItem;
	// parametros
	private int param1;
	private int param2;
	private int param3;
	private int param4;
	private int param5;
	private int param6;
	private int suma;
	// matriz
	private int matriz[][][];
	private Operacion operacion;
	private MatrizDg matrizDg;

	@PostConstruct
	public void init() {
		matrizDg = new MatrizDg();
		operacion = new Operacion();
		listaOperaciones = new ArrayList<Operacion>();
		opracionesItem = new ArrayList<SelectItem>();
		
		listaOperaciones= matrizDg.cargarLista();
		for (Operacion op : listaOperaciones) {
			opracionesItem.add(new SelectItem(op.getOprId(), op.getOprDescripcion()));
		}
		
		parametros = false;
	}

	// metodo para limpiar campos
	public void limpiarCampos() {
		suma = 0;
		param1 = 0;
		param2 = 0;
		param3 = 0;
		param4 = 0;
		param5 = 0;
		param6 = 0;
		parametros = false;
	}

	// Seleccion del tipo de operacion
	public void valueChange() {
		limpiarCampos();
		System.out.println("evento " + tipoOperacion);
		if (tipoOperacion.equals("Actualizaciòn")) {
			parametros = false;
		} else {
			parametros = true;
		}
	}

	// inicializa matriz
	public String cargarMatriz() {
		indices = tamaMatriz - 1;
		matriz = new int[tamaMatriz][tamaMatriz][tamaMatriz];
		System.out.println("Tamaño matriz" + matriz.length
				+ "Numero de operaciones" + numOperaciones);
		numPruebas--;
		return "Operaciones.xhtml";
	}

	// metodo para cargar el numero de pruebas y seguir a la pagina de matrices
	public String cargaNumPruebas() {
		System.out.println("Numero de priebas" + numPruebas);
		return "Matrices.xhtml";
	}

	// metodo actualizar
	public void actualizar(int x, int y, int z, int w) {
		matriz[x][y][z] = w;
	}

	// metodo consultar
	public void consultar(int x1, int y1, int z1, int x2, int y2, int z2) {
		setSuma(0);
		for (int x = param1; x <= param4; x++) {
			for (int y = param2; y <= param5; y++) {
				for (int z = param3; z <= param6; z++) {
					setSuma(getSuma() + matriz[x][y][z]);
					System.out.println("suma  " + suma);
				}
			}
		}

	}

	// ejecitar accion
	public String accion() {
		System.out.println("tipo d eoperacion "+tipoOperacion);
		String result = null;
		if (tipoOperacion.equals("")) {
			String message = "Debe seleccionar un tipo de operaciòn";
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(message));
		} else {
			if (numPruebas == 0 && numOperaciones == 0) {
				result = "Index.xhtml";
				limpiarCampos();
			} else {
				if (numOperaciones == 0) {
					result = "Matrices.xhtml";
					limpiarCampos();
				} else {
					System.out.println("Actualiza" + param1 + " " + param2
							+ " " + param3 + " " + param4 + " " + param5 + " "
							+ param6);
					if (tipoOperacion.equals("Actualizaciòn")) {
						actualizar(param1, param2, param3, param4);
					} else {
						consultar(param1, param2, param3, param4, param5,
								param6);
					}
					numOperaciones--;
				}
			}
		}

		return result;
	}

	public int getTamaMatriz() {
		return tamaMatriz;
	}

	public void setTamaMatriz(int tamaMatriz) {
		this.tamaMatriz = tamaMatriz;
	}

	public int getNumPruebas() {
		return numPruebas;
	}

	public void setNumPruebas(int numPruebas) {
		this.numPruebas = numPruebas;
	}

	public int getNumOperaciones() {
		return numOperaciones;
	}

	public void setNumOperaciones(int numOperaciones) {
		this.numOperaciones = numOperaciones;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public boolean isParametros() {
		return parametros;
	}

	public void setParametros(boolean parametros) {
		this.parametros = parametros;
	}

	public List<Operacion> getListaOperaciones() {
		return listaOperaciones;
	}

	public void setListaOperaciones(List<Operacion> listaOperaciones) {
		this.listaOperaciones = listaOperaciones;
	}

	public int getParam1() {
		return param1;
	}

	public void setParam1(int param1) {
		this.param1 = param1;
	}

	public int getParam2() {
		return param2;
	}

	public void setParam2(int param2) {
		this.param2 = param2;
	}

	public int getParam3() {
		return param3;
	}

	public void setParam3(int param3) {
		this.param3 = param3;
	}

	public int getParam4() {
		return param4;
	}

	public void setParam4(int param4) {
		this.param4 = param4;
	}

	public int getParam5() {
		return param5;
	}

	public void setParam5(int param5) {
		this.param5 = param5;
	}

	public int getParam6() {
		return param6;
	}

	public void setParam6(int param6) {
		this.param6 = param6;
	}

	public int[][][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int matriz[][][]) {
		this.matriz = matriz;
	}

	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}

	public int getIndices() {
		return indices;
	}

	public void setIndices(int indices) {
		this.indices = indices;
	}

	public List<SelectItem> getOpracionesItem() {
		return opracionesItem;
	}

	public void setOpracionesItem(List<SelectItem> opracionesItem) {
		this.opracionesItem = opracionesItem;
	}
	
}
