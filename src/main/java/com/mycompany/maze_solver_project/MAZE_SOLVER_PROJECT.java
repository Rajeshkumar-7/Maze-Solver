/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maze_solver_project;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Rajesh
 */
public class MAZE_SOLVER_PROJECT extends JFrame{
    
    // This 2D array represents the maze
    // 0 -> It represents the grid we can traverse through
    // 1 -> It represents the obstacles
    // 9 -> It is the Destination Point
    private int[][] maze = 
    {{1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}};
    
    public List<Integer> path = new ArrayList<>();
    
    
    // Setting up the initial jframe
    public MAZE_SOLVER_PROJECT(){
        setTitle("Maze Solver");
        setSize(650 , 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dfs.searchpath(maze , 1 , 1 , path);
        System.out.print(path);
        
    }
    
    @Override
    public void paint(Graphics g){
        
        // It transaltes the origin of the graphics
        g.translate(140, 195);
        
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                Color color;
                switch(maze[i][j]){
                    case 1: color = Color.BLACK; break;
                    case 9: color = Color.RED; break;
                    default : color = Color.WHITE; break;
                }
                g.setColor(color);
                g.fillRect(30*j , 30*i , 30 , 30);
                g.setColor(Color.RED);
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }
        
        for(int i=0;i<path.size();i+=2){
            int pathy = path.get(i);
            int pathx = path.get(i+1);
            
            g.setColor(Color.GREEN);
            g.fillRect(30*pathx, 30*pathy, 20, 20);
        }
    }

    public static void main(String[] args) {
        MAZE_SOLVER_PROJECT view = new MAZE_SOLVER_PROJECT();
        view.setVisible(true);
    }
}
