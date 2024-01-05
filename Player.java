public class Player {
    private int PlayerHitpoints;
    private String PlayerName;
    private int SkinColor;
    private int HairColor;
    private int RobeColor;
    private boolean Male;
    private int[] ElementBonuses;

    public Player(String PlayerName, int SkinColor, int HairColor, int RobeColor, boolean Male) {
        PlayerHitpoints = 100;
        this.PlayerName = PlayerName;
        this.SkinColor = SkinColor;
        this.HairColor = HairColor;
        this.RobeColor = RobeColor;
        this.Male = Male;
        ElementBonuses = new int[]{100,100,100,100};
        
    }

    //Setters, Getters.
    public void addElementBonuses(int element, int amount) {
        this.ElementBonuses[element] += amount;
    }
    public int getPlayerHitpoints() {
        return PlayerHitpoints;
    }
    public int getSkinColor() {
        return SkinColor;
    }
    public int getHairColor() {
        return HairColor;
    }
    public int getRobeColor() {
        return RobeColor;
    }
    public String getPlayerName() {
        return PlayerName;
    }
    public Boolean getMale() {
        return Male;
    }
}
