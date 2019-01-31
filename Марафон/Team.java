import java.util.Random;

public class Team {
    private String teamName = "One";
    Competitor[] dreamteam = {
            new Dog("Jack", "black", 10, 1, 2),
            new Cat("Mag", "white", 10, 0, 3),
            new Turtle("Turtle", "green", 100, 10, 0),
            new Human("Rick", 8, 10, 2)
    };
    public Competitor[] OneTeam = new Competitor[4];
    Random rand = new Random();

    public Team(String teamName) {
        this.teamName = teamName;
        for (int i = 0; i < 4; i++) {
            int r = rand.nextInt(3);
            OneTeam[i] = dreamteam[r];
        }
    }

    public void infoTeam() {
        System.out.println("Команда: " + teamName);
        for (Competitor c : dreamteam) {
            System.out.println(c.toString());
        }

    }

    public void whoPass() {
        for (Competitor c : dreamteam) {
            if (c.onDistance()) {
                System.out.println(c.toString() + " Дистанция пройдена\n");
            } else {
                System.out.println(c.toString() + " Дистанция не пройдена\n");
            }
        }
    }

}
