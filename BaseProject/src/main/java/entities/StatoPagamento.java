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
 * StatoPagamento generated by hbm2java
 */
@Entity
@Table(name = "stato_pagamento", catalog = "db_inv_freel")
public class StatoPagamento implements java.io.Serializable {

	private String stato;
	private Set<StoricoPagamento> storicoPagamentos = new HashSet<StoricoPagamento>(0);

	public StatoPagamento() {
	}

	public StatoPagamento(String stato) {
		this.stato = stato;
	}

	public StatoPagamento(String stato, Set<StoricoPagamento> storicoPagamentos) {
		this.stato = stato;
		this.storicoPagamentos = storicoPagamentos;
	}

	@Id

	@Column(name = "STATO", unique = true, nullable = false, length = 45)
	public String getStato() {
		return this.stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statoPagamento")
	public Set<StoricoPagamento> getStoricoPagamentos() {
		return this.storicoPagamentos;
	}

	public void setStoricoPagamentos(Set<StoricoPagamento> storicoPagamentos) {
		this.storicoPagamentos = storicoPagamentos;
	}

}
