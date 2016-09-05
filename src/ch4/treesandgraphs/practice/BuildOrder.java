package ch4.treesandgraphs.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a list of projects and a list of dependencies (which is a list of pairs of projects, where the second
 * project is dependent on the first project). All of a project's dependencies must be built before the project is. Find
 * a build order that will allow the projects to be built. If there is no valid build order, return an error.
 * 
 * @author Aditya Srinivasan
 *
 */
public class BuildOrder {

    static class Graph {
        List<Project> vertices = new ArrayList<Project>();
        Map<String, Project> map = new HashMap<String, Project>();
        
        Project getOrCreateNode(String name) {
            if(!map.containsKey(name)) {
                Project project = new Project(name);
                vertices.add(project);
                map.put(name, project);
            }
            return map.get(name);
        }
        
        void addEdge(String p1, String p2) {
            Project start = getOrCreateNode(p1);
            Project end = getOrCreateNode(p2);
            
            start.addNeighbor(end);
        }
    
    }
    
    static class Project {
        String name;
        List<Project> children = new ArrayList<Project>();
        Map<String, Project> map = new HashMap<String, Project>();
        int numberOfDependencies = 0;
        
        Project(String name) { this.name = name; }
        
        void addNeighbor(Project other) {
            if(!map.containsKey(other.name)) {
                children.add(other);
                map.put(name, other);
                other.numberOfDependencies++;
            }
        }
    }
    
    public static String[] buildOrder(String[] projects, String[][] dependencies) {
        Project[] buildOrder = findBuildOrder(projects, dependencies);
        return convertToString(buildOrder);
    }
    
    public static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = constructGraph(projects, dependencies);
        return orderProjects(graph.vertices);
    }
    
    public static Project[] orderProjects(List<Project> projects) {
        Project[] order = new Project[projects.size()];
        
        int end = addNonDependentHelper(order, projects, 0);
        
        int idxProcessing = 0;
        
        while(idxProcessing < order.length) {
            Project current = order[idxProcessing];
            
            if(current == null) return null;
            
            List<Project> children = current.children;
            
            for(Project child : children) {
                child.numberOfDependencies--;
            }
            
            end = addNonDependentHelper(order, children, end);
            
            idxProcessing++;
        }
        
        return order;
    }
    
    public static int addNonDependentHelper(Project[] order, List<Project> projects, int offset) {
        for(Project project : projects) {
            if(project.numberOfDependencies == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }
    
    public static Graph constructGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        
        for(String project : projects) {
            graph.getOrCreateNode(project);
        }
        
        for(String[] pair : dependencies) {
            String first = pair[0];
            String second = pair[1];
            graph.addEdge(first, second);
        }
        
        return graph;
    }
    
    public static String[] convertToString(Project[] order) {
        if(order == null) return null;
        String[] stringOrder = new String[order.length];
        int i = 0;
        for(Project project : order) {
            stringOrder[i] = project.name;
            i++;
        }
        return stringOrder;
    }
    
    public static void main(String[] args) {
        String[] projects = {"a", "b", "c"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"c", "a"}
        };
//        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
//        String[][] dependencies = {
//                {"a", "b"},
//                {"b", "c"},
//                {"a", "c"},
//                {"a", "c"},
//                {"d", "e"},
//                {"b", "d"},
//                {"e", "f"},
//                {"a", "f"},
//                {"h", "i"},
//                {"h", "j"},
//                {"i", "j"},
//                {"g", "j"}};
        String[] buildOrder = buildOrder(projects, dependencies);
        if (buildOrder == null) {
            System.out.println("Circular Dependency.");
        } else {
            for (String s : buildOrder) {
                System.out.println(s);
            }
        }
    }

}
