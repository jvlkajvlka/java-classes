import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.time.LocalTime;

import static java.awt.BasicStroke.CAP_ROUND;
import static java.awt.BasicStroke.JOIN_MITER;

public class ClockWithGui extends JPanel {

    LocalTime time = LocalTime.now();

    ClockWithGui(){
        new ClockThread().start();
        setOpaque(false);
    }

    class ClockThread extends Thread {
        @Override
        public void run() {
            for (; ; ) {
                time = LocalTime.now();
                //System.out.printf("%02d:%02d:%02d\n", time.getHour(), time.getMinute(), time.getSecond());
                try{
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Clock");
        frame.setContentPane(new ClockWithGui());
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(getWidth() / 2, getHeight() / 2);

        paintClockFace(g2d);
        paintClockLongArm(g2d);
        paintClockShortArm(g2d);
        paintClockSecondArm(g2d);
        paintClockLines(g2d);
    }

    public void paintClockFace(Graphics2D g2d) {
        for (int i = 1; i < 13; i++) {
            AffineTransform at = new AffineTransform();
            at.rotate(2 * Math.PI / 12 * i);
            Point2D src = new Point2D.Float(0, -120);
            Point2D trg = new Point2D.Float();
            at.transform(src, trg);
            g2d.drawString(Integer.toString(i), (int) trg.getX(), (int) trg.getY());
        }
    }

    public void paintClockLongArm(Graphics2D g2d) {
        AffineTransform saveAT = g2d.getTransform();
        g2d.rotate((time.getHour() % 12 * 2 * Math.PI / 12) + (time.getMinute() % 60 * 2 * Math.PI / 60) / 60);
        g2d.setStroke(new BasicStroke(2, CAP_ROUND, JOIN_MITER));
        g2d.drawLine(0, 0, 0, -50);
        g2d.setTransform(saveAT);
    }

    public void paintClockShortArm(Graphics2D g2d) {
        AffineTransform saveATminute = g2d.getTransform();
        g2d.rotate(time.getMinute() % 60 * 2 * Math.PI / 60);
        g2d.setStroke(new BasicStroke(2, CAP_ROUND, JOIN_MITER));
        g2d.drawLine(0, 0, 0, -80);
        g2d.setTransform(saveATminute);
    }

    public void paintClockSecondArm(Graphics2D g2d) {
        AffineTransform saveATsecond = g2d.getTransform();
        g2d.rotate(time.getSecond() % 60 * 2 * Math.PI / 60);
        g2d.setStroke(new BasicStroke(1, CAP_ROUND, JOIN_MITER));
        g2d.drawLine(0, 0, 0, -100);
        g2d.setTransform(saveATsecond);
    }

    public void paintClockLines(Graphics2D g2d) {
        for (int i = 0; i < 60; i++) {

            AffineTransform saveATline = g2d.getTransform();
            g2d.rotate(i * 2 * Math.PI / 60);
            g2d.setStroke(new BasicStroke(2, CAP_ROUND, JOIN_MITER));
            g2d.drawLine(0, -140, 0, -150);
            g2d.setTransform(saveATline);


        }
    }
}

