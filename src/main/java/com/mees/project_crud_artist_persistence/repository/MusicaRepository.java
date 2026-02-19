package com.mees.project_crud_artist_persistence.repository;

import com.mees.project_crud_artist_persistence.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
    Musica findByNome(String nome);

    @Query("SELECT m FROM Musica m JOIN m.artista a WHERE a.nome ILIKE %:nome%")
    List<Musica> buscarMusicasPorArtista(String nome);


}
