package com.corp.LunarCorp.repository;

import com.corp.LunarCorp.entity.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado,Long> {

}
