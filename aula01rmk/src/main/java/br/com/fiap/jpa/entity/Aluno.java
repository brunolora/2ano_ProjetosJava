package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ALUNO")
@SequenceGenerator(name = "aluno", sequenceName = "SQ_TB_ALUNO", allocationSize = 1)
public class Aluno implements Serializable{
	
	private static final long serialVersionUID = -1168728566335624386L;
	
	public Aluno() {
		this.ativo = true;
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}
	
	public Aluno(String nome, String matricula, String cpf, LocalDate dataNascimento) {
		this();
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno")
	public Long id;

	@Column(name = "nm_aluno", length = 80)
	public String nome;

	@Column(name = "nr_matricula", length = 10, unique = true)
	public String matricula;

	@Column(name = "nr_cpf", length = 14, unique = true)
	public String cpf;

	@Column(name = "dt_nascimemto", nullable = false)
	public LocalDate dataNascimento;

	@Column(name = "st_ativo")
	public boolean ativo;

	@Column(name = "dt_cadastro")
	public LocalDateTime dataCadastro;

	@Column(name = "dt_atualizacao")
	public LocalDateTime dataAtualizacao;

	public Aluno(String nome, String matricula, String cpf, Long id, LocalDate dataNascimento, boolean ativo,
			LocalDateTime dataCadastro, LocalDateTime dataAtualizacao) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
		this.id = id;
		this.dataNascimento = dataNascimento;
		this.ativo = ativo;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Matricula: " + getMatricula() + "\nNome: " + getNome() + "\nCPF " + getCpf() + "\nNascimento "
				+ getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\nDataCadastro "
				+ getDataCadastro() + "\nDataAtualizacao " + getDataAtualizacao();
	}

}