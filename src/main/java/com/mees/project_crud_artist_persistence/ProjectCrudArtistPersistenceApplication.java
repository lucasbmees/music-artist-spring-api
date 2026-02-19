package com.mees.project_crud_artist_persistence;

import com.mees.project_crud_artist_persistence.main.Main;
import com.mees.project_crud_artist_persistence.repository.ArtistaRepository;
import com.mees.project_crud_artist_persistence.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectCrudArtistPersistenceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectCrudArtistPersistenceApplication.class, args);
	}

	@Autowired
	ArtistaRepository artistaRepository;

	@Autowired
	MusicaRepository musicaRepository;

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(artistaRepository, musicaRepository);
		main.exibirMenu();
	}
}
