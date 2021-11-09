package com.example.battle_city_game;

public class Tank {
    private int x;
    private int y;
    private char up;
    private char down;
    private char left;
    private char right;
    private char bulletUp;
    private char bulletDown;
    private char bulletLeft;
    private char bulletRight;

    public Tank(int sx, int sy, String controls){
        this.x = sx;
        this.y = sy;

        this.up = controls.charAt(0);
        this.down = controls.charAt(1);
        this.left = controls.charAt(2);
        this.right = controls.charAt(3);
        this.bulletUp = controls.charAt(4);
        this.bulletDown = controls.charAt(5);
        this.bulletLeft = controls.charAt(6);
        this.bulletRight = controls.charAt(7);
    }

    public void processUserCommand(int n){
        if(n == left)
            this.x -= 1;
        else if(n == right)
            this.x += 1;
        else if(n == up)
            this.y -= 1;
        else if(n == down)
            this.y += 1;
    }
    public String processUserCommandBullet(int n){
        if(n == bulletUp)
            return "up";
        if(n == bulletDown)
            return "down";
        if(n == bulletLeft)
            return "left";
        if(n == bulletRight)
            return "right";
        return "";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
