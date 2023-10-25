import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

class RoundedCornerLabel extends JLabel {
    private int arcWidth = 20; // Adjust this value to change the corner radius

    public RoundedCornerLabel(Icon image) {
        super(image);
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, width, height, arcWidth, arcWidth));
        g2.dispose();
    }
}

public class Coatch extends JFrame {

    private RoundedCornerLabel jLabel1;
    private RoundedCornerLabel jLabel2;
    private RoundedCornerLabel jLabel3;
    private RoundedCornerLabel jLabel4;
    private RoundedCornerLabel jLabel5;
    private RoundedCornerLabel jLabel6;
    private RoundedCornerLabel jLabel7;
    private RoundedCornerLabel jLabel8;
    private RoundedCornerLabel jLabel9;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;

    public Coatch() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 600);

        // Load images for RoundedCornerLabels
        jLabel1 = new RoundedCornerLabel(new ImageIcon("C:\\Users\\Dell\\Downloads\\coatch2.jpg"));
        jLabel1.setBounds(116, 50, 100, 82);

        jLabel2 = new RoundedCornerLabel(new ImageIcon("C:\\Users\\Dell\\Downloads\\coatch2.jpg"));
        jLabel2.setBounds(116, 132, 100, 67);

        jLabel3 = new RoundedCornerLabel(new ImageIcon("C:\\Users\\Dell\\Downloads\\coatch2.jpg"));
        jLabel3.setBounds(116, 199, 100, 64);

        jLabel4 = new RoundedCornerLabel(new ImageIcon("C:\\Users\\Dell\\Downloads\\coatch2.jpg"));
        jLabel4.setBounds(229, 132, 100, 67);

        jLabel5 = new RoundedCornerLabel(new ImageIcon("C:\\Users\\Dell\\Downloads\\coatch2.jpg"));
        jLabel5.setBounds(229, 199, 100, 34);

        jLabel6 = new RoundedCornerLabel(new ImageIcon("C:\\Users\\Dell\\Downloads\\coatch2.jpg"));
        jLabel6.setBounds(229, 286, 100, 26);

        jLabel7 = new RoundedCornerLabel(new ImageIcon("C:\\Users\\Dell\\Downloads\\coatch2.jpg"));
        jLabel7.setBounds(229, 312, 100, 28);

        jLabel8 = new RoundedCornerLabel(new ImageIcon("C:\\Users\\Dell\\Downloads\\coatch2.jpg"));
        jLabel8.setBounds(306, 286, 104, 35);

        jLabel9 = new RoundedCornerLabel(new ImageIcon("C:\\Users\\Dell\\Downloads\\coatch2.jpg"));
        jLabel9.setBounds(306, 312, 104, 30);

        jSeparator1 = new JSeparator();
        jSeparator1.setBounds(66, 220, 855, 10);

        jSeparator2 = new JSeparator();
        jSeparator2.setBounds(66, 334, 855, 10);

        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        getContentPane().add(jLabel2);
        getContentPane().add(jLabel3);
        getContentPane().add(jLabel4);
        getContentPane().add(jLabel5);
        getContentPane().add(jLabel6);
        getContentPane().add(jLabel7);
        getContentPane().add(jLabel8);
        getContentPane().add(jLabel9);
        getContentPane().add(jSeparator1);
        getContentPane().add(jSeparator2);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Coatch coatch = new Coatch();
                coatch.setVisible(true);
            }
        });
    }
}
