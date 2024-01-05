public class Spell {
    private String Name;
    private boolean Damage;
    private int Power;
    private int Air;
    private int Water;
    private int Earth;
    private int Fire;
    private int AirBonus;
    private int WaterBonus;
    private int EarthBonus;    
    private int FireBonus;

    public Spell(int[] Elements, int[]Bonuses) {
        this.Air = Elements[0];
        this.Water = Elements[1];
        this.Earth = Elements[2];
        this.Fire = Elements[3];
        this.AirBonus = Bonuses[0];
        this.WaterBonus = Bonuses[1];
        this.EarthBonus = Bonuses[2];
        this.FireBonus = Bonuses[3];
        decideSpell();

    }

    private void decideSpell() {
        switch(this.Air) {
            case 3:
                this.Name = "Air Strike";
                this.Damage = true;
                this.Power = 3 * this.AirBonus;
                break;
            case 2: 
                if(this.Water == 1) {
                    this.Name = "Breath of Life";
                    this.Damage = false;
                    this.Power = this.WaterBonus / 4;
                }
                else if(this.Earth == 1) {
                    this.Name = "Tornado";
                    this.Damage = true;
                    this.Power = (this.AirBonus) + (this.EarthBonus);
                }
                else {
                    this.Name = "Lightning Strike";
                    this.Damage = true;
                    if(this.AirBonus >= 150 && this.FireBonus >= 150) {
                        this.Power = (3 * this.AirBonus) + (2 * this.FireBonus);
                    }
                    else {
                        this.Power = (this.AirBonus / 2) + (this.FireBonus / 2);
                    }
                }
        }
    }


    //getters
    public String getName() {
        return this.Name;
    }

    public int getPower() {
        if(this.Damage) {
            return this.Power;
        }
        return -this.Power;
    }

    
}
