package com.Library.WebApp.Service;

import java.util.List;

import com.Library.WebApp.Model.Login;

public interface LoginService {
	List<Login> getAllLogin();
    Login getLoginBYId(long id);
    Login saveLogin(Login login);
    boolean authenticateUser(String usermail,String password, String role );
    
}
