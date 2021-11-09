package com.example.battle_city_game;

import java.util.List;

public class GameRules {
    private List<Tank> tanks;
    private List<EnemyTank> enemyTanks;
    private Map map;
    private boolean GameOver = false;

    public GameRules(List<Tank> tanks, List<EnemyTank> enemyTanks, Map map) {
        this.tanks = tanks;
        this.enemyTanks = enemyTanks;
        this.map = map;
    }

    public boolean isGameOver(){
        return GameOver;
    }

    public void processUserCommand(int userCommand){
        if(userCommand == 'q') {
            System.out.println("User pressed Quit");
            this.GameOver = true;
        }
    }
    public boolean hasHitWall(int userCommand){
        for(Tank tank: tanks){
            if(userCommand == 'a' && map.getElement(tank.getX() - 1, tank.getY()) == 1) return true;
            if(userCommand == 's' && map.getElement(tank.getX(), tank.getY() + 1) == 1) return true;
            if(userCommand == 'w' && map.getElement(tank.getX(), tank.getY() - 1) == 1) return true;
            if(userCommand == 'd' && map.getElement(tank.getX() + 1, tank.getY()) == 1) return true;
        }
        return false;
    }
    public boolean hasHitWallEnemy(int random){
        for(EnemyTank enemyTank: enemyTanks){
            if(random == 10 && map.getElement(enemyTank.getX() - 1, enemyTank.getY()) == 1) return true;
            if(random == 11 && map.getElement(enemyTank.getX() + 1, enemyTank.getY()) == 1) return true;
            if(random == 12 && map.getElement(enemyTank.getX(), enemyTank.getY() - 1) == 1) return true;
            if(random == 13 && map.getElement(enemyTank.getX(), enemyTank.getY() + 1) == 1) return true;
        }
        return false;
    }
    public void hasHitEnemy(String direction, int x, int y){
        boolean temp = false;
        if(enemyTanks.size() == 1) temp = true;
        for(EnemyTank enemyTank: enemyTanks) {
            if (direction.equals("up") && enemyTank.getX() == x && isEmptyBetweenX(x, enemyTank.getX(), y, enemyTank.getY())) {
                if(temp){
                    GameOver = true;
                    System.out.println("You won");
                }
                else enemyTanks.remove(enemyTank);
            }
            if(direction.equals("down") && enemyTank.getX() == x && isEmptyBetweenX(x, enemyTank.getX(), y, enemyTank.getY())){
                if(temp){
                    GameOver = true;
                    System.out.println("You won");
                }
                else enemyTanks.remove(enemyTank);
            }
            if(direction.equals("left") && enemyTank.getY() == y && isEmptyBetweenY(x, enemyTank.getX(), y, enemyTank.getY())){
                if(temp){
                    GameOver = true;
                    System.out.println("You won");
                }
                else enemyTanks.remove(enemyTank);
            }
            if(direction.equals("right") && enemyTank.getY() == y && isEmptyBetweenY(x, enemyTank.getX(), y, enemyTank.getY())){
                if(temp){
                    GameOver = true;
                    System.out.println("You won");
                }
                else enemyTanks.remove(enemyTank);
            }
        }
    }
    public void hasHitPlayerTank(String direction, int x, int y){
        for(Tank tank: tanks) {
            if (direction.equals("up") && tank.getX() == x && isEmptyBetweenX(x, tank.getX(), y, tank.getY())) {
                    GameOver = true;
                    System.out.println("You lost");
            }
            if(direction.equals("down") && tank.getX() == x && isEmptyBetweenX(x, tank.getX(), y, tank.getY())){
                    GameOver = true;
                    System.out.println("You lost");
            }
            if(direction.equals("left") && tank.getY() == y && isEmptyBetweenY(x, tank.getX(), y, tank.getY())){
                    GameOver = true;
                    System.out.println("You lost");
            }
            if(direction.equals("right") && tank.getY() == y && isEmptyBetweenY(x, tank.getX(), y, tank.getY())){
                    GameOver = true;
                    System.out.println("You lost");
            }
        }
    }
    public boolean isEmptyBetweenX(int x1, int x2, int y1, int y2) {
        boolean temp = true;
        if (y1 >= y2) {
            for (int y = y2; y < y1; y++) {
                for (int x = x1; x <= x2; x++) {
                    if (map.getElement(x, y) == 1){
                        temp = false;
                    }
                    if (!temp) return false;
                }
            }
        }
        else{
            for(int y = y1; y < y2; y++){
                for(int x = x1; x <= x2; x++){
                    if(map.getElement(x, y) == 1){
                        temp = false;
                    }
                    if(!temp) return false;
                }
            }
        }
        return true;
    }
    public boolean isEmptyBetweenY(int x1, int x2, int y1, int y2) {
        boolean temp = true;
        if (x1 >= x2) {
            for (int y = y2; y < y1; y++) {
                for (int x = x1; x <= x2; x++) {
                    if (map.getElement(x, y) == 1){
                        temp = false;
                    }
                    if (!temp) return false;
                }
            }
        }
        else{
            for(int y = y1; y <= y2; y++){
                for(int x = x1; x < x2; x++){
                    if(map.getElement(x, y) == 1){
                        temp = false;
                    }
                    if(!temp) return false;
                }
            }
        }
        return true;
    }
}
