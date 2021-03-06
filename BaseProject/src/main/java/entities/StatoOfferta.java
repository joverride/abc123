package entities;
// Generated Apr 25, 2018 3:42:43 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * StatoOfferta generated by hbm2java
 */
@Entity
@Table(name = "stato_offerta", catalog = "db_inv_freel")
public class StatoOfferta implements java.io.Serializable, entities.Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String stato;
	private Set<Offerta> offertas = new HashSet<Offerta>(0);

	public StatoOfferta() {
	}

	public StatoOfferta(String stato) {
		this.stato = stato;
	}

	public StatoOfferta(String stato, Set<Offerta> offertas) {
		this.stato = stato;
		this.offertas = offertas;
	}

	@Id

	@Column(name = "STATO", unique = true, nullable = false, length = 45)
	public String getStato() {
		return this.stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statoOfferta")
	public Set<Offerta> getOffertas() {
		return this.offertas;
	}

	public void setOffertas(Set<Offerta> offertas) {
		this.offertas = offertas;
	}

}
