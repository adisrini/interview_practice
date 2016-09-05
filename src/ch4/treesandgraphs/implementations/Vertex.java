package ch4.treesandgraphs.implementations;

public class Vertex {
    public Integer data;
    public boolean visited;
    public Vertex[] neighbors;
    
    public Vertex(Integer data) {
        this.data = data;
    }   
}
