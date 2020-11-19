package lanzador;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import model.Usuario;
import repository.IUsuarioRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {

	@Autowired
	private IUsuarioRepo repo;
	

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void crearUsuarioTest() {
		Usuario us= new Usuario();
		us.setNombreUsuario("angel");
		us.setPass(encoder.encode("333"));
		us.setRole("ADMIN");
		System.out.println("### USUARIO: "+us.getPass().toString());
		Usuario retorno = repo.save(us);
		
		assertTrue(retorno.getPass().equalsIgnoreCase(us.getPass()));  
	}

}
