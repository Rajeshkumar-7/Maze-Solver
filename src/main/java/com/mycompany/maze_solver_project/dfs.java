/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver_project;

import java.util.List;

/**
 *
 * @author rajes
 */
public class dfs {
    
    static class Pair{
        int distance;
    }
    
    public static boolean searchpath(int[][] maze , int x , int y , List<Integer> path){
        
        // Checking for destination
        if(maze[x][y] == 9){
            path.add(x);
            path.add(y);
            return true;
        }
        
        // Checking for a path
        if(maze[x][y] == 0){
            // Marking as 2 so we can know it is visited
            maze[x][y] = 2;
            
            // Moving to top
            if(searchpath(maze , x-1 , y , path)){
                path.add(x);
                path.add(y);
                return true;
            }
            // Moving to bottom
            if(searchpath(maze , x+1 , y , path)){
                path.add(x);
                path.add(y);
                return true;
            }
            // Moving to left
            if(searchpath(maze , x , y-1 , path)){
                path.add(x);
                path.add(y);
                return true;
            }
            // Moving to right
            if(searchpath(maze , x , y+1 , path)){
                path.add(x);
                path.add(y);
                return true;
            }
        }
        
        return false;
          
    }
}
