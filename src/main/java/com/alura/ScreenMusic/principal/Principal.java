package com.alura.ScreenMusic.principal;

import com.alura.ScreenMusic.model.Artista;
import com.alura.ScreenMusic.model.TipoArtista;
import com.alura.ScreenMusic.repository.ArtistaRepository;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ArtistaRepository repositorio;

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

        while (continuar.toLowerCase().equals("s")) {
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
        
    }

    private void listarMusicas() {
        
    }

    private void buscarMusicasPorArtista() {
        
    }

    private void buscarArtista() {
        System.out.println("Qual o nome do artista que deseja buscar?");
        var nome = leitura.nextLine();
        var artistaBuscado = repositorio.findByNomeContainingIgnoreCase(nome);

        if (artistaBuscado.isPresent()) {
            System.out.println("Dados do artista encontrado: " + artistaBuscado.get());
        } else {
            System.out.println("Artista não encontrado!");
        }
    }
}
