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

}
