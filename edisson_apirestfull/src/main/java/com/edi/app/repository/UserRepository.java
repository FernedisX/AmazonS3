package com.edi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.edi.app.entity.Usuario;
@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {

}
