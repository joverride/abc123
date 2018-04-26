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
 * TipologiaUtente generated by hbm2java
 */
@Entity
@Table(name = "tipologia_utente", catalog = "db_inv_freel")
public class TipologiaUtente implements java.io.Serializable, entities.Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipologia;
	private Set<Utente> utentes = new HashSet<Utente>(0);

	public TipologiaUtente() {
	}

	public TipologiaUtente(String tipologia) {
		this.tipologia = tipologia;
	}

	public TipologiaUtente(String tipologia, Set<Utente> utentes) {
		this.tipologia = tipologia;
		this.utentes = utentes;
	}

	@Id

	@Column(name = "TIPOLOGIA", unique = true, nullable = false, length = 45)
	public String getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipologiaUtente")
	public Set<Utente> getUtentes() {
		return this.utentes;
	}

	public void setUtentes(Set<Utente> utentes) {
		this.utentes = utentes;
	}

}
