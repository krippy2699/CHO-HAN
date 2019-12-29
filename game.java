import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;


public class game extends JFrame {
    private final int WIN_WIDTH = 700;
    private final int WIN_HEIGHT = 300;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel finpanel;


    //components for player 1
    private JLabel bal1_lab;
    private JTextField bal1_field;
    private JLabel bet1_lab;
    private JTextField bet1_field;
    private JLabel guess_lab1;
    private JTextField guess_field1;

    //components for player 2
    private JLabel bal2_lab;
    private JTextField bal2_field;
    private JLabel bet2_lab;
    private JTextField bet2_field;
    private JLabel guess_lab2;
    private JTextField guess_field2;



    // dice components
    private JLabel odd_or_even;
    private JTextField diebar;
    private JButton go;
    private JButton clear;
    private JButton check;
    private JButton readme;


    public game() {

        setTitle("CHO OR HAN");
        setSize(WIN_WIDTH, WIN_HEIGHT);

        panel1 = new JPanel();
        panel1.setBackground(Color.ORANGE);
        bet1_lab = new JLabel("BET:$ ");
        bet1_field = new JTextField(10);
        guess_lab1 = new JLabel("GUESS: ");
        guess_field1 = new JTextField(10);
        bal1_lab = new JLabel("BALANCE:$ ");
        bal1_field = new JTextField(10);
        panel1.setLayout(new GridLayout(8, 2));
        panel1.setBorder(BorderFactory.createTitledBorder("PLAYER 1"));
        panel1.add(bet1_lab);
        panel1.add(bet1_field);
        panel1.add(guess_lab1);
        panel1.add(guess_field1);
        panel1.add(bal1_lab);
        panel1.add(bal1_field);


        panel2 = new JPanel();
        panel2.setBackground(Color.ORANGE);
        panel2.setBorder(BorderFactory.createTitledBorder("DIE ACTION"));
        panel2.setLayout(new GridLayout(6, 1));
        odd_or_even = new JLabel("ODD OR EVEN");
        diebar = new JTextField(20);
        go = new JButton("GO !");
        clear = new JButton("CLEAR");
        check = new JButton("CHECK");
        readme = new JButton("READ ME !");
        panel2.add(odd_or_even);
        panel2.add(go);
        go.addActionListener(new gobuttonlistener());
        panel2.add(diebar);
        panel2.add(check);
        panel2.add(clear);
        panel2.add(readme);
        clear.addActionListener(new clearbuttonlistener());
        check.addActionListener(new checkbuttonlistener());
        readme.addActionListener(new readbuttonlistener());

        panel3 = new JPanel();
        panel3.setBackground(Color.ORANGE);
        panel3.setLayout(new GridLayout(8, 2));
        panel3.setBorder(BorderFactory.createTitledBorder("PLAYER 2"));
        bet2_lab = new JLabel("BET:$ ");
        bet2_field = new JTextField(10);
        guess_lab2 = new JLabel("GUESS: ");
        guess_field2 = new JTextField(10);
        bal2_lab = new JLabel("BALANCE:$ ");
        bal2_field = new JTextField(10);
        panel3.add(bet2_lab);
        panel3.add(bet2_field);
        panel3.add(guess_lab2);
        panel3.add(guess_field2);
        panel3.add(bal2_lab);
        panel3.add(bal2_field);


        finpanel = new JPanel();
        finpanel.setBackground(Color.ORANGE);
        finpanel.setLayout(new FlowLayout());
        finpanel.add(panel1);
        finpanel.add(panel2);
        finpanel.add(panel3);

        add(finpanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public class gobuttonlistener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int num;
            double val1;
            double val2;
            double val3;
            Random randnum = new Random();
            num = randnum.nextInt(13) + 2;

            if (num % 2 == 0) {
                diebar.setText("EVEN");
            } else {
                diebar.setText("ODD");
            }

        }
    }


    public class clearbuttonlistener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            bet1_field.setText(" ");
            guess_field1.setText(" ");
            bal1_field.setText(" ");
            diebar.setText(" ");
            bet2_field.setText(" ");
            guess_field2.setText(" ");
            bal2_field.setText(" ");
        }
    }

    public class checkbuttonlistener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            double val1;
            double val2;
            double val3;
            String dieoutcome;
            String guess1;
            String guess2;
            guess1 = guess_field1.getText();
            guess2 = guess_field2.getText();
            dieoutcome = diebar.getText();
            val1 = Double.parseDouble(bet1_field.getText());
            val2 = Double.parseDouble(bet2_field.getText());
            val3 = val1 + val2;

            if (guess1.charAt(0)== dieoutcome.charAt(0) && guess2.charAt(0) == dieoutcome.charAt(0))
            {
                bal1_field.setText(bet1_field.getText());
                bal2_field.setText(bet2_field.getText());

            }
            else if(guess1.charAt(0)== dieoutcome.charAt(0))
            {
                bal1_field.setText(Double.toString(val3));
                bal2_field.setText("0");
            }

            else if (guess2.charAt(0) == dieoutcome.charAt(0))
            {
                bal1_field.setText("0");
                bal2_field.setText(Double.toString(val3));
            }
            else
            {
                bal2_field.setText("0");
                bal1_field.setText("0");
            }


        }
    }
    public  class readbuttonlistener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            JOptionPane.showMessageDialog(null,"------STEPS TO PLAY THE GAME-----"
                    + "\n 1.Player starts the game by entering his bet and his guess"
                    + "\n 2.Player 2 follows by entering his bet and guess"
                    + "\n 3.Hit the go button to find out the outcome on the die"
                    + "\n 4.Hit the check button to find out who won"
                    + "\n 5.Hit clear to start a new bet\n"
                    + "\n-----RULES-----"
                    + "\n1.It is ok to bet cents if you want "
                    + "\n2.While entering your guess either enter a capitalize E for even or o for odd. You could also type the whole word");
        }

    }




    public static void main(String[] Args)
    {
        new game();
    }
}



