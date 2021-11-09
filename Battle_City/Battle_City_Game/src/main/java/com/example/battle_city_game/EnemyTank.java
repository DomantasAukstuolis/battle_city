package com.example.battle_city_game;

public class EnemyTank {
    private int x;
    private int y;

    public EnemyTank(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void Movement(int random){
        if(random == 10) x -= 1;
        else if(random == 11) x += 1;
        else if(random == 12) y -= 1;
        else if(random == 13) y += 1;
    }
    public String Shooting(int random){
        if(random == 14) return "up";
        else if(random == 15) return "down";
        else if(random == 16) return "left";
        else if(random == 17) return "right";
        return "";
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
