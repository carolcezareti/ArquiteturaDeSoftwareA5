package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Fila;
@Repository
public class FilaDAO {
	@PersistenceContext
	EntityManager manager;
	
	public void criar(Fila fila){
		manager.persist(fila);
	}
	
	public void atualizar(Fila fila){
		manager.merge(manager.find(Fila.class, fila.getId()));
		manager.merge(manager.find(Fila.class, fila.getNome()));
		manager.merge(manager.find(Fila.class, fila.getFigura()));
	}
	
	public void excluir(Fila fila){
		manager.remove(manager.find(Fila.class, fila.getId()));
	}
	
	public Fila selecionar(String id){
		return manager.find(Fila.class, id);
	}
		
	
	@SuppressWarnings("unchecked")
	public List<Fila> listarFilas() throws IOException {
		return manager.createQuery("select nm_figura from Fila f").getResultList();
	}

	public Fila carregar(int id) throws IOException {
		return manager.find(Fila.class, id);
	}
}
