import javax.swing.*;

public class ForfattareProgram {
    private JPanel panel1;
    private JTextPane textPane1;


    public static void main(String[] args) {
        JFrame frame = new JFrame("ForfattareProgram");

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

        save.addActionListener(save());
        menuBar.add(menu);
        menu.add(save);
        menu.add(open);

        return menuBar;
    }

    public void save() {
        String txt = textPane1.getText();
    }
}
