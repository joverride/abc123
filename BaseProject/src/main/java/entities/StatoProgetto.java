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
 * StatoProgetto generated by hbm2java
 */
@Entity
@Table(name = "stato_progetto", catalog = "db_inv_freel")
public class StatoProgetto implements java.io.Serializable, entities.Entity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String stato;
	private Set<StoricoProgetto> storicoProgettos = new HashSet<StoricoProgetto>(0);

	public StatoProgetto() {
	}

	public StatoProgetto(String stato) {
		this.stato = stato;
	}

	public StatoProgetto(String stato, Set<StoricoProgetto> storicoProgettos) {
		this.stato = stato;
		this.storicoProgettos = storicoProgettos;
	}

	@Id

	@Column(name = "STATO", unique = true, nullable = false, length = 45)
	public String getStato() {
		return this.stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statoProgetto")
	public Set<StoricoProgetto> getStoricoProgettos() {
		return this.storicoProgettos;
	}

	public void setStoricoProgettos(Set<StoricoProgetto> storicoProgettos) {
		this.storicoProgettos = storicoProgettos;
	}

}
