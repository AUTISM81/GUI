

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ForfattareProgram {
    private JPanel panel1;
    private JTextPane textPane1;
    private JMenuItem save;
    private JMenuItem open;
    private JFrame frame;

    public ForfattareProgram() {
        frame = new JFrame("ForfattareProgram");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setJMenuBar(menuBar());
        save.addActionListener(new saveTxt());
    }

    public static void main(String[] args) {
        new ForfattareProgram();

    }

    public JMenuBar menuBar() {
        JMenuBar menuBar;
        JMenu menu;

        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        save = new JMenuItem("save");
        open = new JMenuItem("open");

        menuBar.add(menu);
        menu.add(save);
        menu.add(open);

        return menuBar;
    }
    private class saveTxt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            final JFileChooser fc = new JFileChooser(getSaveLocation());
            String txt = textPane1.getText();

            try(FileWriter fw = new FileWriter(fc.getSelectedFile()+".txt")) {
                fw.write(textPane1.toString());
            }
        }
    }

    private File getSaveLocation() {
        JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fc.showSaveDialog();

            if (result == fc.APPROVE_OPTION) {
            return fc.getSelectedFile();
        } else {
            return null;
        }
    }
}
