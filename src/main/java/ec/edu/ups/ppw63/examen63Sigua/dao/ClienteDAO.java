package ec.edu.ups.ppw63.examen63Sigua.dao;

import java.util.List;

import ec.edu.ups.ppw63.examen63Sigua.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ClienteDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Cliente cliente) {
		em.persist(cliente);
	}

	public void update(Cliente cliente) {
		em.merge(cliente);
	}

	public void remove(int codigo) {
		Cliente cliente = em.find(Cliente.class, codigo);
		em.remove(cliente);
	}

	public Cliente read(int codigo) {
		Cliente cliente = em.find(Cliente.class, codigo);
		return cliente;
	}

	public List<Cliente> getAll() {
		String jpql = "SELECT c FROM Cliente c";
		Query q = em.createQuery(jpql, Cliente.class);
		return q.getResultList();
	}

	public Cliente getClienteByCodigo(int codigo) {
		try {
			String jpql = "SELECT c FROM Cliente c WHERE c.codigo = :codigo";
			Query q = em.createQuery(jpql, Cliente.class);
			q.setParameter("codigo", codigo);
			return (Cliente) q.getSingleResult();
		} catch (NoResultException e) {
			return null; // O lanzar una excepción más descriptiva según tus necesidades
		}
	}

}
