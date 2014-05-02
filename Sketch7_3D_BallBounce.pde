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
      gravity = .2;
      tX = 1;
      tY = 1;
      tZ = 1;
  }
  
  void display(){
    pushMatrix();
    translate(x, y, z);
    scale(tX, tY, tZ);
    sphere(60);
    popMatrix();
  }
  
  void update(){
    //dY *= gravity;
    y += dY;
    if (y <= 120 && y > 80 && dY >= 0){
      tX *= 1.1;
      tY /= 1.1;
      tZ *= 1.1;
    }
    else if (y <= 120 && y > 80 && dY < 0){
      tX /= 1.1;
      tY *= 1.1;
      tZ /= 1.1;
    } 
    else if (y <= 80 && y > -60 && dY < 0){
      println("here");
      tX /= 1.01;
      tY *= 1.01;
      tZ /= 1.01;
    } 
    else if (y >= -150 && y <= -60 && dY < 0){
      tX *= 1.01;
      tY /= 1.01;
      tZ *= 1.01;
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


void setup(){
  size(600, 600, P3D); 
  b = new Ball(0, -50, 0);
  noStroke();
}

void draw(){
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
