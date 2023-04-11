package com.Library.WebApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Library.WebApp.Model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> 
{
	@Query(value = "SELECT * FROM users a WHERE a.usermail=?1 && a.password=?2 && a.role=?3", nativeQuery = true)
	Login findByUsername(String usermail, String password, String role);
}
