package br.eximia.erm.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.eximia.springutils.data.domain.AbstractGenericEntity;

@Entity
@AttributeOverride(name="id", column=@Column(name="IDREGRA"))
@Table(name = "REGRAS")
public class Regra extends AbstractGenericEntity<Regra, Long> {
	
	private static final long serialVersionUID = 1L;
	
    @Basic(optional = false)
    @Column(name = "REGRA")
    private String regra;
    @ManyToMany(mappedBy="regras", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Usuario> usuarios;

    public Regra() {
    }

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
    public String toString() {
        return this.getRegra();
    }

	@Override
	public int compareTo(Regra o) {
		return this.getRegra().compareTo(o.getRegra());
	}

}
