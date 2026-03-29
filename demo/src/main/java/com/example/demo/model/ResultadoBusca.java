package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultadoBusca {
    private List<Filme> results;

    public List<Filme> getResults() { return results; }
    public void setResults(List<Filme> results) { this.results = results; }
}