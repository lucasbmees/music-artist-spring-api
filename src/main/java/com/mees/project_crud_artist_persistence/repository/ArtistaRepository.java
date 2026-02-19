package com.mees.project_crud_artist_persistence.repository;

import com.mees.project_crud_artist_persistence.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
     Artista findByNome(String nome);
}
