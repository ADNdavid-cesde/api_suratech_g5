package com.example.ServidorSura5.REPOSITORIOS;

import com.example.ServidorSura5.MODELOS.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioPaciente extends JpaRepository<Paciente, Long> {
}
