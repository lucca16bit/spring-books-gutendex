package br.com.lucca.literalura.menu;

import br.com.lucca.literalura.models.GutendexResponse;
import br.com.lucca.literalura.models.Livro;
import br.com.lucca.literalura.services.GutendexService;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    GutendexService service = new GutendexService();
    GutendexResponse response;

    {
        try {
            response = service.obterLivros();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void menuCli() {
        int opcao = -1;

        while (opcao != 0) {

            System.out.println("""
            ================== LITERALURA ==================
            1 - Buscar livro pelo título
            2 - Listar livros registrados
            3 - Listar autores registrados
            4 - Listar autores vivos em um determinado ano
            5 - Listar livros em um determinado idioma
            
            0 - Sair
            """);

            opcao =sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    buscarPorTitulo();
                    break;
                case 2:
                    listarTodosOsLivros();
            }
        }
    }

    private void buscarPorTitulo() {
        System.out.println("Digite o título do livro que deseja buscar:");
        String tituloBusca = sc.nextLine();
        Livro livro = response.results().stream()
                .filter(l -> l.titulo().toLowerCase().contains(tituloBusca))
                .findFirst()
                .orElse(null);

        if (livro != null) {
            System.out.printf("""
            ==========================   LIVRO   ==========================
            Título:                 %s
            Autor:                  %s
            Idioma:                 %s
            Número de Downloads:    %d
            """, livro.titulo(),livro.autor(),livro.idioma(), livro.numeroDownloads());
        } else {
            System.out.println("Livro: '" + tituloBusca +"' não encontrado.");
        }
    }

    private void listarTodosOsLivros() {
        response.results().forEach(System.out::println);
    }
}
