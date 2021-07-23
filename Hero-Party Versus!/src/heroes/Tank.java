package heroes;

import com.sun.source.tree.WhileLoopTree;
import game.Team;

public class Tank extends Hero {
    protected final static int TANK_HIT_POINTS = 40;
    protected final static double SHIELD_DMG_MULTIPLIER = .9;
    protected final static int DAMAGE_AMOUNT = 15;

    /**
     * Create a Tank.
     * @param team The team of the tank
     */
    protected Tank(Team team){
        super(Heroes.getName(team, Heroes.Role.TANK), TANK_HIT_POINTS);

    }

    /**
     * Smack the enemy for max damage
     * @param enemy the enemy to attack
     */
    public void attack(Hero enemy){
        enemy.takeDamage(DAMAGE_AMOUNT);
    }

    /**
     * Get the Hero's role.
     * @return They're a tank.
     */
    public Heroes.Role getRole(){
        return Heroes.Role.TANK;
    }

    @Override
    public void takeDamage(int amount){
        amount *= SHIELD_DMG_MULTIPLIER;
        super.takeDamage(amount);
    }
}
