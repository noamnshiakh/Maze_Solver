import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Maze_Solver extends JFrame {
    private int[][] maze = {{1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,1},
            {1,0,1,1,1,1,1,0,0,0,0,0,1},
            {1,0,0,1,0,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,9,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            };
    public ArrayList<Integer> path = new ArrayList<>();
    public Maze_Solver(){
        setTitle("Maze Solver");
        setBounds(150,100,450,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchpath(maze,1,1,path);
        setVisible(true);
    }
    @Override
    public void paint(Graphics g){
        g.translate(25,50);
      for(int i=0;i< maze.length;i++){
          for(int j=0;j<maze[0].length;j++){
              Color color;
              switch (maze[i][j]){
                  case 1 : color = Color.BLACK; break;
                  case 9 :  color = Color.red;break;
                  default : color = Color.WHITE;break;
              }
              g.setColor(color);
              g.fillRect(30*j,30*i,30,30);
              g.setColor(Color.black);
              g.drawRect(30*j,30*i,30,30);
          }
      }
      for(int i=0;i<path.size();i+=2){
          int pathx = path.get(i);
          int pathy = path.get(i+1);
          System.out.println("X codinates : "+pathx);
          System.out.println("Y Cordinates : "+pathy);

          g.setColor(Color.green);
          g.fillRect(30*pathx,30*pathy,30,30);
      }
    };
    public static void main(String[] args){
        new Maze_Solver();
    }
}
