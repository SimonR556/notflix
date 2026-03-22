package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Filme {
    private List<String> logosStreaming;
    private int id;
    private String title;
    private String overview;
    private String poster_path;

    public Filme() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public List<String> getLogosStreaming() { 
        return logosStreaming; 
    }
    
    public void setLogosStreaming(List<String> logosStreaming) { 
        this.logosStreaming = logosStreaming; 
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getOverview() { return overview; }
    public void setOverview(String overview) { this.overview = overview; }
    public String getPoster_path() { return poster_path; }
    public void setPoster_path(String poster_path) { this.poster_path = poster_path; }
}