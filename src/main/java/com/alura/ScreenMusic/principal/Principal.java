package com.alura.ScreenMusic.principal;

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
        while (opcao != 0) {
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
    }

    private void cadastrarMusica() {
        
    }

    private void listarMusicas() {
        
    }

    private void buscarMusicasPorArtista() {
        
    }

    private void buscarArtista() {
        
    }
}
