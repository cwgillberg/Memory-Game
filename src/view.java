import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Flow;

public class view extends JFrame {
    private JLabel title, foot;
    private JPanel inputPanel, btnPanel, header, footer, mid;
    private JButton metric, imperial, submit;
    private JTextArea text;
    private ArrayList<JComponent> buttons;

    public view() {

        buttons = new ArrayList<JComponent>();

        //panel code
        inputPanel = new JPanel();
        header = new JPanel();
        footer = new JPanel();
        mid = new JPanel();
        btnPanel = new JPanel();

        header.setLayout(new FlowLayout());
        inputPanel.setLayout(new FlowLayout());
        footer.setLayout(new FlowLayout());
        mid.setLayout(new GridLayout(2,1));
        btnPanel.setLayout(new FlowLayout());


        //button code
        metric = new JButton("metric");
        imperial = new JButton("imperial");
        submit = new JButton("submit");

        buttons.add(metric);
        buttons.add(imperial);
        buttons.add(submit);

        //title code
        title = new JLabel("hello world");
        foot = new JLabel("goodbye world");

        //text code
        text = new JTextArea(5, 20);

        //add code
        header.add(title);

        inputPanel.add(text);

        footer.add(foot);

        btnPanel.add(metric);
        btnPanel.add(imperial);
        btnPanel.add(submit);

        mid.add(inputPanel);
        mid.add(btnPanel);

        this.add(header);
        this.add(mid);
        this.add(footer);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


    }

    public ArrayList<JComponent> getButtons() {
        return buttons;
    }



}
