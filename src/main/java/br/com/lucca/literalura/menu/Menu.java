package br.com.lucca.literalura.menu;

import br.com.lucca.literalura.models.GutendexResponse;
import br.com.lucca.literalura.models.Livro;
import br.com.lucca.literalura.models.entity.LivroJPA;
import br.com.lucca.literalura.repository.LivroRepository;
import br.com.lucca.literalura.repository.AutorRepository;
import br.com.lucca.literalura.services.AutorService;
import br.com.lucca.literalura.services.GutendexService;
import br.com.lucca.literalura.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Menu {
    Scanner sc = new Scanner(System.in);
    public List<LivroJPA> livros = new ArrayList<>();
    GutendexService service = new GutendexService();
    GutendexResponse response;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroService livroService;

    @Autowired
    private AutorService autorService;

    public Menu(LivroRepository livroRepository, LivroService livroService) {
        this.livroRepository = livroRepository;
        this.livroService = livroService;
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
                    break;
                case 3:
                    listarTodosOsAutores();
                    break;
                case 4:
                    listarAutoresPorAno();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void buscarPorTitulo() {
        LivroJPA livro = getLivros();
        livroRepository.save(livro);
        System.out.println(livro);
    }

    private LivroJPA getLivros() {
        System.out.println("Digite o título do livro que deseja buscar:");
        String tituloBusca = sc.nextLine();

        LivroJPA livro = null;
        try {
            livro = livroService.salvarLivro(tituloBusca);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return livro;
    }

    private void listarTodosOsLivros() {
        livroService.listarTodosOsLivros();
    }

    private void listarTodosOsAutores() {
        autorService.listarTodosOsAutores();
    }

    private void listarAutoresPorAno() {
        System.out.println("Insira o ano para a busca:");
        int ano = sc.nextInt();
        autorService.listarAutoresVivos(ano);
    }
}
