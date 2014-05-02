import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class Sketch7_3D_BallBounce extends PApplet {

//import processing.opengl.*;
Ball b;

class Ball{
  float x, y, z;
  float dY;
  float gravity;
  float tX, tY, tZ;
  
  Ball(float x, float y, float z){
      this.x = x;
      this.y = y;
      this.z = z;
      dY = 5;
      gravity = .2f;
      tX = 1;
      tY = 1;
      tZ = 1;
  }
  
  public void display(){
    pushMatrix();
    translate(x, y, z);
    scale(tX, tY, tZ);
    sphere(60);
    popMatrix();
  }
  
  public void update(){
    //dY *= gravity;
    y += dY;
    if (y <= 120 && y > 80 && dY >= 0){
      tX *= 1.1f;
      tY /= 1.1f;
      tZ *= 1.1f;
    }
    else if (y <= 120 && y > 80 && dY < 0){
      tX /= 1.1f;
      tY *= 1.1f;
      tZ /= 1.1f;
    } 
    else if (y <= 80 && y > -60 && dY < 0){
      println("here");
      tX /= 1.01f;
      tY *= 1.01f;
      tZ /= 1.01f;
    } 
    else if (y >= -150 && y <= -60 && dY < 0){
      tX *= 1.01f;
      tY /= 1.01f;
      tZ *= 1.01f;
    } 
    //println(y);
    if (y > 120){
      dY *= -1;
    }
    else if (y < -150){
      dY *= -1;
      tX = 1;
      tY = 1;
      tZ = 1; 
    }
  }
  
  
}


public void setup(){
  size(600, 600, P3D); 
  b = new Ball(0, -50, 0);
  noStroke();
}

public void draw(){
  pushMatrix();
  translate(width/2, height/2);
  background(0);
  fill(0,0,255);
  ambientLight(102, 102, 102);
  directionalLight(126, 126, 255, 1, -1, 0);
  //camera(100, 100, 300, 0, -50, 0, 0, 1, 0);
  b.update();
  b.display();
  popMatrix();
}
  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "Sketch7_3D_BallBounce" });
  }
}
