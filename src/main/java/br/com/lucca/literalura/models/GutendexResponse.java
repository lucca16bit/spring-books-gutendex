package br.com.lucca.literalura.models;

import java.util.List;

public class GutendexResponse {
    private int count;
    private String next;
    private String previous;
    private List<Livro> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Livro> getResults() {
        return results;
    }

    public void setResults(List<Livro> results) {
        this.results = results;
    }
}
