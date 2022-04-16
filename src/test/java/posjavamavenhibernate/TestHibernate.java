package posjavamavenhibernate;

import java.util.List;

import org.junit.Test;

import dao.GenericDao;
import model.UsuarioPessoa;

public class TestHibernate {

	@Test
	public void testHibernateUtil() {

		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

		UsuarioPessoa usuarioPessoa = new UsuarioPessoa();
		usuarioPessoa.setIdade(99);
		usuarioPessoa.setNome("Fausto");
		usuarioPessoa.setSobrenome("Silva");
		usuarioPessoa.setEmail("teste.t@gmail.com");
		usuarioPessoa.setLogin("Bibo");
		usuarioPessoa.setSenha("1111");

		genericDao.salvar(usuarioPessoa);

	}

	@Test
	public void testBuscar() {

		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(2L);

		pessoa = genericDao.pesquisar(pessoa);

		System.out.println(pessoa);

	}

	@Test
	public void testBuscarDoisAlternativo() {

		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

		UsuarioPessoa pessoa = genericDao.pesquisar(4L, UsuarioPessoa.class);

		System.out.println(pessoa);

	}

	@Test
	public void testUpdateMerge() {

		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

		UsuarioPessoa pessoa = genericDao.pesquisar(1L, UsuarioPessoa.class);

		pessoa.setIdade(99);
		pessoa.setNome("nome do Bibo atualizado");

		pessoa = genericDao.updateMerge(pessoa);

		System.out.println(pessoa);

	}

	@Test
	public void testDelete() {

		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

		UsuarioPessoa pessoa = genericDao.pesquisar(6L, UsuarioPessoa.class);

		genericDao.deletarPorId(pessoa);

	}

	@Test
	public void testConsultaListaId() {

		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

		List<UsuarioPessoa> list = genericDao.listarTodosId(UsuarioPessoa.class);

		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
			System.out.println("---------------------------------------");
		}

	}

	@Test
	public void testeQueryList() {

		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

		List<UsuarioPessoa> list = genericDao.getEntityManager().createQuery("from UsuarioPessoa where nome = 'Fausto'")
				.getResultList();

		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}

	}

	@Test
	public void testeQueryListMaxResult() {

		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();

		List<UsuarioPessoa> list = genericDao.getEntityManager().createQuery("from UsuarioPessoa order by id")
				.setMaxResults(5).getResultList();

		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}

	}

}
