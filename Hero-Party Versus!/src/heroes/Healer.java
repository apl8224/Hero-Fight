package heroes;

import game.HeroParty;
import game.Team;

public class Healer extends Hero {
    protected static int HEALER_HIT_POINTS = 35;
    protected static int HEAL_AMOUNT = 10;
    protected static int DAMAGE_AMOUNT = 10;

    private Team team;
    private Party party;

    /**
     * Create a healer.
     * @param team the team of the healer
     * @param party the party of that team
     */
    protected Healer(Team team, Party party){
        super(Heroes.getName(team, Heroes.Role.HEALER), HEALER_HIT_POINTS);
        this.team = team;
        this.party = party;
    }

    /**
     * When a healer attacks, they first heal themselves,
     * then the rest of their party,
     * and then they attack the enemy with their maximum damage.
     * @param enemy the enemy to attack
     */
    public void attack(Hero enemy){
        this.heal(HEAL_AMOUNT);
        for (Hero item: party.getHeroes()){
                item.heal(HEAL_AMOUNT);
        }
        enemy.takeDamage(DAMAGE_AMOUNT);
    }

    /**
     *
     * Get this heroes role.
     * @return They're a healer.
     */
    public Heroes.Role getRole(){
        return Heroes.Role.HEALER;
    }

}
