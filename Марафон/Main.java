public class Main {
    public static void main(String[] args) {
        Team team = new Team("one");
        team.infoTeam();
        Obstacle[] obstacles = {new Road(10), new Wall(2), new Water(1)};
        Course course = new Course(obstacles);
        course.doIt(team);
        team.whoPass();

    }
}