import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView {

    boolean Male;
    Player player;
    int SkinColor;
    int HairColor;
    int RobeColor;
    
    JFrame GameFrame = new JFrame();
    JPanel CharacterPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(100,100,100));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };
    JLabel MainCharacterSkin = new JLabel();
    JLabel MainCharacterHair = new JLabel();
    JLabel MainCharacterRobe = new JLabel();
    JLabel MainCharacterHealth = new JLabel();

    JPanel MonsterPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(100,100,100));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };
    JLabel CurrentMonster = new JLabel();
    JLabel CurrentMonsterHealth = new JLabel();
    

    JPanel AbilityPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(255,255,255)); 
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };
    JButton Fire = new JButton();
    JButton Water = new JButton();
    JButton Air = new JButton();
    JButton Earth = new JButton();
    JButton Enemy = new JButton();
    JButton Self = new JButton();

    JLabel Element1 = new JLabel();
    JLabel Element2 = new JLabel();
    JLabel Element3 = new JLabel();

    JLabel AbilityPanelFrame = new JLabel();
    

    public GameView(Player player) {
        this.player = player;
        this.Male = player.getMale();
        this.SkinColor = player.getSkinColor();
        this.HairColor = player.getHairColor();
        this.RobeColor = player.getRobeColor();
        
        GameFrame.setSize(1200,900);
        GameFrame.setLayout(null);

        setMonster(new Enemy("Goblin", 50, new int[] {4,10}, new int[]{0,0,0,0}));

        //Character Panel
        CharacterPanel.setLayout(null);
        CharacterPanel.setBounds(0, 350, 300, 525);
        MainCharacterSkin.setBounds(0, 25, 300, 500);
        MainCharacterHair.setBounds(0, 25, 300, 500);
        MainCharacterRobe.setBounds(0, 25, 300, 500);

        if(Male) {
            switch(HairColor) {
                case 0: MainCharacterHair.setIcon(new ImageIcon("Images/Character/MaleHair0.png")); break;               
                case 1: MainCharacterHair.setIcon(new ImageIcon("Images/Character/MaleHair1.png")); break;                
                case 2: MainCharacterHair.setIcon(new ImageIcon("Images/Character/MaleHair2.png")); break;
                case 3: MainCharacterHair.setIcon(new ImageIcon("Images/Character/MaleHair3.png")); break;
                case 4: MainCharacterHair.setIcon(new ImageIcon("Images/Character/MaleHair4.png")); break;
                case 5: MainCharacterHair.setIcon(new ImageIcon("Images/Character/MaleHair5.png")); break;
                case 6: MainCharacterHair.setIcon(new ImageIcon("Images/Character/MaleHair6.png")); break;  
                default: break;              
            }
            CharacterPanel.add(MainCharacterHair);
        }
        else {
            switch(HairColor) {
                case 0: MainCharacterHair.setIcon(new ImageIcon("Images/Character/FemaleHair0.png")); break;               
                case 1: MainCharacterHair.setIcon(new ImageIcon("Images/Character/FemaleHair1.png")); break;                
                case 2: MainCharacterHair.setIcon(new ImageIcon("Images/Character/FemaleHair2.png")); break;
                case 3: MainCharacterHair.setIcon(new ImageIcon("Images/Character/FemaleHair3.png")); break;
                case 4: MainCharacterHair.setIcon(new ImageIcon("Images/Character/FemaleHair4.png")); break;
                case 5: MainCharacterHair.setIcon(new ImageIcon("Images/Character/FemaleHair5.png")); break;
                case 6: MainCharacterHair.setIcon(new ImageIcon("Images/Character/FemaleHair6.png")); break;  
                default: break;              
            }
            CharacterPanel.add(MainCharacterHair);
        }

        switch(RobeColor) {
            case 0: MainCharacterRobe.setIcon(new ImageIcon("Images/Character/RobeColor0.png")); break;
            case 1: MainCharacterRobe.setIcon(new ImageIcon("Images/Character/RobeColor1.png")); break;
            case 2: MainCharacterRobe.setIcon(new ImageIcon("Images/Character/RobeColor2.png")); break;
            case 3: MainCharacterRobe.setIcon(new ImageIcon("Images/Character/RobeColor3.png")); break;
            case 4: MainCharacterRobe.setIcon(new ImageIcon("Images/Character/RobeColor4.png")); break;
            case 5: MainCharacterRobe.setIcon(new ImageIcon("Images/Character/RobeColor5.png")); break;
            case 6: MainCharacterRobe.setIcon(new ImageIcon("Images/Character/RobeColor6.png")); break;
            case 7: MainCharacterRobe.setIcon(new ImageIcon("Images/Character/RobeColor7.png")); break;
            default: break;
        }
        CharacterPanel.add(MainCharacterRobe);

        switch(SkinColor) {
            case 0: MainCharacterSkin.setIcon(new ImageIcon("Images/Character/SkinColor0.png")); break;
            case 1: MainCharacterSkin.setIcon(new ImageIcon("Images/Character/SkinColor1.png")); break;            
            case 2: MainCharacterSkin.setIcon(new ImageIcon("Images/Character/SkinColor2.png")); break;
            case 3: MainCharacterSkin.setIcon(new ImageIcon("Images/Character/SkinColor3.png")); break;
            case 4: MainCharacterSkin.setIcon(new ImageIcon("Images/Character/SkinColor4.png")); break;
            case 5: MainCharacterSkin.setIcon(new ImageIcon("Images/Character/SkinColor5.png")); break;            
            default: break;
        }
        CharacterPanel.add(MainCharacterSkin);

        
        MainCharacterHealth.setOpaque(false);
        MainCharacterHealth.setForeground(new Color(0,200,0));
        MainCharacterHealth.setText("HP: " + player.getPlayerHitpoints());
        MainCharacterHealth.setBounds(110, 0, 100, 25);
        CharacterPanel.add(MainCharacterHealth);

        
        //End of Character Panel
        //Monster Panel
        MonsterPanel.setLayout(null);
        MonsterPanel.setBounds(400, 25, 700, 500);
        CurrentMonster.setBounds(0, 0, 700, 500);
        MonsterPanel.add(CurrentMonster);

        //End of Monster Panel
        //Ability Panel
        AbilityPanel.setLayout(null);
        AbilityPanel.setBounds(400,615,450,250);
        AbilityPanelFrame.setIcon(new ImageIcon("Images/SpellBook/AbilityPanelFrame.png"));
        AbilityPanelFrame.setBounds(0, 0, 450, 250);
        AbilityPanel.add(AbilityPanelFrame);

        Element1.setBounds(250, 150, 50, 50);
        Element2.setBounds(250, 100, 50, 50);
        Element3.setBounds(250, 50, 50, 50);
        resetSelectedElements();
        AbilityPanel.add(Element1);
        AbilityPanel.add(Element2);
        AbilityPanel.add(Element3);

        Air.setIcon(new ImageIcon("Images/SpellBook/Air.png"));
        Air.setRolloverIcon(new ImageIcon("Images/SpellBook/AirRollOver.png"));
        Air.setBounds(22, 25, 100, 100);
        Air.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon IIE1 = (ImageIcon) Element1.getIcon(); 
                ImageIcon IIE2 = (ImageIcon) Element2.getIcon(); 
                ImageIcon IIE3 = (ImageIcon) Element3.getIcon(); 
                if(IIE1.getDescription().equals("Images/SpellBook/SelectedNone.png")) {
                    setElement1(1);
                }
                else if(IIE2.getDescription().equals("Images/SpellBook/SelectedNone.png")) {
                    setElement2(1);
                }
                else if(IIE3.getDescription().equals("Images/SpellBook/SelectedNone.png")){
                    setElement3(1);
                    spellReady();
                }
                else {
                    System.out.println("Cast the spell dummy");
                }
            }
        });
        AbilityPanel.add(Air);

        Water.setIcon(new ImageIcon("Images/SpellBook/Water.png"));
        Water.setRolloverIcon(new ImageIcon("Images/SpellBook/WaterRollOver.png"));
        Water.setBounds(122,25,100,100);
        Water.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon IIE1 = (ImageIcon) Element1.getIcon(); 
                ImageIcon IIE2 = (ImageIcon) Element2.getIcon(); 
                ImageIcon IIE3 = (ImageIcon) Element3.getIcon(); 
                if(IIE1.getDescription().equals("Images/SpellBook/SelectedNone.png")) {
                    setElement1(2);
                }
                else if(IIE2.getDescription().equals("Images/SpellBook/SelectedNone.png")) {
                    setElement2(2);
                }
                else if(IIE3.getDescription().equals("Images/SpellBook/SelectedNone.png")){
                    setElement3(2);
                    spellReady();
                }
                else {
                    System.out.println("Cast the spell dummy");
                }
            }
        });
        AbilityPanel.add(Water);

        Earth.setIcon(new ImageIcon("Images/SpellBook/Earth.png"));
        Earth.setRolloverIcon(new ImageIcon("Images/SpellBook/EarthRollOver.png"));
        Earth.setBounds(22, 125, 100, 100);
        Earth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon IIE1 = (ImageIcon) Element1.getIcon(); 
                ImageIcon IIE2 = (ImageIcon) Element2.getIcon(); 
                ImageIcon IIE3 = (ImageIcon) Element3.getIcon(); 
                if(IIE1.getDescription().equals("Images/SpellBook/SelectedNone.png")) {
                    setElement1(3);
                }
                else if(IIE2.getDescription().equals("Images/SpellBook/SelectedNone.png")) {
                    setElement2(3);
                }
                else if(IIE3.getDescription().equals("Images/SpellBook/SelectedNone.png")){
                    setElement3(3);
                    spellReady();
                }
                else {
                    System.out.println("Cast the spell dummy");
                }
            }
        });
        AbilityPanel.add(Earth);

        Fire.setIcon(new ImageIcon("Images/SpellBook/Fire.png"));
        Fire.setRolloverIcon(new ImageIcon("Images/SpellBook/FireRollOver.png"));
        Fire.setBounds(122, 125, 100, 100);
        Fire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon IIE1 = (ImageIcon) Element1.getIcon(); 
                ImageIcon IIE2 = (ImageIcon) Element2.getIcon(); 
                ImageIcon IIE3 = (ImageIcon) Element3.getIcon(); 
                if(IIE1.getDescription().equals("Images/SpellBook/SelectedNone.png")) {
                    setElement1(4);
                }
                else if(IIE2.getDescription().equals("Images/SpellBook/SelectedNone.png")) {
                    setElement2(4);
                }
                else if(IIE3.getDescription().equals("Images/SpellBook/SelectedNone.png")){
                    setElement3(4);
                    spellReady();
                }
                else {
                    System.out.println("Cast the spell dummy");
                }
            }
        });
        AbilityPanel.add(Fire);

        Self.setIcon(new ImageIcon("Images/SpellBook/Self.png"));
        Self.setRolloverIcon(new ImageIcon("Images/SpellBook/SelfRollOver.png"));
        Self.setBounds(325, 25, 100, 100);
        Self.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon IIE3 = (ImageIcon) Element3.getIcon();
                if (!(IIE3.getDescription().equals("Images/SpellBook/SelectedNone.png"))) {
                    resetSelectedElements();
                }
                
            }
        });
        AbilityPanel.add(Self);

        Enemy.setIcon(new ImageIcon("Images/SpellBook/Enemy.png"));
        Enemy.setRolloverIcon(new ImageIcon("Images/SpellBook/EnemyRollOver.png"));
        Enemy.setBounds(325, 125, 100, 100);
        Enemy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon IIE3 = (ImageIcon) Element3.getIcon();
                if (!(IIE3.getDescription().equals("Images/SpellBook/SelectedNone.png"))) {
                    resetSelectedElements();
                }
            }
        });
        AbilityPanel.add(Enemy);
        
        
        //End of Ability Panel

        GameFrame.add(AbilityPanel);
        GameFrame.add(CharacterPanel);
        GameFrame.add(MonsterPanel);
        GameFrame.setVisible(true);
        GameFrame.setResizable(false);
        GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void resetSelectedElements() {
        setElement1(0);
        setElement2(0);
        setElement3(0);
    }

    private void setElement1(int element) {
        switch (element) {
            case 0:
                Element1.setIcon(new ImageIcon("Images/SpellBook/SelectedNone.png"));
                break;
            case 1:
                Element1.setIcon(new ImageIcon("Images/SpellBook/SelectedAir.png"));
                break;
            case 2:
                Element1.setIcon(new ImageIcon("Images/SpellBook/SelectedWater.png"));
                break;
            case 3:
                Element1.setIcon(new ImageIcon("Images/SpellBook/SelectedEarth.png"));
                break;
            case 4:
                Element1.setIcon(new ImageIcon("Images/SpellBook/SelectedFire.png"));
                break;
        
            default:
                break;
        }
    }

    private void setElement2(int element) {
        switch (element) {
            case 0:
                Element2.setIcon(new ImageIcon("Images/SpellBook/SelectedNone.png"));
                break;
            case 1:
                Element2.setIcon(new ImageIcon("Images/SpellBook/SelectedAir.png"));
                break;
            case 2:
                Element2.setIcon(new ImageIcon("Images/SpellBook/SelectedWater.png"));
                break;
            case 3:
                Element2.setIcon(new ImageIcon("Images/SpellBook/SelectedEarth.png"));
                break;
            case 4:
                Element2.setIcon(new ImageIcon("Images/SpellBook/SelectedFire.png"));
                break;
        
            default:
                break;
        }
    }

    private void setElement3(int element) {
        switch (element) {
            case 0:
                Element3.setIcon(new ImageIcon("Images/SpellBook/SelectedNone.png"));
                break;
            case 1:
                Element3.setIcon(new ImageIcon("Images/SpellBook/SelectedAir.png"));
                break;
            case 2:
                Element3.setIcon(new ImageIcon("Images/SpellBook/SelectedWater.png"));
                break;
            case 3:
                Element3.setIcon(new ImageIcon("Images/SpellBook/SelectedEarth.png"));
                break;
            case 4:
                Element3.setIcon(new ImageIcon("Images/SpellBook/SelectedFire.png"));
                break;
        
            default:
                break;
        }
    }

    private void spellReady() {
        ImageIcon IIE1 = (ImageIcon) Element1.getIcon(); 
        ImageIcon IIE2 = (ImageIcon) Element2.getIcon(); 
        ImageIcon IIE3 = (ImageIcon) Element3.getIcon(); 

        String SE1 = IIE1.getDescription();
        String SE2 = IIE2.getDescription();
        String SE3 = IIE3.getDescription();

        switch (SE1) {
            case "Images/SpellBook/SelectedAir.png":
                Element1.setIcon(new ImageIcon("Images/SpellBook/SelectedAirReady.png"));
                break;
            case "Images/SpellBook/SelectedWater.png":
                Element1.setIcon(new ImageIcon("Images/SpellBook/SelectedWaterReady.png"));
                break;
            case "Images/SpellBook/SelectedEarth.png":
                Element1.setIcon(new ImageIcon("Images/SpellBook/SelectedEarthReady.png"));
                break;
            case "Images/SpellBook/SelectedFire.png":
                Element1.setIcon(new ImageIcon("Images/SpellBook/SelectedFireReady.png"));
                break;
        
            default:
                break;
        }
        switch (SE2) {
            case "Images/SpellBook/SelectedAir.png":
                Element2.setIcon(new ImageIcon("Images/SpellBook/SelectedAirReady.png"));
                break;
            case "Images/SpellBook/SelectedWater.png":
                Element2.setIcon(new ImageIcon("Images/SpellBook/SelectedWaterReady.png"));
                break;
            case "Images/SpellBook/SelectedEarth.png":
                Element2.setIcon(new ImageIcon("Images/SpellBook/SelectedEarthReady.png"));
                break;
            case "Images/SpellBook/SelectedFire.png":
                Element2.setIcon(new ImageIcon("Images/SpellBook/SelectedFireReady.png"));
                break;
        
            default:
                break;
        }
        switch (SE3) {
            case "Images/SpellBook/SelectedAir.png":
                Element3.setIcon(new ImageIcon("Images/SpellBook/SelectedAirReady.png"));
                break;
            case "Images/SpellBook/SelectedWater.png":
                Element3.setIcon(new ImageIcon("Images/SpellBook/SelectedWaterReady.png"));
                break;
            case "Images/SpellBook/SelectedEarth.png":
                Element3.setIcon(new ImageIcon("Images/SpellBook/SelectedEarthReady.png"));
                break;
            case "Images/SpellBook/SelectedFire.png":
                Element3.setIcon(new ImageIcon("Images/SpellBook/SelectedFireReady.png"));
                break;
        
            default:
                break;
        }
    }

    public void setMonster(Enemy Monster) {
        String MonsterPath = ("Images/Monsters/" + Monster.getEnemyName() + ".png");
        CurrentMonster.setIcon(new ImageIcon(MonsterPath));
        CurrentMonsterHealth.setText("Hp: " + Monster.getEnemyHitPoints());
    }
}   

