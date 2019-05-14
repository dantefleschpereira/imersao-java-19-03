package br.com.targettrust.traccadastros.entidades;

import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;

@Entity
@Table(name="tb_locacao")
@AttributeOverrides({
	@AttributeOverride(name="versao", column=@Column(name="loc_versao"))
})
public class Locacao extends Entidade{
	
	@ManyToOne
	@JoinColumn(name="id_veiculo")
	private Veiculo veiculo;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="id_funcionario")
	private Funcionario funcionario;
	
	@Column(name="dt_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	@FutureOrPresent
	private Date dataInicial;
	
	@Column(name="dt_fim")
	@Temporal(TemporalType.TIMESTAMP)
	@Future
	private Date dataFinal;
	
	@Column(name="vlr_pago")
	private Double valor;

	@ManyToMany
	@JoinTable(name = "rl_locacao_equipamento", 
		inverseJoinColumns = {@JoinColumn(name = "id_equipamento", referencedColumnName = "id") }, 
		joinColumns = {@JoinColumn(name = "id_locacao", referencedColumnName = "id") } )
	private Set<Equipamento> equipamentos;

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
