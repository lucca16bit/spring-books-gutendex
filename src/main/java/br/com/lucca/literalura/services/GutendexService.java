package br.com.lucca.literalura.services;

import br.com.lucca.literalura.models.GutendexResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GutendexService {
    private final String URL_API = "https://gutendex.com/books/";

    public String obterDados() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_API))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                throw new RuntimeException("Erro ao acessar a API Gutendex: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao enviar requisição para a API Gutendex: " + e.getMessage(), e);
        }
    }

    public GutendexResponse buscarLivroPorTitulo(String titulo) throws IOException {
        String urlBusca = URL_API + "?search=" + titulo.replace(" ", "+");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlBusca))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(response.body(), GutendexResponse.class);
            } else {
                throw new RuntimeException("Erro ao acessar a API Gutendex: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao buscar livro: " + e.getMessage(), e);
        }
    }
}
