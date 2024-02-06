package ec.edu.ups.ppw63.examen63Sigua.dao;

import java.util.List;

import ec.edu.ups.ppw63.examen63Sigua.model.Operadora;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class OperadoraDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Operadora Operadora) {
		em.persist(Operadora);
	}
	
	public void update(Operadora Operadora) {
		em.merge(Operadora);
	}
	
	public void remove(int codigo) {
		Operadora Operadora = em.find(Operadora.class, codigo);
		em.remove(Operadora);
	}

	public Operadora read(int codigo) {
		Operadora Operadora = em.find(Operadora.class, codigo);
		return Operadora;
	}

	public List<Operadora> getAll() {
		String jpql = "SELECT c FROM Operadora c";
		Query q = em.createQuery(jpql, Operadora.class);
		return q.getResultList();
	}

	public Operadora getOperadoraPorCodigo(int codigo) {
		String jpql = "SELECT c FROM Operadora c WHERE c.codigo = :codigo";
		Query q = em.createQuery(jpql, Operadora.class);
		q.setParameter("codigo", codigo);
		List<Operadora> Operadoras = q.getResultList();
	    return Operadoras.isEmpty() ? null : Operadoras.get(0);
	}
	
}
