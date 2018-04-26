package entities;
// Generated Apr 25, 2018 3:42:43 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tag generated by hbm2java
 */
@Entity
@Table(name = "tag", catalog = "db_inv_freel")
public class Tag implements java.io.Serializable {

	private String nome;
	private Set<UtenteTag> utenteTags = new HashSet<UtenteTag>(0);
	private Set<Categoria> categorias = new HashSet<Categoria>(0);

	public Tag() {
	}

	public Tag(String nome) {
		this.nome = nome;
	}

	public Tag(String nome, Set<UtenteTag> utenteTags, Set<Categoria> categorias) {
		this.nome = nome;
		this.utenteTags = utenteTags;
		this.categorias = categorias;
	}

	@Id

	@Column(name = "NOME", unique = true, nullable = false, length = 45)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
	public Set<UtenteTag> getUtenteTags() {
		return this.utenteTags;
	}

	public void setUtenteTags(Set<UtenteTag> utenteTags) {
		this.utenteTags = utenteTags;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tag_categoria", catalog = "db_inv_freel", joinColumns = {
			@JoinColumn(name = "TAG", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ROW_ID_CATEGORIA", nullable = false, updatable = false) })
	public Set<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

}
