package entities;
// Generated Apr 25, 2018 3:42:43 PM by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ElementoFattura generated by hbm2java
 */
@Entity
@Table(name = "elemento_fattura", catalog = "db_inv_freel")
public class ElementoFattura implements java.io.Serializable, entities.Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer rowId;
	private Fattura fattura;
	private Iva iva;
	private String descrizione;
	private float quantita;
	private int prezzo;

	public ElementoFattura() {
	}

	public ElementoFattura(Fattura fattura, Iva iva, String descrizione, float quantita, int prezzo) {
		this.fattura = fattura;
		this.iva = iva;
		this.descrizione = descrizione;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ROW_ID", unique = true, nullable = false)
	public Integer getRowId() {
		return this.rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROW_ID_FATTURA", nullable = false)
	public Fattura getFattura() {
		return this.fattura;
	}

	public void setFattura(Fattura fattura) {
		this.fattura = fattura;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IVA", nullable = false)
	public Iva getIva() {
		return this.iva;
	}

	public void setIva(Iva iva) {
		this.iva = iva;
	}

	@Column(name = "DESCRIZIONE", nullable = false, length = 250)
	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Column(name = "QUANTITA", nullable = false, precision = 12, scale = 0)
	public float getQuantita() {
		return this.quantita;
	}

	public void setQuantita(float quantita) {
		this.quantita = quantita;
	}

	@Column(name = "PREZZO", nullable = false)
	public int getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

}
