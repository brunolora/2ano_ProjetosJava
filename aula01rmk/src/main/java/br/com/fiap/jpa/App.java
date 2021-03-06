package br.com.fiap.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.internal.build.AllowSysOut;

import br.com.fiap.jpa.dao.impl.AlunoDAOImpl;
import br.com.fiap.jpa.dao.impl.DisciplinaDAOImpl;
import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.entity.Disciplina;

public class App {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FIAP_PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
//		AlunoDAOImpl dao = AlunoDAOImpl.getInstance();
//		
//		Aluno aluno1 = new Aluno
//				("Aluno 1", "111111", "111.111.111-11", LocalDate.of(1980, 1, 1));		
//		Aluno aluno2 = new Aluno
//				("Aluno 2", "222222", "222.222.222-22", LocalDate.of(19990, 2, 2)); 
//		Aluno aluno3 = new Aluno
//				("Aluno 3", "333333", "333.333.333-33", LocalDate.of(2000, 3, 3));
//		
//		dao.inserir(aluno1, entityManager);
//		dao.inserir(aluno2, entityManager);
//		dao.inserir(aluno3, entityManager);
//		
//		entityManager.persist(aluno1); // Estado Managed
//		entityManager.persist(aluno2); // Estado Managed
//		entityManager.persist(aluno3); // Estado Managed
		
		DisciplinaDAOImpl dao1 = DisciplinaDAOImpl.getInstance();
		
		Disciplina disciplina1 = new Disciplina("Disciplina 1", 360);
		Disciplina disciplina2 = new Disciplina("Disciplina 2", 80);
		Disciplina disciplina3 = new Disciplina("Disciplina 3", 120);
		
		dao1.inserir(disciplina1, entityManager);
		dao1.inserir(disciplina2, entityManager);
		dao1.inserir(disciplina3, entityManager);
		
		disciplina1.setCargaHoraria(100);
		disciplina1.setDataAtualizada(LocalDateTime.now());
		
		dao1.atualizar(disciplina1, entityManager);
		
		List<Disciplina> disciplinas = dao1.listar(entityManager);
		
		disciplinas.forEach(System.out::println);
		
		entityManager.getTransaction().commit();
		
		
		//Buscando no banco o aluno que tenha id = 3
//		Aluno aluno = entityManager.find(Aluno.class, 3L);
//
//		//Se o aluno for encontrado, atualiza seus dados
//		if (aluno != null) {
//			aluno.setNome("Novo nome do aluno");
//			aluno.setDataAtualizacao(LocalDateTime.now());
//		}
//		
//		//Query para consultar todos os registros da tabela tb_aluno
//		Query query = entityManager.createQuery("SELECT a FROM Aluno a");
//		List<Aluno> resultado = query.getResultList();
//		
//		Aluno maisNovo = null;
//		
//		//Imprimindo o resultado e identificando o aluno mais novo
//		for (Aluno alunoDB: resultado) {
//			System.out.println(alunoDB);
//			
//			if (maisNovo == null || alunoDB.getDataNascimento().isBefore(maisNovo.getDataNascimento())) {
//				maisNovo = alunoDB;
//			}
//		}
//		
//		//Removendo o aluno mais novo
//		if (maisNovo != null) {
//			System.out.println("\nAluno mais novo:\n" + maisNovo);
//			dao.remover(maisNovo.getId(), entityManager); //Estado Removed
//		}
		
//		entityManager.getTransaction().commit();
				
		entityManager.close(); // Estado Detached
		entityManagerFactory.close();
	}
}