package com.example.battle_city_game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Tank> tanks = new ArrayList<>();
        tanks.add(new Tank(2,9, "wsadtgfh"));
        List<EnemyTank> enemyTanks = new ArrayList<>();
        enemyTanks.add(new EnemyTank(2, 1));
        enemyTanks.add(new EnemyTank(8, 1));
        Map map = new Map();
        ConsoleRender renderer = new ConsoleRender(tanks, enemyTanks, map);
        GameRules gameRules = new GameRules(tanks, enemyTanks, map);
        while(!gameRules.isGameOver()){
            renderer.render();
            int userCommand = System.in.read();
            gameRules.processUserCommand(userCommand);
            if(!gameRules.hasHitWall(userCommand))
            {
                for(Tank tank : tanks){
                    tank.processUserCommand(userCommand);
                    gameRules.hasHitEnemy(tank.processUserCommandBullet(userCommand), tank.getX(), tank.getY());
                }
            }
            if(gameRules.isGameOver()) break;
            for(EnemyTank enemyTank: enemyTanks){
                int random1 = 14 + (int)(Math.random() * ((29 - 14) + 1));
                gameRules.hasHitPlayerTank(enemyTank.Shooting(random1), enemyTank.getX(), enemyTank.getY());
                while(true) {
                    int random = 10 + (int)(Math.random() * ((13 - 10) + 1));
                    if (!gameRules.hasHitWallEnemy(random)) {
                        enemyTank.Movement(random);
                        break;
                    }
                }
            }
        }
    }
}
