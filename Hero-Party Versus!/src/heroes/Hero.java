package heroes;

import game.HeroParty;
import game.Team;

public abstract class Hero {

    private String name;
    private int hitPoints;

    /**
     * Creates a new hero
     * @param name
     * @param hitPoints
     */
    protected Hero(String name, int hitPoints){
        this.name = name;
        this.hitPoints = hitPoints;
    }

    /**
     *
     * Create a hero of a particular role for a certain team.
     * @param role The heroes party role
     * @param team the team they belong to
     * @param party the contents of that team
     * @return
     */
    public static Hero create(Heroes.Role role, Team team, Party party){
        if (role == Heroes.Role.BERSERKER) {
            return new Berserker(team);
        }
        if (role == Heroes.Role.TANK) {
            return new Tank(team);
        }
        return new Healer(team, party);
    }

    /**
     * A hero attacks an enemy.
     * @param enemy the enemy to attack
     */
    public abstract void attack(Hero enemy);

    /**
     *
     * Get the name of the hero.
     * @return the heroes name
     */
    public String getName(){
        return name;
    }

    /**
     * Get this heroes role.
     * @return This heroes role
     */
    public abstract Heroes.Role getRole();

    /**
     * A hero has sadly fallen when their hit points are 0.
     * @return if the hero has fallen
     */
    public boolean hasFallen(){
        if(hitPoints > 0){
            return false;
        }
        return true;
    }

    /**
     * Heal an individual hero by an amount
     * (but do not exceed the maximum hit points).
     * @param amount that the hero heals.
     */
    public void heal(int amount){
        System.out.print(this.getName() + " heals " + amount
                + " points" + System.getProperty("line.separator"));
        if(getRole() == Heroes.Role.BERSERKER){
            if(hitPoints < 20){
                hitPoints += amount;
            }else {
                hitPoints = 30;
            }
        }
        if(getRole() == Heroes.Role.HEALER){
            if(hitPoints < 25) {
                hitPoints += amount;
            }else{
                hitPoints = 35;
            }
        }
        if (getRole() == Heroes.Role.TANK) {
            if (hitPoints < 30) {
                hitPoints += amount;
            }else{
                hitPoints = 40;
            }
        }
    }

    /**
     * Our hero takes some damage.
     * @param amount the amount of damage the hero takes
     */
    public void takeDamage(int amount){
        System.out.print(getName() + " takes " + amount
                + " damage" + System.getProperty("line.separator"));
        if(hitPoints - amount < 0){
            hitPoints = 0;
        }else{
            hitPoints -= amount;
        }
    }

    /**
     * Return a string representation of the hero in the form:
     * {name}, {ROLE}, #/#
     * @return The formatted name of the hero.
     */
    @Override
    public String toString(){
         String temp = name + ", " + getRole().toString() + ", " + hitPoints + "/";
         if(getRole() == Heroes.Role.BERSERKER){
             return temp + "30";
         }
        if(getRole() == Heroes.Role.HEALER){
            return temp + "35";
        }
            return temp + "40";
    }
}
