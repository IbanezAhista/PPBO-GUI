import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameGUI extends JFrame {
    private JLabel backgroundLabel;
    private JLabel characterLabel;
    private JLabel textLabel;

    private int characterX;
    private int characterY;
    public GameGUI() {
        setTitle("Game Zombie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        characterX = 0;
        characterY = 0;

        //Masukkan image ke label > setbounds label > add label to jframe
        ImageIcon backgroundImage = new ImageIcon("src/asset/background.jpg");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 800, 600);
        add(backgroundLabel);
        setVisible(true);

        ImageIcon characterImage = new ImageIcon("src/asset/character.png");
        characterLabel = new JLabel(characterImage);
        characterLabel.setBounds(characterX, characterY, 800, 600);

        textLabel = new JLabel("Hello, welcome to my game!");
        textLabel.setFont(new Font("Arial", Font.BOLD, 24));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(230, 40, 400, 30);
        backgroundLabel.add(textLabel);
        backgroundLabel.add(characterLabel);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keycode = e.getKeyCode();
                switch (keycode) {
                    case KeyEvent.VK_W :
                        characterY -= 10;
                        break;
                    case KeyEvent.VK_S :
                        characterY += 10;
                        break;
                    case KeyEvent.VK_A :
                        characterX -= 10;
                        break;
                    case KeyEvent.VK_D :
                        characterX += 10;
                        break;
                    default :
                        break;
                }
                characterLabel.setLocation(characterX, characterY);


            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}