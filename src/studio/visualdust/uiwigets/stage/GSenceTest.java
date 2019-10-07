package studio.visualdust.uiwigets.stage;

import studio.visualdust.uiwigets.button.GButton;
import studio.visualdust.uiwigets.theme.FlavorResource;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GSenceTest {
    public static void main(String[] args) {
        FlavorResource.Companion.Initialize();
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        GSence sence = new GSence();
        sence.setSize(200, 200);
        sence.setLocation(0, 0);
        GButton bt = new GButton("gugugu1");
        bt.setSize(100, 50);
        bt.setLocation(20, 20);
        sence.add(bt);
        frame.add(sence);
        frame.setVisible(true);
        bt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sence.setSize(500, 500);
            }
        });
    }
}
