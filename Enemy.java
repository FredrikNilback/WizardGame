public class Enemy {
    private String EnemyName;
    private int EnemyHitPoints;
    private int[] EnemyAttack;
    private int[] EnemyResistances;

    public Enemy(String EnemyName, int EnemyHitPoints, int[] EnemyAttack, int[] EnemyResistances) {
        this.EnemyName = EnemyName;
        this.EnemyHitPoints = EnemyHitPoints;
        this.EnemyAttack = EnemyAttack;
        this.EnemyResistances = EnemyResistances;
    }

    public boolean checkDead() {
        return (EnemyHitPoints <= 0);
    }

    public void castOn(Spell spell) {
        this.EnemyHitPoints -= spell.getPower();
    }
     


    //getters
    public int[] getEnemyAttack() {
        return EnemyAttack;
    }
    public int getEnemyHitPoints() {
        return EnemyHitPoints;
    }
    public String getEnemyName() {
        return EnemyName;
    }
    public int[] getEnemyResistances() {
        return EnemyResistances;
    }
}
