package br.com.fiap.jpa.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class HibernateGenericDao<T extends Serializable, PK extends	 Serializable> implements GenericDao<T, PK>{

	private Class<T> type;
	
	public HibernateGenericDao(Class<T> type) {
		this.type = type;
	}
	
	
	
	public void inserir(T instancia, EntityManager entityManager) {
		entityManager.persist(instancia);
	}

	public void atualizar(T instancia, EntityManager entityManager) {
		entityManager.merge(instancia);
	}

	public void remover(PK id, EntityManager entityManager) {
		T instancia = obterPorId(id, entityManager);
		entityManager.remove(instancia);
	}

	public T obterPorId(PK id, EntityManager entityManager) {
		return entityManager.find(type, id);
	}

	public List<T> listar(EntityManager entityManager) {
		Query consulta = entityManager.createQuery("SELECT o FROM" + type.getName() + " o");
		return consulta.getResultList();
	} 
	
}
