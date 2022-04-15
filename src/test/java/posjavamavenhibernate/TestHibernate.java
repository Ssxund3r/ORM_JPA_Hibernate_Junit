package posjavamavenhibernate;

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

		UsuarioPessoa pessoa = genericDao.pesquisar(5L, UsuarioPessoa.class);
		
		genericDao.deletarPorId(pessoa);

	}

}
