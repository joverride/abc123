package entities;
// Generated Apr 25, 2018 3:42:43 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AnnuncioProgetto generated by hbm2java
 */
@Entity
@Table(name = "annuncio_progetto", catalog = "db_inv_freel")
public class AnnuncioProgetto implements java.io.Serializable, entities.Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer rowId;
	private Progetto progetto;
	private Date dataPubblicazione;
	private Date dataScadenza;
	private Set<Offerta> offertas = new HashSet<Offerta>(0);

	public AnnuncioProgetto() {
	}

	public AnnuncioProgetto(Progetto progetto, Date dataPubblicazione, Date dataScadenza) {
		this.progetto = progetto;
		this.dataPubblicazione = dataPubblicazione;
		this.dataScadenza = dataScadenza;
	}

	public AnnuncioProgetto(Progetto progetto, Date dataPubblicazione, Date dataScadenza, Set<Offerta> offertas) {
		this.progetto = progetto;
		this.dataPubblicazione = dataPubblicazione;
		this.dataScadenza = dataScadenza;
		this.offertas = offertas;
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
	@JoinColumn(name = "ID_PROGETTO", nullable = false)
	public Progetto getProgetto() {
		return this.progetto;
	}

	public void setProgetto(Progetto progetto) {
		this.progetto = progetto;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_PUBBLICAZIONE", nullable = false, length = 19)
	public Date getDataPubblicazione() {
		return this.dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_SCADENZA", nullable = false, length = 19)
	public Date getDataScadenza() {
		return this.dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "annuncioProgetto")
	public Set<Offerta> getOffertas() {
		return this.offertas;
	}

	public void setOffertas(Set<Offerta> offertas) {
		this.offertas = offertas;
	}

}
