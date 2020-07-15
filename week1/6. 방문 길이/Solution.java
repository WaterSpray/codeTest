import java.util.*;

/*
    6. 방문 길이
    https://programmers.co.kr/learn/courses/30/lessons/49994
*/
public class Solution {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point moved(int dx, int dy) {
            return new Point(x + dx, y + dy);
        }

        public boolean isAvailable() {
            return -5 <= x && x <= 5 && -5 <= y && y <= 5;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    class Path {

        Point start;
        Point end;

        public Path(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Path path = (Path) o;
            return start.equals(path.start) && end.equals(path.end) || start.equals(path.end) && end.equals(path.start);
        }

        @Override
        public int hashCode() {
            return start.hashCode() + end.hashCode();
        }
    }

    public int solution(String dirs) {

        Point start = new Point(0, 0);

        Set<Path> route = new HashSet<>();

        for (char d : dirs.toCharArray()) {

            Point end = null;

            switch (d) {
                case 'U':
                    end = start.moved(0, 1);
                    break;
                case 'D':
                    end = start.moved(0, -1);
                    break;
                case 'L':
                    end = start.moved(-1, 0);
                    break;
                case 'R':
                    end = start.moved(1, 0);
                    break;
            }

            if (end == null)
                continue;
            ;
            if (!end.isAvailable())
                continue;

            route.add(new Path(start, end));
            start = end;

        }

        return route.size();
    }

}
