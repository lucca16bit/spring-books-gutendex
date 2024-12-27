package br.com.lucca.literalura.menu;

import br.com.lucca.literalura.models.GutendexResponse;
import br.com.lucca.literalura.models.Livro;
import br.com.lucca.literalura.models.entity.LivroJPA;
import br.com.lucca.literalura.repository.LivroRepository;
import br.com.lucca.literalura.repository.AutorRepository;
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

    public Menu(LivroRepository livroRepository, LivroService livroService) {
        this.livroRepository = livroRepository;
        this.livroService = livroService;
    }

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
        Livro dadosLivro = getLivros();
        LivroJPA livro = new LivroJPA(dadosLivro);
        livroRepository.save(livro);
        System.out.println(dadosLivro);
    }

    private Livro getLivros() {
        System.out.println("Digite o título do livro que deseja buscar:");
        String tituloBusca = sc.nextLine();
        Livro livro = response.results().stream()
                .filter(l -> l.titulo().toLowerCase().contains(tituloBusca))
                .findFirst()
                .orElse(null);

        if (livro != null) {
            System.out.println("Livro: " + tituloBusca + " encontrado!");
        } else {
            System.out.println("Livro: '" + tituloBusca +"' não encontrado.");
        }
        return livro;
    }

    private void listarTodosOsLivros() {
        livroService.listarTodosOsLivros();
    }

    private void listarTodosOsAutores() {
    }

    private void listarAutoresPorAno() {

    }
}
