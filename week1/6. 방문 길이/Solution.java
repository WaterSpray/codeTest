
import java.util.ArrayList;
import java.util.List;

/*
    6. 방문 길이
    https://programmers.co.kr/learn/courses/30/lessons/49994
*/
class Solution6 {
    public static void main(String[] args) {

        String dirs = "LULLLLLLU";
        System.out.println(solution(dirs));
    }

    public static int solution(String dirs) {

        Position currentPosition = new Position(0, 0, 0, 0);
        List<Position> visitedPositions = new ArrayList<>();

        for (String direction : dirs.split("")) {

            switch (direction) {
                case "U":
                    if (currentPosition.getCurrentY() >= 5) {
                        break;
                    }
                    currentPosition.addY(1);
                    break;
                case "D":
                    if (currentPosition.getCurrentY() <= -5) {
                        break;
                    }
                    currentPosition.addY(-1);
                    break;
                case "R":
                    if (currentPosition.getCurrentX() >= 5) {
                        break;
                    }
                    currentPosition.addX(1);
                    break;
                case "L":
                    if (currentPosition.getCurrentX() <= -5) {
                        break;
                    }
                    currentPosition.addX(-1);
                    break;
                default:
                    break;
            }

            Position nowPosition = currentPosition.positionFactory();

            if (!visitedPositions.contains(nowPosition)) {
                visitedPositions.add(nowPosition);
            }

        }

        return visitedPositions.size();
    }
}

class Position {

    private int beforeX;
    private int beforeY;
    private int currentX;
    private int currentY;

    public Position(int beforeX, int beforeY, int currentX, int currentY) {
        this.beforeX = beforeX;
        this.beforeY = beforeY;
        this.currentX = currentX;
        this.currentY = currentY;
    }

    public int getBeforeX() {
        return this.beforeX;
    }

    public int getBeforeY() {
        return this.beforeY;
    }

    public int getCurrentX() {
        return this.currentX;
    }

    public int getCurrentY() {
        return this.currentY;
    }

    public void addX(int x) {
        this.beforeX = this.currentX;
        this.beforeY = this.currentY;
        this.currentX += x;
    }

    public void addY(int y) {
        this.beforeX = this.currentX;
        this.beforeY = this.currentY;
        this.currentY += y;
    }

    public Position positionFactory() {
        return new Position(this.beforeX, this.beforeY, this.currentX, this.currentY);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Position && ((Position) obj).getBeforeX() == this.beforeX
                && ((Position) obj).getBeforeY() == this.beforeY && ((Position) obj).getCurrentX() == this.currentX
                && ((Position) obj).getCurrentY() == this.currentY) {
            return true;
        }

        if (obj instanceof Position && ((Position) obj).getBeforeX() == this.currentX
                && ((Position) obj).getBeforeY() == this.currentY && ((Position) obj).getCurrentX() == this.beforeX
                && ((Position) obj).getCurrentY() == this.beforeY) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "" + this.beforeX + ":" + this.beforeY + "[]" + this.currentX + ":" + this.currentY;
    }
}
