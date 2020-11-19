package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import model.Usuario;

@Service
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	

	Usuario findByNombreUsuario(String nombre);

}
