package com.mees.project_crud_artist_persistence.main;

import com.mees.project_crud_artist_persistence.model.Artista;
import com.mees.project_crud_artist_persistence.model.Estilo;
import com.mees.project_crud_artist_persistence.model.Musica;
import com.mees.project_crud_artist_persistence.repository.ArtistaRepository;
import com.mees.project_crud_artist_persistence.repository.MusicaRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner scanner;
    private ArtistaRepository artistaRepository;
    private MusicaRepository musicaRepository;

    public Main(ArtistaRepository artistaRepository, MusicaRepository musicaRepository) {
        this.scanner = new Scanner(System.in);
        this.artistaRepository = artistaRepository;
        this.musicaRepository = musicaRepository;
    }

    public void exibirMenu(){
        System.out.println("--- BEM-VINDO A APLICAÇÃO DE GERENCIAMENTO DE MÚSICAS ---");

        boolean continuar = true;
        while(continuar){
            System.out.println("""
            OPÇÕES:
                1 -> Cadastrar Artsita
                2 -> Listar Artistas
                3 -> Remover Artista
                4 -> Cadastrar Música
                5 -> Listar Músicas
                6 -> Remover Músuica
                7 -> Músicas por Artista
                0 -> Sair
        """);
            var opcao = scanner.nextInt();

            if(opcao == 0){
                continuar = false;
            }

            switch (opcao){
                case 1:
                    salvarArtista();
                    break;
                case 2:
                    exibirArtistas();
                    break;
                case 3:
                    removerArtista();
                    break;
                case 4:
                    cadastrarMusicas();
                    break;
                case 5:
                    exibirMusicas();
                    break;
                case 6:
                    removerMusica();
                    break;
                case 7:
                    buscarMusicasPorArtista();
                    break;
                case 8:
                    buscarDadosArtista();
                    break;
            }
        }
    }

    private void buscarDadosArtista() {
        scanner.nextLine();
        System.out.println("Qual artista deseja consultar?");
        var nomeArtista = scanner.nextLine();
        Artista artista = artistaRepository.findByNome(nomeArtista);
        System.out.println(artista);
    }

    private void buscarMusicasPorArtista() {
        scanner.nextLine();
        System.out.println("Digite o nome do artista: ");
        var nomeArtista = scanner.nextLine();
        List<Musica> musicasArtista = musicaRepository.buscarMusicasPorArtista(nomeArtista);
        musicasArtista.forEach(System.out::println);
    }

    @Transactional
    public void removerMusica() {
        scanner.nextLine();
        System.out.println("Qual música você deseja remover? ");
        List<Musica> musicasDisponiveis = musicaRepository.findAll();
        musicasDisponiveis.forEach(System.out::println);
        var nomeMusica = scanner.nextLine();
        Musica musica = musicaRepository.findByNome(nomeMusica);
        if (musica == null) {
            System.out.println("Música não encontrada.");
            return;
        }
        Artista artista = musica.getArtista();
        artista.getMusicas().remove(musica);
        artistaRepository.save(artista);
    }

    private void exibirMusicas() {
        List<Musica> musicas = musicaRepository.findAll();
        musicas.forEach(musica -> {
            System.out.println("Música: " + musica.getNome() + " - Artista: " + musica.getArtista().getNome());
        });
    }

    private void removerArtista() {
        scanner.nextLine();
        System.out.println("Qual artista deseja remover?");
        List<Artista> artistasDisponiveis = artistaRepository.findAll();
        artistasDisponiveis.forEach(System.out::println);
        var nomeArtista = scanner.nextLine();
        Artista artista = artistaRepository.findByNome(nomeArtista);
        artistaRepository.delete(artista);
    }

    private void cadastrarMusicas() {
        scanner.nextLine();
        System.out.println("Qual o nome da música?");
        var nomeMusica = scanner.nextLine();
        System.out.println("Qual artista deseja associar a música?");
        List<Artista> artistasDisponiveis = artistaRepository.findAll();
        artistasDisponiveis.forEach(System.out::println);
        var nomeArtista = scanner.nextLine();
        Artista artista = artistaRepository.findByNome(nomeArtista);
        Musica musica = new Musica(nomeMusica, artista);
        musicaRepository.save(musica);

    }

    private void exibirArtistas() {
        List<Artista> artistas = artistaRepository.findAll();
        artistas.forEach(System.out::println);
    }

    private void salvarArtista() {
        scanner.nextLine();
        System.out.println("Qual o nome do Artista? ");
        var nomeArtista = scanner.nextLine();
        Artista artista = new Artista(nomeArtista);
        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Solo");
        System.out.println("2 - Banda");
        System.out.println("3 - Dupla");
        var escolha = scanner.nextInt();

        switch(escolha){
            case 1:
                artista.setEstilo(Estilo.SOLO);
                break;
            case 2:
                artista.setEstilo(Estilo.BANDA);
                break;
            case 3:
                artista.setEstilo(Estilo.DUPLA);
                break;
        }
        artistaRepository.save(artista);
    }
}
