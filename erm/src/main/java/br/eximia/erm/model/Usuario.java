package br.eximia.erm.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.eximia.springutils.data.domain.AbstractGenericEntity;

@Entity
@AttributeOverride(name="id", column=@Column(name="IDUSUARIO"))
@Table(name = "USUARIOS")
public class Usuario extends AbstractGenericEntity<Usuario, Long> {

	private static final long serialVersionUID = 1L;
	
    @Basic(optional = false)
    @Column(name = "USUARIO")
    @Size(max=20, message="{usuario.usuario.size}")
    @NotNull(message="{usuario.usuario.notNull}")
    @Pattern(regexp="^\\s*\\S.*$", message="{usuario.usuario.notEmpty}")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "SENHA")
    @NotNull(message="{usuario.senha.notNull}")
    @Pattern(regexp="^\\s*\\S.*$", message="{usuario.senha.notEmpty}")
    private String senha;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private Boolean status;
    @ManyToMany(cascade=CascadeType.DETACH)
    @JoinTable(name = "USUARIOS_REGRAS", joinColumns = {@JoinColumn(name="USUARIO")}, inverseJoinColumns = {@JoinColumn(name="REGRA")})
    private List<Regra> regras;

    public Usuario() {
    	this.senha = this.getRandomPassowrd();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Boolean getStatus() {
		return status;
	}
	
	public String getLabeledStatus() {
		return status ? this.getMessages().getMessage("boolean.true") : this.getMessages().getMessage("boolean.false");
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
    public String toString() {
        return this.getUsuario();
    }

	public int compareTo(Usuario o) {
		return this.getUsuario().compareTo(o.getUsuario());
	}

	public List<Regra> getRegras() {
		return regras;
	}

	public void setRegras(List<Regra> regras) {
		this.regras = regras;
	}
	
	private String getRandomPassowrd(){
		return UUID.randomUUID().toString().substring(0, 8);
	}
	
}
