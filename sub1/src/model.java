import javax.swing.*;
import java.awt.*;
import java.lang.Math.*;
import java.util.ArrayList;

public class model {
    private int max1 = 11;
    private int min1 = 0;
    private int min2 = 0;
    private int max2 = 5;
    private Image[] imgList;
    private ArrayList<JButton> btnList;
    private ArrayList<Integer> btnFrameWork;


    private int counter, a, b;

    public model() {
        btnFrameWork = new ArrayList<Integer>();

        counter = 0;
    }

    public void flipCard(int condition, JButton btn) {
        if(condition == 0) {
            //flip to pic
        } else {
            //flip to back
            btn.setIcon(null);

        }
    }

    public void randomize(ArrayList<JButton> btnList, Image[] imgList) {
        this.btnList = btnList;
        this.imgList = imgList;
        while(btnFrameWork.size() < 12) {
            b = (int)(Math.random()*(max2-min2+1)+min2);
            System.out.println("generated: " + b);
            if(checkOccurance(b) < 2) {
                btnFrameWork.add(b);
                System.out.println("added");
            }
            counter = 0;
        }
    }

    public int checkOccurance(int num) {
        for(int i = 0; i < btnFrameWork.size(); i++) {
            if(num == btnFrameWork.get(i)) {
                counter++;
            }
        }

        return counter;
    }

    public void showIcon(int btn) {
        //set icon from btnFrameWork on btn from imgList
        btnList.get(btn).setText(null);
        btnList.get(btn).setIcon(new ImageIcon(imgList[btnFrameWork.get(btn)]));

    }

    public ArrayList<Integer> getBtnFrameWork() {
        return btnFrameWork;
    }
}
