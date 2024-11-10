package com.example.ServidorSura5.REPOSITORIOS;

import com.example.ServidorSura5.MODELOS.Enfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioEnfermedad extends JpaRepository<Enfermedad, Long> {
}
