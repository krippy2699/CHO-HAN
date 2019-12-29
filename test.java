import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class test extends JFrame
{
    private JButton button;
    private JTextField field1;


    test()
    {
        JPanel pane = new JPanel();

        setTitle("MY TEST");
        setSize(200,200);
        button = new JButton("GO!");
        field1 = new JTextField(10);

        pane.add(button);
        button.addActionListener(new buttonListener());
        pane.add(field1);


        add(pane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public class buttonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            field1.setText("123456789");
        }
    }


    public static void main(String[] Args)
    {
        new test();
    }


}
