package game;

import heroes.Hero;
import heroes.Heroes;
import heroes.Party;

import java.util.*;

public class HeroParty implements Party {

    private Team team;
    private LinkedList<Hero> party = new LinkedList<>();
    private List<Hero> temp = new ArrayList<>();
    private int heroes;

    /**
     * Create the party.
     * @param team The team of the party
     * @param seed the seed to shuffle them
     */
    public HeroParty(Team team, int seed){
        this.team = team;
        addHero(Hero.create(Heroes.Role.BERSERKER, team, this));
        addHero(Hero.create(Heroes.Role.HEALER, team, this));
        addHero(Hero.create(Heroes.Role.TANK, team, this));
        Collections.shuffle(party, new Random(seed));
    }

    /**
     * Add a hero to the back of the collection.
     * @param hero the new hero
     */
    public void addHero(Hero hero){
        party.addLast(hero);
        heroes += 1;
    }

    /**
     * Get all the undefeated heroes in the party.
     * @return the list of undefeated heroes.
     */
    public List<Hero> getHeroes(){
        if(!temp.isEmpty()){
            temp.clear();
        }
        for(Hero item: party){
            temp.add(item);
        }
        return temp;
    }

    /**
     * The team which this party is affiliated with.
     * @return the team
     */
    public Team getTeam(){
        return team;
    }

    /**
     * Remove the hero at the front of the collection.
     * @return the removed hero
     */
    public Hero removeHero(){
        if (heroes > 0){
            heroes -= 1;
        }
        return party.removeFirst();
    }

    /**
     *
     * Get the number of non-fallen heroes.
     * @return the number of heroes not fallen.
     */
    public int numHeroes(){
        return heroes;
    }

    /**
     *
     * Returns a string representation of the party.
     * @return the string to represent them.
     */
    public String toString(){
        String temp = team.toString() + "\n";
        for(Hero item: party) temp += item.toString() + "\n";

        return temp;
    }
}
