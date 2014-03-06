package View;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JComponent {

    float presentation, discussion, group_work, pause, minPause;

    public void setTypeProportion(float presentation, float discussion, float group_work, float pause, float minPause) {
        this.presentation = presentation;
        this.discussion = discussion;
        this.group_work = group_work;
        this.pause = pause;
        this.minPause = minPause;
    }

    public void paint(Graphics g) {
        int width = getWidth() / 2;
        int height = getHeight();

        int y = 0;
        int x = width / 4;
        //Presentation
        int tmpHeight = Math.round(height * presentation);
        g.setColor(ColorScheme.COLOR_PRESENTATION);
        g.fillRect(x, y, width, tmpHeight);
        y += tmpHeight;
        //Discussion
        tmpHeight = Math.round(height * discussion);
        g.setColor(ColorScheme.COLOR_DISCUSSION);
        g.fillRect(x, y, width, tmpHeight);
        y += tmpHeight;
        //Group Work
        tmpHeight = Math.round(height * group_work);
        g.setColor(ColorScheme.COLOR_GROUP_WORK);
        g.fillRect(x, y, width, tmpHeight);
        y += tmpHeight;
        //Break
        tmpHeight = Math.round(height * pause);
        g.setColor(ColorScheme.COLOR_BREAK);
        g.fillRect(x, y, width, tmpHeight);

        //minPause line
        width = (int) Math.round(getWidth() * 0.75);
        x = x - getWidth() / 8;
        y = getHeight() - (int) (getHeight() * minPause);
        g.setColor(Color.RED);
        g.drawLine(x, y, x + width, y);
    }

}
