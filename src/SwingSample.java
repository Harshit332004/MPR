import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.regex.Pattern;

class RoundedCornerBorder extends AbstractBorder {
    private int radius;

    public RoundedCornerBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        super.paintBorder(c, g, x, y, width, height);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius, radius, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = radius;
        return insets;
    }

    public Rectangle getBorderShape(int x, int y, int width, int height) {
        return new Rectangle(x, y, width, height);
    }
}

public class SwingSample {
    JFrame jframe;
    JButton loginButton;
    JTextField email;
    JPasswordField password;
    JLabel usernameError;
    JLabel passwordError;

    public SwingSample() throws IOException {
        jframe = new JFrame("Login Form");
        email = new JTextField();
        password = new JPasswordField();

        loginButton = new JButton("LOGIN");
        usernameError = new JLabel();
        passwordError = new JLabel();

        jframe.setContentPane(new JPanel() {
            BufferedImage bufferedImage;

            {
                try {
                    bufferedImage = ImageIO.read(getClass().getResource("C:\Users\Dell\Downloads\SWIMMINGGRADIANT.jpg""));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bufferedImage, 0, 0, this);
            }
        });
        init();
    }

    public void addEventListeners() {
        loginButton.addActionListener((ActionEvent e) -> {
            String data = "Username: " + email.getText();
            data += "\n" + "Password: " + new String(password.getPassword());
            JOptionPane.showMessageDialog(null, data);
        });

        email.getDocument().addDocumentListener(new DocumentListener() {
            public void removeUpdate(DocumentEvent e) {
                if (email.getText().length() > 0 && !email.getText().equals("Enter your email")) {
                    if (validateMail(email.getText())) {
                        usernameError.setForeground(new Color(50, 168, 58));
                        usernameError.setText("Email is valid");
                    } else {
                        usernameError.setForeground(Color.RED);
                        usernameError.setText("Email is not valid");
                    }
                } else {
                    usernameError.setText("");
                }
            }

            public void insertUpdate(DocumentEvent e) {
                if (email.getText().length() > 0 && !email.getText().equals("Enter your email")) {
                    if (validateMail(email.getText())) {
                        usernameError.setForeground(new Color(50, 168, 58));
                        usernameError.setText("Email is valid");
                    } else {
                        usernameError.setForeground(Color.RED);
                        usernameError.setText("Email is not valid");
                    }
                } else {
                    usernameError.setText("");
                }
            }

            public void changedUpdate(DocumentEvent e) {
                if (email.getText().length() > 0 && !email.getText().equals("Enter your email")) {
                    if (validateMail(email.getText())) {
                        usernameError.setForeground(new Color(50, 168, 58));
                        usernameError.setText("Email is valid");
                    } else {
                        usernameError.setForeground(Color.RED);
                        usernameError.setText("Email is not valid");
                    }
                } else {
                    usernameError.setText("");
                }
            }
        });

        password.getDocument().addDocumentListener(new DocumentListener() {
            public void removeUpdate(DocumentEvent e) {
                if (new String(password.getPassword()).length() > 0 && !new String(password.getPassword()).equals("Enter your password")) {
                    if (validatePassword(new String(password.getPassword()))) {
                        passwordError.setForeground(new Color(50, 168, 58));
                        passwordError.setText("Password is valid");
                    }
                } else {
                    passwordError.setText("");
                }
            }

            public void insertUpdate(DocumentEvent e) {
                if (new String(password.getPassword()).length() > 0 && !new String(password.getPassword()).equals("Enter your password")) {
                    if (validatePassword(new String(password.getPassword()))) {
                        passwordError.setForeground(new Color(50, 168, 58));
                        passwordError.setText("Password is valid");
                    }
                } else {
                    passwordError.setText("");
                }
            }

            public void changedUpdate(DocumentEvent e) {
                if (new String(password.getPassword()).length() > 0 && !new String(password.getPassword()).equals("Enter your password")) {
                    if (validatePassword(new String(password.getPassword()))) {
                        passwordError.setForeground(new Color(50, 168, 58));
                        passwordError.setText("Password is valid");
                    }
                } else {
                    passwordError.setText("");
                }
            }
        });

        email.addFocusListener(new FocusListener() {
            public void focusLost(FocusEvent e) {
                if (email.getText().equals("")) {
                    email.setText("Enter your email");
                    email.setForeground(Color.gray);
                }
            }

            public void focusGained(FocusEvent e) {
                if (email.getText().equals("Enter your email")) {
                    email.setText("");
                    email.setForeground(Color.black);
                }
            }
        });

        password.addFocusListener(new FocusListener() {
            public void focusLost(FocusEvent e) {
                if (new String(password.getPassword()).equals("")) {
                    password.setText("Enter your password");
                    password.setForeground(Color.gray);
                    password.setEchoChar((char) 0);
                }
            }

            public void focusGained(FocusEvent e) {
                if (new String(password.getPassword()).equals("Enter your password")) {
                    password.setText("");
                    password.setEchoChar('*');
                    password.setForeground(Color.black);
                }
            }
        });
    }

    private boolean validateMail(String mail) {
        String regExp = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regExp);
        return pattern.matcher(mail).matches();
    }

    private boolean validatePassword(String text) {
        passwordError.setForeground(Color.RED);
        if (text.length() < 8) {
            passwordError.setText("Password must be of length 8");
            return false;
        } else if (!text.matches(".*[a-zA-Z]+.*")) {
            passwordError.setText("Password must contain alphabets");
            return false;
        } else if (!text.matches(".*\\d.*")) {
            passwordError.setText("Password must contain digits");
            return false;
        } else {
            return true;
        }
    }

    public void init() {
        email.setPreferredSize(new Dimension(250, 35));
        password.setPreferredSize(new Dimension(250, 35));
        loginButton.setPreferredSize(new Dimension(250, 35));
        loginButton.setBackground(new Color(66, 245, 114));
        loginButton.setFocusPainted(false);

        email.setText("Enter your email");
        email.setForeground(Color.gray);
        password.setText("Enter your password");
        password.setForeground(Color.gray);
        password.setEchoChar((char) 0);

        usernameError.setFont(new Font("SansSerif", Font.BOLD, 11));
        usernameError.setForeground(Color.RED);

        passwordError.setFont(new Font("SansSerif", Font.BOLD, 11));
        passwordError.setForeground(Color.RED);

        jframe.setLayout(new GridBagLayout());

        Insets textInsets = new Insets(10, 10, 5, 10);
        Insets buttonInsets = new Insets(20, 10, 10, 10);
        Insets errorInsets = new Insets(0, 20, 0, 0);

        GridBagConstraints input = new GridBagConstraints();
        input.anchor = GridBagConstraints.CENTER;
        input.insets = textInsets;
        input.gridy = 1;
        jframe.add(email, input);

        input.gridy = 2;
        input.insets = errorInsets;
        input.anchor = GridBagConstraints.WEST;
        jframe.add(usernameError, input);

        input.gridy = 3;
        input.insets = textInsets;
        input.anchor = GridBagConstraints.CENTER;
        jframe.add(password, input);

        input.gridy = 4;
        input.insets = errorInsets;
        input.anchor = GridBagConstraints.WEST;
        jframe.add(passwordError, input);

        input.insets = buttonInsets;
        input.anchor = GridBagConstraints.WEST;
        input.gridx = 0;
        input.gridy = 5;
        jframe.add(loginButton, input);

        jframe.setSize(950, 650);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        jframe.requestFocus();
        addEventListeners();
    }

    public static void main(String args[]) {
        try {
            new SwingSample();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class RoundedCornerBorder extends AbstractBorder {
        private int radius;

        public RoundedCornerBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = radius;
            return insets;
        }

        public Rectangle getBorderShape(int x, int y, int width, int height) {
            return new Rectangle(x, y, width, height);
        }
    }
}
