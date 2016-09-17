package ch4.treesandgraphs.practice2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuildOrder {
    
    class Project {
        
        String name;
        Set<Project> dependencies;
        int numberIncoming;
        boolean marked;
        
        Project(String name) {
            dependencies = new HashSet<>();
            this.name = name;
            numberIncoming = 0;
            marked = false;
        }
        
        void addDependency(Project dependency) {
            dependencies.add(dependency);
        }
        
    }
    
    class Graph {
        Set<Project> nodes;
        
        Graph(int size) {
            nodes = new HashSet<>(size);
        }
        
        void addProject(Project project) {
            nodes.add(project);
        }
    }
    
    public List<String> order(String[] projects, String[][] deps) {
        Graph graph = createGraph(projects);
        formDependencies(graph, deps);
        List<String> ans = build(graph);
        return ans;
    }
    
    private List<String> build(Graph graph) {
        List<String> ans = new ArrayList<>(graph.nodes.size());
        while(ans.size() != graph.nodes.size()) {
            boolean foundZero = false;
            for(Project project : graph.nodes) {
                if(project.numberIncoming == 0 && !project.marked) {
                    ans.add(project.name);
                    project.marked = true;
                    for(Project dep : project.dependencies) {
                        dep.numberIncoming--;
                    }
                    foundZero = true;
                }
            }
            if(!foundZero) {
                throw new IllegalArgumentException();
            }
        }
        return ans;
    }
    
    private void formDependencies(Graph graph, String[][] deps) {
        for(String[] relation : deps) {
            String proj = relation[0];
            String dep = relation[1];
            Project project = null, dependency = null;
            for(Project p : graph.nodes) {
                if(p.name.equals(proj)) {
                    project = p;
                } else if(p.name.equals(dep)) {
                    dependency = p;
                }
            }
            dependency.addDependency(project);
            project.numberIncoming++;
        }
    }
    
    private Graph createGraph(String[] projects) {
        Graph graph = new Graph(projects.length);
        for(String name : projects) {
            Project project = new Project(name);
            graph.addProject(project);
        }
        return graph;
    }
    
    public static void main(String[] args) {
        BuildOrder bo = new BuildOrder();
        List<String> order = bo.order(new String[]{"a",  "b", "c", "d", "e", "f"}, new String[][]{{"d", "a"}, {"b", "f"}, {"d", "b"}, {"a", "f"}, {"c", "d"}});
        System.out.println(order);
    }

}
