package com.Library.WebApp.ServiceIMPL;

import java.util.List;
import org.springframework.stereotype.Service;

import com.Library.WebApp.Exception.ResourceNotFoundException;
import com.Library.WebApp.Model.Login;
import com.Library.WebApp.Repository.LoginRepository;
import com.Library.WebApp.Service.LoginService;

@Service
public class LoginServiceIMPL  implements LoginService{

	private LoginRepository loginRepository;
	public LoginServiceIMPL(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}

	@Override
	public List<Login> getAllLogin() {
		// TODO Auto-generated method stub
		return loginRepository.findAll();
	}

	@Override
	public Login getLoginBYId(long id) {
		// TODO Auto-generated method stub
		return loginRepository.findById(id).orElseThrow( 
				()-> new ResourceNotFoundException("Login", "Id", id));
	}

	@Override
	public Login saveLogin(Login login) {
		// TODO Auto-generated method stub
		return loginRepository.save(login);
	}

	@Override
	public boolean authenticateUser(String usermail, String password, String role) {
		Login login = loginRepository.findByUsername(usermail, password, role);
		if(login==null || !login.getPassword().equals(password)) {
			return false;
		}
		return true;
	} 
}
