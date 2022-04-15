package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import posjavamavenhibernate.HibernateUtil;

public class GenericDao<E> {

	private EntityManager entityManager = HibernateUtil.getEntityManager();

	public void salvar(E entidade) {

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();

	}

	public E updateMerge(E entidade) { /* Salva ou atualiza... */

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();

		return entidadeSalva;
	}

	public E pesquisar(E entidade) {

		Object id = HibernateUtil.getPrimaryKey(entidade);

		E e = (E) entityManager.find(entidade.getClass(), id);

		return e;
	}

	public E pesquisar(Long id, Class<E> entidade) { /*
														 * Versão alternativa para Consulta do ID - Ao invés de passar 2
														 * classes, então passamos 2 parâmetros
														 */

		E e = (E) entityManager.find(entidade, id);

		return e;
	}

}