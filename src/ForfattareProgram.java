import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ForfattareProgram {
    private JPanel panel1;
    private JTextPane textPane1;


    public static void main(String[] args) {
        JFrame frame = new JFrame("ForfattareProgram");
        frame.setJMenuBar(menuBar());

        frame.setContentPane(new ForfattareProgram().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static JMenuBar menuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem save;
        JMenuItem open;

        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        save = new JMenuItem("save");
        open = new JMenuItem("open");


        menuBar.add(menu);
        menu.add(save);
        menu.add(open);

        return menuBar;
    }

    /*@Override
    public void actionPerformed(ActionEvent s) {
        String txt = textPane1.getText();

        try {
            Files.write(Paths.get("my-file.txt"), txt.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
