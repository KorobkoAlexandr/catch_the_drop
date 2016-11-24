package com.example.catch_the_drop;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex_B on 11/23/2016.
 */
public class GameWindow extends JFrame {
    private static GameWindow game_Window;

    public static void main(String[] args) {
        game_Window = new GameWindow();
        game_Window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_Window.setLocation(200, 100);
        game_Window.setSize(906, 478);
        game_Window.setResizable(false);
        GameField game_field = new GameField();
        game_Window.add(game_field);
        game_Window.setVisible(true);
    }

    private static void onRepaint(Graphics g) {
        g.fillOval(10,10,400,150);
    }

    private static class GameField extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);

        }
    }


}
