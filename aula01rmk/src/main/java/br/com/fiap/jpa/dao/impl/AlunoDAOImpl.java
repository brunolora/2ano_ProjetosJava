package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.dao.HibernateGenericDao;
import br.com.fiap.jpa.entity.Aluno;

public class AlunoDAOImpl extends HibernateGenericDao<Aluno, Long> {
	
	public AlunoDAOImpl() {
		super(Aluno.class);
	}

	private static AlunoDAOImpl instance;
	
	public static AlunoDAOImpl getInstance() {
		if (instance == null) {
			instance = new AlunoDAOImpl();
		}
		return instance;
	}

}
