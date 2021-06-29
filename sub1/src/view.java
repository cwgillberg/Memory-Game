import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

public class view extends JFrame {
    private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
    private BufferedImage bi1, bi2, bi3, bi4, bi5, bi6;
    private Image i1, i2, i3, i4, i5, i6;
    private JPanel game;
    private ArrayList<JButton> btnList;
    private Image[] imgList;


    public view () {
        //variable declarations
        btnList = new ArrayList<JButton>();
        imgList = new Image[6];

        game = new JPanel();

        //layout managers
        game.setLayout(new GridLayout(4, 3));

        b1 = new JButton("1");
        b2 = new JButton("2");

        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b10 = new JButton("10");
        b11 = new JButton("11");
        b12 = new JButton("12");

        int counter = 0;
        btnList.add(b1);
        btnList.add(b2);
        btnList.add(b3);
        btnList.add(b4);
        btnList.add(b5);
        btnList.add(b6);
        btnList.add(b7);
        btnList.add(b8);
        btnList.add(b9);
        btnList.add(b10);
        btnList.add(b11);
        btnList.add(b12);

        for(JButton btn : btnList) {
            counter++;
            //btn = new JButton("" + counter);
            game.add(btn);
        }
        buildButtons();
        readImages();

        this.add(game);
    }

    public void initPanel() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 600);
        this.setVisible(true);
    }

    public void buildButtons() {


    }

    public void readImages() {
           try {
            bi1 = ImageIO.read(new File("pics\\pic1.jpeg"));
            i1 = bi1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            bi2 = ImageIO.read(new File("pics\\pic2.jpeg"));
            i2 = bi2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            bi3 = ImageIO.read(new File("pics\\pic3.jpeg"));
            i3 = bi3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            bi4 = ImageIO.read(new File("pics\\pic4.jpg"));
            i4 = bi4.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            bi5 = ImageIO.read(new File("pics\\pic5.jpeg"));
            i5 = bi5.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            bi6 = ImageIO.read(new File("pics\\pic6.jpeg"));
            i6 = bi6.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            imgList[0] = i1;
            imgList[1] = i2;
            imgList[2] = i3;
            imgList[3] = i4;
            imgList[4] = i5;
            imgList[5] = i6;

           } catch(IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void reset() {
        int i = 1;
        for(JButton btn : btnList) {
            btn.setIcon(null);
            btn.setText("" + i);
            btn.setEnabled(true);
            i++;
        }


    }

    public ArrayList<JButton> getButtons() {
        return btnList;
    }

    public Image[] getImages() {
        return imgList;
    }

}
