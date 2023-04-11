package com.Library.WebApp.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Login {
		 @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private long id;

		    @Column(name = "role")
		    private String role;

		    @Column(name = "usermail")
		    private String usermail;

		    @Column(name = "password")
		    private String password;

			public Login(long id, String role, String usermail, String password) {
				super();
				this.id = id;
				this.role = role;
				this.usermail = usermail;
				this.password = password;
			}

			public Login() {
				super();
				// TODO Auto-generated constructor stub
			}

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getRole() {
				return role;
			}

			public void setRole(String role) {
				this.role = role;
			}

			public String getUsermail() {
				return usermail;
			}

			public void setUsermail(String usermail) {
				this.usermail = usermail;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}

	}

