import javax.swing.*;

public class ProgressBar extends JFrame  {
    //static JFrame f;
// create a frame
    static JFrame f;
    static JProgressBar b;
    static JProgressBar getProgressBar() {

        // create a frame
        f = new JFrame("ProgressBar");

        // create a panel
        JPanel p = new JPanel();

        // create a progressbar
        b = new JProgressBar();

        // set initial value
        b.setValue(0);

        b.setStringPainted(true);

        // add progressbar
        p.add(b);

        // add panel
        f.add(p);

        // set the size of the frame
        f.setSize(1000, 600);
        f.setVisible(true);
        return b;
    }
    
}
