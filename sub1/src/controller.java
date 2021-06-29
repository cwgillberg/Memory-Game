import javax.print.attribute.IntegerSyntax;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import java.util.concurrent.*;

public class controller {
    private view view;
    private model model;
    private int counter, flips;
    private ArrayList<JButton> btnList;
    private ArrayList<Boolean> isFlipped;
    private ArrayList<Integer> btnFrameWork;
    private Image[] imgList;
    private int indexC1, indexC2, points;
    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public controller() {
        isFlipped = new ArrayList<Boolean>();
        for(int i = 0; i < 12; i++) {
            isFlipped.add(false);
        }
        view = new view();
        model = new model();
        view.initPanel();

        btnList = view.getButtons();
        imgList = view.getImages();

        flips = 0;
        points = 0;

        this.btnFrameWork = model.getBtnFrameWork();

        model.randomize(btnList, imgList);

        //adding actionListener to every button
        for(JButton btn : btnList) {
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //keeps track of which button was pressed
                    counter = btnList.indexOf(btn);
                    if (counter < isFlipped.size() && flips != 1) {

                        if (isFlipped.get(counter) == false) {
                            //flip 2 cards
                                flips++;
                                model.showIcon(counter);
                                isFlipped.add(counter, true);
                                isFlipped.remove(isFlipped.get(counter));

                            indexC1 = counter;
                        }
                    } else if(counter < isFlipped.size() && flips == 1){

                        //2 cards are now flipped
                        if (isFlipped.get(counter) == false) {
                            model.showIcon(counter);
                            isFlipped.add(counter, true);
                            isFlipped.remove(isFlipped.get(counter));
                            indexC2 = counter;

                            //check if they are ==
                            System.out.println("pressed 1: " + (indexC1 % 5));
                            System.out.println("pressed 2: " + (indexC2 % 5));
                            if(btnFrameWork.get(indexC1) == btnFrameWork.get(indexC2)) {
                                System.out.println("They are the same");
                                //don't flip 'em
                                btnList.get(indexC1).setEnabled(false);
                                btnList.get(indexC2).setEnabled(false);

                                indexC1 = 0;
                                indexC2 = 0;
                                counter = 0;
                                flips = 0;
                                points++;

                            } else {
                                    executorService.schedule(new Runnable() {
                                        @Override
                                        public void run() {
                                            model.flipCard(1,btnList.get(indexC1));
                                            model.flipCard(1,btnList.get(indexC2));
                                            btnList.get(indexC1).setText("" + (indexC1+1));
                                            btnList.get(indexC2).setText("" + (indexC2+1));
                                            indexC1 = 0;
                                            indexC2 = 0;
                                            counter = 0;
                                            flips = 0;
                                        }
                                    }, 2, TimeUnit.SECONDS);

                            }
                        }



                        System.out.println(points);
                        if(points == 6) {
                            JOptionPane.showMessageDialog(null,"You win!");
                            view.reset();
                        }
                    }
                }
            });
        }

    }


}
