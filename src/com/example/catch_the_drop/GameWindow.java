package com.example.catch_the_drop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Alex_B on 11/23/2016.
 */
public class GameWindow extends JFrame {
    private static GameWindow game_Window;
    //count time between frames
    private static long last_frame_time;
    //Image variables
    private static Image background;
    private static Image game_over;
    private static Image drop;
    //drop's coordinate
    private static float drop_left = 200;
    private static float drop_top = -100;
    //speed of drop
    private static float drop_v = 200;

    public static void main(String[] args) throws IOException {

        //drawing images
        background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
        //add game window
        game_Window = new GameWindow();
        //set default close operation
        game_Window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //set location of game window x = 200, y = 100
        game_Window.setLocation(200, 100);
        //set window size: width = 906 px, height = 478 px
        game_Window.setSize(906, 478);
        //set boolean window resizable = false (default = true)
        game_Window.setResizable(false);
        //the current value of the running Java VM, in nanoseconds
        last_frame_time = System.nanoTime();

        //create instance of GameField, that extends of JPanel class, to create new panel
        GameField game_field = new GameField();
        //add new panel to game window instance
        game_Window.add(game_field);
        //set visible for game window
        game_Window.setVisible(true);
    }

    private static void onRepaint(Graphics g) {
        //set current time for the onRepaint method
        long current_time = System.nanoTime();
        //calculate delta time in seconds
        float delta_time = (current_time - last_frame_time) * 0.000000001f;
        last_frame_time = current_time;

        drop_top = drop_top + drop_v * delta_time;
        g.drawImage(background, 0, 0, null);
        g.drawImage(drop, (int) drop_left, (int) drop_top, null);
//        g.drawImage(game_over, 280, 120, null);
    }

    private static class GameField extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            //for often drawing panel
            repaint();

        }
    }


}
