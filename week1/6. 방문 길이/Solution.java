
import java.util.ArrayList;
import java.util.List;

/*
    6. 방문 길이
    https://programmers.co.kr/learn/courses/30/lessons/49994
*/
class Solution6 {

    public static void main(String[] args) {

        String dirs = "ULURRDLLU";

        System.out.println(solution(dirs));
    }

    public static int solution(String dirs) {

        List<Position> visitedList = new ArrayList<>();
        int exceptCount = 0;
        Position currentPosition = new Position(0, 0);
        visitedList.add(new Position(0, 0));

        for (String direction : dirs.split("")) {

            switch (direction) {
                case "U":
                    if (currentPosition.getY() >= 5) {
                        break;
                    }
                    currentPosition.addY(1);
                    break;
                case "D":
                    if (currentPosition.getY() <= -5) {
                        break;
                    }
                    currentPosition.addY(-1);
                    break;
                case "R":
                    if (currentPosition.getX() >= 5) {
                        break;
                    }
                    currentPosition.addX(1);
                    break;
                case "L":
                    if (currentPosition.getX() <= -5) {
                        break;
                    }
                    currentPosition.addX(-1);
                    break;
                default:
                    break;
            }

            Position newPosition = new Position(currentPosition.getX(), currentPosition.getY());

            System.out.println(newPosition.toString());

            if (!visitedList.contains(newPosition)) {
                visitedList.add(newPosition);
            }

        }

        // for (Position position : visitedList) {
        // if (position.getX() >= -5 || position.getX() >= 5 || position.getY() >= -5 ||
        // position.getY() >= 5) {
        // ignoreSection++;
        // }
        // }

        System.out.println(visitedList.toString());

        return visitedList.size() + exceptCount;
    }

}

class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addX(int x) {
        this.x += x;
    }

    public void addY(int y) {
        this.y += y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Position) && ((Position) obj).getX() == this.getX()
                && ((Position) obj).getY() == this.getY();
    }

    @Override
    public String toString() {
        return "[" + this.x + ":" + this.y + "]";
    }
}
