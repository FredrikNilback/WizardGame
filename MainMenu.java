import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.atomic.AtomicInteger;

public class MainMenu {
    JFrame MainMenu = new JFrame();
    JPanel MainMenuPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(100,100,100));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };
    JButton NewGame = new JButton();
    JButton LoadGame = new JButton();
    JLabel Title = new JLabel();
    Boolean Male = true;
    Boolean SelectedGender = false;


    public MainMenu() {
        MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenu.setLayout(null);
        MainMenu.setSize(400,600);
        MainMenu.setResizable(false);
        MainMenu.setLocationRelativeTo(null);

        MainMenuPanel.setBounds(0, 0, 400, 600);
        MainMenuPanel.setLayout(null);

        Title.setBounds(0, 0, 400, 600);
        Title.setIcon(new ImageIcon("Images/Title.png"));
        MainMenuPanel.add(Title);
       

        NewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterCreator();
            }
        });
        NewGame.setBounds(90, 300, 200, 50);
        NewGame.setIcon(new ImageIcon("Images/NewGame.png"));
        MainMenuPanel.add(NewGame);


        LoadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        LoadGame.setBounds(90, 375, 200, 50);
        LoadGame.setIcon(new ImageIcon("Images/LoadGame.png"));
        MainMenuPanel.add(LoadGame);
        
        MainMenu.add(MainMenuPanel);
        MainMenu.setVisible(true);

    }

    private void characterCreator() {
        JDialog CharacterCreator = new JDialog(this.MainMenu, "Character Creator", true);
        CharacterCreator.setSize(700, 500);
        CharacterCreator.setLocationRelativeTo(this.MainMenu);
        CharacterCreator.setResizable(false);
        CharacterCreator.setLayout(null);
        CharacterCreator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        CharacterCreator.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Male = true;
            }
        });

        JPanel CharacterCreatorPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(100,100,100)); 
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        CharacterCreatorPanel.setBounds(0, 0, 700, 500);
        CharacterCreatorPanel.setLayout(null);

        JButton MaleButton = new JButton();
        JButton FemaleButton = new JButton();

        JButton SkinColorRight = new JButton();
        JButton SkinColorLeft = new JButton();
        final int[] SkinColor = {0};

        JButton HairColorRight = new JButton();
        JButton HairColorLeft = new JButton();
        final int[] HairColor = {0};

        JButton RobeColorRight = new JButton();
        JButton RobeColorLeft = new JButton();   
        final int[] RobeColor = {0};

        JButton EyeColorRight = new JButton();
        JButton EyeColorLeft = new JButton();
        final int[] EyeColor = {0};  

        JButton Start = new JButton();
        JTextField Name = new JTextField();
        JLabel CharacterCreatorLabel = new JLabel();
        JLabel SkinPreview = new JLabel();        
        JLabel HairPreview = new JLabel();
        JLabel RobePreview = new JLabel();
        JLabel EyePreview = new JLabel();      
        
        CharacterCreatorLabel.setIcon(new ImageIcon("Images/CharacterCreator/CharacterCreator.png"));
        CharacterCreatorLabel.setBounds(0, 0, 700, 500);
        CharacterCreatorPanel.add(CharacterCreatorLabel);

        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String PlayerName = Name.getText();
                if(PlayerName.equals("")) {
                    JOptionPane.showMessageDialog(CharacterCreator, "Please name your character", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    Player MainCharacter = new Player(PlayerName, SkinColor[0], HairColor[0], RobeColor[0], Male);
                    MainCharacter.addElementBonuses(EyeColor[0], 25);
                    new GameView(MainCharacter);
                    CharacterCreator.dispose();
                    MainMenu.dispose();
                }
            }
        });
        Start.setBounds(275, 425, 150, 35);
        Start.setIcon(new ImageIcon("Images/CharacterCreator/Start.png"));
        CharacterCreatorPanel.add(Start);

        String[] HairPath = {"Images/CharacterCreator/MaleHair0.png"};
        
        FemaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Male = false;

                //Extract the hairstyle number in order to convert it to opposite gender.
                String HairStylePath = ("Images/CharacterCreator/FemaleHair" + (HairPath[0].split("/")[2].split("\\.")[0].replaceAll("[^0-9]", "")) + ".png");
                HairPreview.setIcon(new ImageIcon(HairStylePath));
                
                FemaleButton.setIcon(new ImageIcon("Images/CharacterCreator/FemaleSelected.png"));
                MaleButton.setIcon(new ImageIcon("Images/CharacterCreator/Male.png"));
            }
        });
        FemaleButton.setIcon(new ImageIcon("Images/CharacterCreator/Female.png"));
        FemaleButton.setPressedIcon(new ImageIcon("Images/CharacterCreator/FemalePressed.png"));
        FemaleButton.setBounds(540, 75, 50, 50);
        CharacterCreatorPanel.add(FemaleButton);

        MaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Male = true;

                //Extract the hairstyle number in order to convert it to opposite gender.
                String HairStylePath = ("Images/CharacterCreator/MaleHair" + (HairPath[0].split("/")[2].split("\\.")[0].replaceAll("[^0-9]", "")) + ".png");
                HairPreview.setIcon(new ImageIcon(HairStylePath));

                MaleButton.setIcon(new ImageIcon("Images/CharacterCreator/MaleSelected.png"));
                FemaleButton.setIcon(new ImageIcon("Images/CharacterCreator/Female.png"));
            }
        });
        MaleButton.setIcon(new ImageIcon("Images/CharacterCreator/MaleSelected.png"));
        MaleButton.setPressedIcon(new ImageIcon("Images/CharacterCreator/MalePressed.png"));
        MaleButton.setBounds(605, 75, 50, 50);
        CharacterCreatorPanel.add(MaleButton);

        EyePreview.setBounds(250, 100, 200, 200);
        EyePreview.setIcon(new ImageIcon("Images/CharacterCreator/Eyes0.png"));
        CharacterCreatorPanel.add(EyePreview);
        EyeColorLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(EyeColor[0] != 0) {
                    EyeColor[0] --;
                    EyeColorRight.setIcon(new ImageIcon("Images/CharacterCreator/ArrowRight.png"));
                    if(EyeColor[0] == 0) {
                        EyeColorLeft.setIcon(new ImageIcon("Images/CharacterCreator/ArrowLeftGrayed.png"));
                    }
                String EyePath = ("Images/CharacterCreator/Eyes" + EyeColor[0] + ".png");
                EyePreview.setIcon(new ImageIcon(EyePath));
                }           
            }
        });
        EyeColorLeft.setIcon(new ImageIcon("Images/CharacterCreator/ArrowLeftGrayed.png"));
        EyeColorLeft.setBounds(540, 377, 50, 50);
        CharacterCreatorPanel.add(EyeColorLeft);

        EyeColorRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(EyeColor[0] != 3) {
                    EyeColor[0] ++;
                    EyeColorLeft.setIcon(new ImageIcon("Images/CharacterCreator/ArrowLeft.png"));
                    if(EyeColor[0] == 3) {
                        EyeColorRight.setIcon(new ImageIcon("Images/CharacterCreator/ArrowRightGrayed.png"));
                    }
                String EyePath = ("Images/CharacterCreator/Eyes" + EyeColor[0] + ".png");
                EyePreview.setIcon(new ImageIcon(EyePath));
                }    
            }
        });
        EyeColorRight.setIcon(new ImageIcon("Images/CharacterCreator/ArrowRight.png"));
        EyeColorRight.setBounds(605, 377, 50, 50);
        CharacterCreatorPanel.add(EyeColorRight);


        RobePreview.setBounds(250, 100, 200, 200);
        RobePreview.setIcon(new ImageIcon("Images/CharacterCreator/Robe0.png"));
        CharacterCreatorPanel.add(RobePreview);
        RobeColorLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(RobeColor[0] != 0) {
                    RobeColor[0] --;
                    RobeColorRight.setIcon(new ImageIcon("Images/CharacterCreator/ArrowRight.png"));
                    if(RobeColor[0] == 0) {
                        RobeColorLeft.setIcon(new ImageIcon("Images/CharacterCreator/ArrowLeftGrayed.png"));
                    }
                String RobePath = ("Images/CharacterCreator/Robe" + RobeColor[0] + ".png");
                RobePreview.setIcon(new ImageIcon(RobePath));
                }
                
            }
        });
        RobeColorLeft.setIcon(new ImageIcon("Images/CharacterCreator/ArrowLeftGrayed.png"));
        RobeColorLeft.setBounds(540, 302, 50, 50);
        CharacterCreatorPanel.add(RobeColorLeft);

        RobeColorRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(RobeColor[0] != 7) {
                    RobeColor[0] ++;
                    RobeColorLeft.setIcon(new ImageIcon("Images/CharacterCreator/ArrowLeft.png"));
                    if(RobeColor[0] == 7) {
                        RobeColorRight.setIcon(new ImageIcon("Images/CharacterCreator/ArrowRightGrayed.png"));
                    }
                String RobePath = ("Images/CharacterCreator/Robe" + RobeColor[0] + ".png");
                RobePreview.setIcon(new ImageIcon(RobePath));
                }
                
            }
        });
        RobeColorRight.setIcon(new ImageIcon("Images/CharacterCreator/ArrowRight.png"));
        RobeColorRight.setBounds(605, 302, 50, 50);
        CharacterCreatorPanel.add(RobeColorRight);
        

        HairPreview.setBounds(250, 100, 200, 200);
        HairPreview.setIcon(new ImageIcon(HairPath[0]));
        CharacterCreatorPanel.add(HairPreview);
        HairColorLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(HairColor[0] != 0) {
                    HairColor[0] --;
                    HairColorRight.setIcon(new ImageIcon("Images/CharacterCreator/ArrowRight.png"));
                    if(HairColor[0] == 0) {
                        HairColorLeft.setIcon(new ImageIcon("Images/CharacterCreator/ArrowLeftGrayed.png"));
                    }
                    String Gender = "MaleHair";
                if(!Male) {
                    Gender = "FemaleHair";
                }
                HairPath[0] = ("Images/CharacterCreator/"+ Gender + HairColor[0] + ".png");
                HairPreview.setIcon(new ImageIcon(HairPath[0]));
                }      
            }
        });
        HairColorLeft.setIcon(new ImageIcon("Images/CharacterCreator/ArrowLeftGrayed.png"));
        HairColorLeft.setBounds(540, 227, 50, 50);
        CharacterCreatorPanel.add(HairColorLeft);

        HairColorRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(HairColor[0] != 6) {
                    HairColor[0] ++;
                    HairColorLeft.setIcon(new ImageIcon("Images/CharacterCreator/ArrowLeft.png"));
                    if(HairColor[0] == 6) {
                        HairColorRight.setIcon(new ImageIcon("Images/CharacterCreator/ArrowRightGrayed.png"));
                    }
                String Gender = "MaleHair";
                if(!Male) {
                    Gender = "FemaleHair";
                }
                HairPath[0] = ("Images/CharacterCreator/"+ Gender + HairColor[0] + ".png");
                HairPreview.setIcon(new ImageIcon(HairPath[0]));
                }              
            }
        });
        HairColorRight.setIcon(new ImageIcon("Images/CharacterCreator/ArrowRight.png"));
        HairColorRight.setBounds(605, 227, 50, 50);
        CharacterCreatorPanel.add(HairColorRight);


        SkinPreview.setBounds(250, 100, 200, 200);
        SkinPreview.setIcon(new ImageIcon("Images/CharacterCreator/Skin0.png"));
        CharacterCreatorPanel.add(SkinPreview);
        SkinColorLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SkinColor[0] != 0) {
                    SkinColor[0] --;
                    SkinColorRight.setIcon(new ImageIcon("Images/CharacterCreator/ArrowRight.png"));
                    if(SkinColor[0] == 0) {
                        SkinColorLeft.setIcon(new ImageIcon("Images/CharacterCreator/ArrowLeftGrayed.png"));
                    }
                String SkinPath = ("Images/CharacterCreator/Skin" + SkinColor[0] + ".png");
                SkinPreview.setIcon(new ImageIcon(SkinPath));
                }
                
            }
        });
        SkinColorLeft.setIcon(new ImageIcon("Images/CharacterCreator/ArrowLeftGrayed.png"));
        SkinColorLeft.setBounds(540, 152, 50, 50);
        CharacterCreatorPanel.add(SkinColorLeft);

        SkinColorRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SkinColor[0] != 5) {
                    SkinColor[0] ++;
                    SkinColorLeft.setIcon(new ImageIcon("Images/CharacterCreator/ArrowLeft.png"));
                    if(SkinColor[0] == 5) {
                        SkinColorRight.setIcon(new ImageIcon("Images/CharacterCreator/ArrowRightGrayed.png"));
                    }
                String SkinPath = ("Images/CharacterCreator/Skin" + SkinColor[0] + ".png");
                SkinPreview.setIcon(new ImageIcon(SkinPath));
                }
                
            }
        });
        SkinColorRight.setIcon(new ImageIcon("Images/CharacterCreator/ArrowRight.png"));
        SkinColorRight.setBounds(605, 152, 50, 50);
        CharacterCreatorPanel.add(SkinColorRight);


        Name.setBounds(275, 380, 150, 35);
        CharacterCreatorPanel.add(Name);
        
        CharacterCreator.add(CharacterCreatorPanel);
        CharacterCreator.setVisible(true);
    }
}   
