package com.example.battle_city_game;

import java.util.List;

public class ConsoleRender {
    private List<Tank> tanks;
    private List<EnemyTank> enemyTanks;
    private Map map;

    public ConsoleRender(List<Tank> tanks, List<EnemyTank> enemyTanks, Map map) {
        this.tanks = tanks;
        this.enemyTanks = enemyTanks;
        this.map = map;
    }

    public void render() {
        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                int element = map.getElement(x, y);
                if(element == 1)
                    drawWall();
                else if(isTank(x, y))
                    drawTank();
                else if(isEnemyTank(x, y))
                    drawEnemyTank();
                else drawEmpty();
            }
            System.out.println();
        }
    }
    private boolean isTank(int x, int y){
        for(Tank tank: tanks)
            if(tank.getX() == x && tank.getY() == y) return true;
            return false;
    }
    private boolean isEnemyTank(int x, int y){
        for(EnemyTank enemyTank: enemyTanks)
            if(enemyTank.getX() == x && enemyTank.getY() == y) return true;
            return false;
    }

    private static void drawWall(){
        System.out.print("#");
    }
    private static void drawEmpty(){
        System.out.print(" ");
    }
    private static void drawTank(){
        System.out.print("↑");
    }
    private static void drawEnemyTank(){
        System.out.print("↓");
    }
}
