package com.alura.ScreenMusic.principal;

import com.alura.ScreenMusic.model.Artista;
import com.alura.ScreenMusic.model.Musica;
import com.alura.ScreenMusic.model.TipoArtista;
import com.alura.ScreenMusic.repository.ArtistaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ArtistaRepository repositorio;
    private Optional<Artista> artista;

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 9) {
            var menu = """
                    *** ScreenMusic ***
                    
                    1 - Cadastrar artista
                    2 - Cadastrar música
                    3 - Listar músicas
                    4 - Buscar músicas por artista
                    5 - Pesquisar dados sobre um artista
                    
                    9 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                case 5:
                    buscarArtista();
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarArtista() {
        var continuar = "s";

        while (continuar.equalsIgnoreCase("s")) {
            System.out.println("Digite o nome do artista que deseja cadastrar:");
            var nome = leitura.nextLine();
            System.out.println("Digite o tipo do artista (solo, dupla ou banda):");
            var tipo = leitura.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);
            repositorio.save(artista);

            System.out.println("Deseja cadastrar mais um artista? (S/N)");
            continuar = leitura.nextLine();
        }
    }

    private void cadastrarMusica() {
        buscarArtista();

        System.out.println("Qual o nome da música que deseja cadastrar?");
        var nomeMusica = leitura.nextLine();
        Musica musica = new Musica(nomeMusica);
        if (artista.isPresent()) {
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            repositorio.save(artista.get());
        }
    }

    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(System.out::println);
    }

    private void buscarMusicasPorArtista() {

    }

    private void buscarArtista() {
        System.out.println("Qual o nome do artista que deseja buscar?");
        var nome = leitura.nextLine();
        artista = repositorio.findByNomeContainingIgnoreCase(nome);

        if (artista.isPresent()) {
            System.out.println("Dados do artista encontrado: " + artista.get());
        } else {
            System.out.println("Artista não encontrado!");
        }
    }
}
