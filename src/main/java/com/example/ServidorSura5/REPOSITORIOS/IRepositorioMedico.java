package com.example.ServidorSura5.REPOSITORIOS;

import com.example.ServidorSura5.MODELOS.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioMedico extends JpaRepository<Medico, Long> {
}
