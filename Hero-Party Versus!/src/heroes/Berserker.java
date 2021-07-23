package heroes;

import game.Team;

public class Berserker extends Hero{
    protected static int BERSERKER_HIT_POINTS = 30;
    protected static int DAMAGE_AMOUNT = 20;
    private Team team;

    /**
     * Create a Berserker
     * @param team the team of the berserker.
     */
    public Berserker(Team team){
        super(Heroes.getName(team, Heroes.Role.BERSERKER), BERSERKER_HIT_POINTS);
    }

    /**
     * Smack an enemy for max damage.
     * @param enemy the enemy to attack
     */
    public void attack(Hero enemy){
        enemy.takeDamage(DAMAGE_AMOUNT);
    }

    /**
     * Gives the role of the hero
     * @return They're a berserker
     */
    public Heroes.Role getRole(){
        return Heroes.Role.BERSERKER;
    }
}
