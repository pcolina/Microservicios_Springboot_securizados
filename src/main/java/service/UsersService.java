package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import model.Usuario;
import repository.IUsuarioRepo; 

@Service
public class UsersService implements UserDetailsService{
	
	@Autowired
	private IUsuarioRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("### User: "+username);
		Usuario user = userRepo.findByNombreUsuario(username);
		
		System.out.println("### Usuario del service: "+user.getNombreUsuario()+", "+user.getPass()+", "+user.getRole());
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		
		UserDetails userDetails = new User(user.getNombreUsuario(), user.getPass(), authorities );
		System.out.println("### userDetails: "+userDetails);
		return userDetails;
	}

}
