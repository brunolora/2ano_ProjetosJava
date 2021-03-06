package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_disciplina")
@SequenceGenerator(name = "disciplina", sequenceName = "SQ_TB_DISCIPLINA", allocationSize = 1)

public class Disciplina implements Serializable {

	private static final long serialVersionUID = 2462096879806542569L;

	public Disciplina() {
		this.ativo = true;
		this.dataCriacao = LocalDateTime.now();
		this.dataAtualizada = LocalDateTime.now();
	}

	public Disciplina(String nome, int cargaHoraria) {
		this();
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina")
	private Long id;

	@Column(name = "nm_disciplina", length = 30, unique = true)
	private String nome;

	@Column(name = "nr_carga", length = 80)
	private int cargaHoraria;

	@Column(name = "st_ativo")
	private boolean ativo;

	@Column(name = "dt_cadastro")
	private LocalDateTime dataCriacao;

	@Column(name = "dt_atualizacao")
	private LocalDateTime dataAtualizada;

	public Disciplina(Long id, String nome, int cargaHoraria, boolean ativo, LocalDateTime dataCriacao,
			LocalDateTime dataAtualizada) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.ativo = ativo;
		this.dataCriacao = dataCriacao;
		this.dataAtualizada = dataAtualizada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAtualizada() {
		return dataAtualizada;
	}

	public void setDataAtualizada(LocalDateTime dataAtualizada) {
		this.dataAtualizada = dataAtualizada;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: " + getNome() + "\nCarga hor?ria: " + getCargaHoraria() + "\nDataCriacao "
				+ getDataCriacao() + "\nDataAtualizada: "
				+ getDataAtualizada();
	}

}
