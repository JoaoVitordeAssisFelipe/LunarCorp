package com.corp.LunarCorp.repository;

import com.corp.LunarCorp.entity.UsuarioTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioTecnicoRepository extends JpaRepository<UsuarioTecnico, Long> {

}
