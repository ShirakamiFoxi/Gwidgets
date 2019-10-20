package studio.visualdust.uiwidgets.stage;

import studio.visualdust.uiwidgets.button.GButton;
import studio.visualdust.uiwidgets.textField.GtextField;
import studio.visualdust.uiwidgets.theme.FlavorResource;
import studio.visualdust.uiwidgets.theme.FlavorResource.Companion.colorEnum;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GSenceTest {
    public static void main(String[] args) {
        FlavorResource.Companion.Initialize();
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        GSence sence = new GSence(ComponentConfig.BindTypes.SIZE_BIND);
        sence.setLocation(0, 0);
        sence.setSize(300, 300);
        sence.setBackground(FlavorResource.Companion.getColor(colorEnum.CONTAINER_BG_1_STATIC));
        GButton bt1 = new GButton("All null layout !", GButton.ButtonSeries.NEXT_FEATURED);
        bt1.setSize(150, 50);
        bt1.setLocation(20, 20);
        sence.add(bt1);
        GButton bt2 = new GButton("Try it on!");
        bt2.setLocation(60, 100);
        bt2.setSize(100, 40);
        sence.add(bt2);
        frame.add(sence);
        frame.setVisible(true);

        GtextField gtextField = new GtextField();
        frame.add(gtextField);
        gtextField.setLocation(30, 510);
        gtextField.setSize(100, 40);

        bt2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sence.setSize(Integer.parseInt(gtextField.getText()),
                        Integer.parseInt(gtextField.getText()));
            }
        });
    }
}
