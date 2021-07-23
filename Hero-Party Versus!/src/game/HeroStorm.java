package game;

import heroes.Hero;

public class HeroStorm {
    private HeroParty dragon;
    private HeroParty lion;
    private boolean turn = true;
    private Hero h1;
    private Hero h2;
    private int battle = 1;

    /**
     * Create a HeroStorm object
     * @param dragonSeed Seed to shuffle dragon team
     * @param lionSeed Seed to shuffle lion team
     */
    public HeroStorm(int dragonSeed, int lionSeed){
        this.dragon = new HeroParty(Team.DRAGON, dragonSeed);
        this.lion = new HeroParty(Team.LION, lionSeed);
        play();
    }

    /**
     * The main, that runs the program.
     * @param args Command line arguments
     */
    public static void main(String[] args){
         new HeroStorm(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    }

    /**
     * The game is played in battle rounds. A round is one attack between the
     * "front" heroes of the two teams who are temporarily removed from the party.
     * The first hero to attack alternates by round, starting with Team Dragon.
     * If the hero who is attacked is not defeated, they can attack the first hero
     * back. Afterwards each non-defeated hero is added to the back of their party
     * . Defeated heroes merely "disappear" with a farewell message about having
     * fallen. The rounds continue until one of the teams has all of their members
     * defeated. The other team is declared the winner.
     */
    public void play(){
        while (!dragon.getHeroes().isEmpty() && !lion.getHeroes().isEmpty()){

            System.out.println("Battle #" + battle);
            System.out.println("==========");
            System.out.println(dragon.toString());
            System.out.println(lion.toString());
            if (turn){
                this.h1 = dragon.removeHero();
                this.h2 = lion.removeHero();
            }else{
                this.h1 = lion.removeHero();
                this.h2 = dragon.removeHero();
            }
            System.out.println("*** " + h1.getName() + " vs " + h2.getName() + "!\n");
            h1.attack(h2);
            if (!h2.hasFallen()) {
                h2.attack(h1);
                if (turn) {
                    lion.addHero(h2);
                } else {
                    dragon.addHero(h2);
                }
            }else{
                System.out.println(h2.getName() + " has fallen!");
            }
            if (!h1.hasFallen()){
                if (turn){
                    dragon.addHero(h1);
                }else{
                    lion.addHero(h1);
                }
            }else{
                System.out.println(h1.getName() + " has fallen!");
            }
            System.out.println();
            battle += 1;
            turn = !turn;
        }

        if(!dragon.getHeroes().isEmpty()){
            System.out.println("Team Dragon wins!");
        }else{
            System.out.println("Team Lion wins!");
        }
    }
}
