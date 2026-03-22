package com.example.demo.service;

import com.example.demo.model.Filme;
import com.example.demo.model.ResultadoBusca;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FilmeService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    public Filme buscarFilme(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String urlFilme = "https://api.themoviedb.org/3/movie/" + id + "?api_key=" + apiKey + "&language=pt-BR";
        String urlProviders = "https://api.themoviedb.org/3/movie/" + id + "/watch/providers?api_key=" + apiKey;

        Filme filme = restTemplate.getForObject(urlFilme, Filme.class);

        try {
            Map<String, Object> resp = restTemplate.getForObject(urlProviders, Map.class);
            Map<String, Object> results = (Map<String, Object>) resp.get("results");

            if (results != null && results.containsKey("BR")) {
                Map<String, Object> brasil = (Map<String, Object>) results.get("BR");

                if (brasil.containsKey("flatrate")) {
                    List<Map<String, Object>> plataformas = (List<Map<String, Object>>) brasil.get("flatrate");
                    
                    List<String> logos = plataformas.stream()
                        .map(p -> "https://image.tmdb.org/t/p/original" + p.get("logo_path").toString())
                        .collect(Collectors.toList());
                    
                    filme.setLogosStreaming(logos);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar streamings: " + e.getMessage());
        }
        return filme;
    }
    
    public List<Filme> pesquisarFilmes(String nome) {
        RestTemplate restTemplate = new RestTemplate();
    
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" + nome + "&language=pt-BR";
        ResultadoBusca busca = restTemplate.getForObject(url, ResultadoBusca.class);
        return busca != null ? busca.getResults() : List.of();
    }
    
    public List<Filme> buscarPopulares() {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey + "&language=pt-BR";
 
    ResultadoBusca busca = restTemplate.getForObject(url, ResultadoBusca.class);
    return busca != null ? busca.getResults() : List.of();
    }

}