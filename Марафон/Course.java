public class Course {
    Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        Competitor[] teamMembers = team.dreamteam;
        if (teamMembers.length > 0) {
            for (Competitor c : teamMembers) {
                for (Obstacle o : obstacles) {
                    o.doIt(c);
                    if (!c.onDistance()) break;
                }
            }
        }
    }

}