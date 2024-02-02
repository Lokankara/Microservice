package com.stack.assignments.assignment3;

        import javax.swing.JFrame;
        import java.awt.Color;
        import java.awt.Component;
        import java.awt.Graphics;
        import static java.lang.Math.*;
        import static java.lang.Math.sin;

public class SinusX {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(900, 700);
        frame.setTitle("Sin(x)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(new SinX());
        frame.setVisible(true);

    }


    public static class SinX extends Component {

        public void paint(Graphics g)
        {
            g.drawLine(0,350,900,350); // x-axis
            g.drawLine(450,0,450,900); // y-axis


            g.setColor(Color.red);
            for(double x=-450;x<=450;x=x+0.5)
            {
                double y = 50 * sin(x*(3.1415926/180));
                int Y = (int)y;
                int X = (int)x;
                g.drawLine(450+X,350-Y,450+X,350-Y);
            }
            g.setColor(Color.GREEN);
            for(double x=-450;x<=450;x=x+0.5)
            {
                double y = 50 * cos(x*(3.1415926/180));
                int Y = (int)y;
                int X = (int)x;
                g.drawLine(450+X,350-Y,450+X,350-Y);
            }
        }
    }
}
