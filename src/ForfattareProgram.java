

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterAbortException;
import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

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
        //gör så att de båda knapparna har olika funktioner
        save.addActionListener(new saveTxt());
        open.addActionListener(new openTxt());
    }

    public static void main(String[] args) {

        //startar uppbygnade av programmet
        new ForfattareProgram();

    }

    //menubaren som ska sitta i paneln
    public JMenuBar menuBar() {
        JMenuBar menuBar;
        JMenu menu;

        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        save = new JMenuItem("save");
        open = new JMenuItem("open");

        //lägger ihop allting till en hel meny
        menuBar.add(menu);
        menu.add(save);
        menu.add(open);

        return menuBar;
    }

    //klass för att kunna spara all text som en txt fil
    private class saveTxt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //frågar vad filen ska heta och sedan gör det till en txt
            String fileName = name();

            //tar all text för att kunna spara den.
            String txt = textPane1.getText();


            try {
                //sparar den som en txt fil
                BufferedWriter bw = new BufferedWriter( new FileWriter(".\\" + fileName));

                //bestämmer vad det är som sparas i txt fil
                bw.write(txt);

                //stänger denna metod
                bw.close();
            } catch (IOException e) {
                //ifall något skulle vara fel körs denna kodsnitt
                e.printStackTrace();
            }
        }
    }

    //öppnar programmet
    private class openTxt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //frågar vad filen ska heta och sedan gör det till en txt
            String fileName = name();

            //ifall det skulle
            String text = null;
            try {
                //hittar vars filen är och tar den
                Scanner file = new Scanner(new File(fileName));

                while (file.hasNext()) {
                    //läser in varje rad av filen så att det hamnar på rätt rad och inte all text på en rad när du öppnar
                    text = file.next();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //sätter texten från filen som har lästs in till det som displayas
            textPane1.setText(text);
        }
    }

    public static String name() {
        //frågar vad filen ska heta och sedan gör det till en txt
        String fileName = JOptionPane.showInputDialog("What is the name of the file?");
        fileName += ".txt";

        return fileName;
    }
}
