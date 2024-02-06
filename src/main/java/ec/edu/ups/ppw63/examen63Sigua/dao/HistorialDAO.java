package ec.edu.ups.ppw63.examen63Sigua.dao;

import java.util.List;

import ec.edu.ups.ppw63.examen63Sigua.model.HistorialRecargas;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class HistorialDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(HistorialRecargas HistorialRecargas) {
		em.persist(HistorialRecargas);
	}
	
	public void update(HistorialRecargas HistorialRecargas) {
		em.merge(HistorialRecargas);
	}
	
	public void remove(int codigo) {
		HistorialRecargas HistorialRecargas = em.find(HistorialRecargas.class, codigo);
		em.remove(HistorialRecargas);
	}

	public HistorialRecargas read(int codigo) {
		HistorialRecargas HistorialRecargas = em.find(HistorialRecargas.class, codigo);
		return HistorialRecargas;
	}

	public List<HistorialRecargas> getAll() {
		String jpql = "SELECT c FROM HistorialRecargas c";
		Query q = em.createQuery(jpql, HistorialRecargas.class);
		return q.getResultList();
	}
}
