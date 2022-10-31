import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.AncestorListener;

public class SimpleGUI extends JFrame{
    private JFrame frame = new JFrame();
    private JButton button = new JButton("kill");
    private JTextField input = new JTextField("",5);
    private JLabel label = new JLabel("input: ");
    private JRadioButton radio1 = new JRadioButton("select 1");
    private JRadioButton radio2 = new JRadioButton("select 2");
    private JCheckBox check = new JCheckBox("check",false);

    public SimpleGUI(){
        super("Simple Example");
        this.setBounds(100,100,250,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(label);
        container.add(input);

        ButtonGroup radios = new ButtonGroup();
        radios.add(radio1);
        radios.add(radio2);
        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);
        container.add(check);

        button.addAncestorListener((AncestorListener) new ButtonEventListener());
        container.add(button);



    }
    class ButtonEventListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = "";
            message += "Button was pressed\n";
            message += "Text is: " + input.getText() + "\n";
            message += (radio1.isSelected() ? "Radio #1" : "Radio #2") + " is selected + \n";
            message += "Checkbox is " + (check.isSelected() ? "checked" : "unchecked") + "\n";
            JOptionPane.showMessageDialog(null, message,"output", JOptionPane.PLAIN_MESSAGE);

        }
    }

}
