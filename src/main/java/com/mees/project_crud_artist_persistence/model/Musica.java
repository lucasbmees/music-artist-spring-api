package com.mees.project_crud_artist_persistence.model;

import jakarta.persistence.*;

@Entity
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    private Artista artista;

    public Musica(String nome, Artista artista) {
        this.nome = nome;
        this.artista = artista;
    }

    public Musica() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
