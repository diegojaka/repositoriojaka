package Entidades;
// default package
// Generated 01-ago-2015 14:29:53 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Matriz generated by hbm2java
 */
@Entity
@Table(name = "matriz", schema = "public")
public class Matriz implements java.io.Serializable {

	private int mtrId;
	private int mtrTamaņo;
	private Date mtrFechaCreacion;
	private Set<OperacionMatriz> operacionMatrizs = new HashSet<OperacionMatriz>(
			0);

	public Matriz() {
	}

	public Matriz(int mtrId, int mtrTamaņo) {
		this.mtrId = mtrId;
		this.mtrTamaņo = mtrTamaņo;
	}

	public Matriz(int mtrId, int mtrTamaņo, Date mtrFechaCreacion,
			Set<OperacionMatriz> operacionMatrizs) {
		this.mtrId = mtrId;
		this.mtrTamaņo = mtrTamaņo;
		this.mtrFechaCreacion = mtrFechaCreacion;
		this.operacionMatrizs = operacionMatrizs;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqmatrices")
	@SequenceGenerator(name = "seqmatrices", sequenceName = "matriz_mtr_id_seq", allocationSize =1)
	@Column(name = "mtr_id", unique = true, nullable = false)
	public int getMtrId() {
		return this.mtrId;
	}

	public void setMtrId(int mtrId) {
		this.mtrId = mtrId;
	}

	@Column(name = "mtr_tamaņo", nullable = false)
	public int getMtrTamaņo() {
		return this.mtrTamaņo;
	}

	public void setMtrTamaņo(int mtrTamaņo) {
		this.mtrTamaņo = mtrTamaņo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "mtr_fecha_creacion", length = 29, insertable = false, updatable =false, columnDefinition = "timestamp default now()")
	public Date getMtrFechaCreacion() {
		return this.mtrFechaCreacion;
	}

	public void setMtrFechaCreacion(Date mtrFechaCreacion) {
		this.mtrFechaCreacion = mtrFechaCreacion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "matriz")
	public Set<OperacionMatriz> getOperacionMatrizs() {
		return this.operacionMatrizs;
	}

	public void setOperacionMatrizs(Set<OperacionMatriz> operacionMatrizs) {
		this.operacionMatrizs = operacionMatrizs;
	}

}
