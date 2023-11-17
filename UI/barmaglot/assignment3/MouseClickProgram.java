//setSize()
//getObjectAt()
//long startTime = System.currentTimeMillis();
//// ...
//long estimatedTime = System.currentTimeMillis() - startTime;
//

package com.shpp.p2p.cs.ppolyak.assignment3;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MouseClickProgram extends WindowProgram {

    public void mouseMoved(MouseEvent mouseEvent) {
        tracker.setLabel(
                "  x: "+mouseEvent.getX()+
                ", y: "+mouseEvent.getY()
        );
    }

    public void mouseClicked(MouseEvent me) {
        if (me.isShiftDown()) {
            GObject comp = getElementAt(me.getX(), me.getY());

            if (comp != null)
                remove(comp);
        } else {
            GOval o = getMeFilledOval(me.getX(), me.getY(), 50, RandomGenerator.getInstance().nextColor());
            
            add(o);
        }
    }

    @Override
    public void run() {

        addLabel();
        addMouseListeners();
    }


    GLabel tracker = null;

    private void addLabel() {
        tracker = new GLabel("text", 30,30);
        add(tracker);
    }

    private GOval getMeFilledOval(int x, int y, int r, Color c) {

        GOval o = new GOval(x, y, r * 2, r * 2);
        o.setFilled(true);
        o.setColor(c);

        return o;
    }


}
