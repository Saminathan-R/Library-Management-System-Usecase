package com.Library.WebApp.Controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Library.WebApp.Model.Login;
import com.Library.WebApp.Service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	private LoginService loginService;

	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
	@GetMapping()
    public List<Login> getAllLogin(){
        return loginService.getAllLogin();
    }
	 @GetMapping("{id}")
	    public ResponseEntity<Login> getloginById (@PathVariable ("id") Long id) {
	        return new ResponseEntity<Login> (loginService.getLoginBYId(id), HttpStatus.OK);
	    }
	    @PostMapping()
	    public ResponseEntity<Login> saveLogin(@RequestBody Login login) {
	        return new ResponseEntity<Login>(loginService.saveLogin(login), HttpStatus.CREATED);
	    }
	    @PostMapping("/add")
        public ResponseEntity<String> login(@RequestBody Login login){
            String usermail = login.getUsermail();
            String password = login.getPassword();
            String role = login.getRole();
            
            boolean isAuthenticated = loginService.authenticateUser( usermail, password, role);
            
            if(isAuthenticated) {
                return ResponseEntity.ok("User authenticated successfully");
            }else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
            }
        }


}
