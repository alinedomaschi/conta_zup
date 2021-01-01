package com.apibankzup.apibank.repository;

import com.apibankzup.apibank.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
    public List<UsuarioModel> findAllByNomeContainingIgnoreCase (String nome);
}
