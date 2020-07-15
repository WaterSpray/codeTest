/*
    6. 방문 길이
    https://programmers.co.kr/learn/courses/30/lessons/49994
*/
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        return answer;
    }

    class Character {

        int x;
        int y;

        void up() {
            if (x < 5) {
                x += 1;
            }
        }

        void down() {
            if (x > -5) {
                x -= 1;
            }
        }

        void right() {
            if (y < 5) {
                y += 1;
            }
        }

        void left() {
            if (y > -5) {
                y -= 1;
            }
        }

        Character move(String command) {
            switch (command) {
                case U:
                    up();
                    break;
                case D:
                    down();
                    break;
                case R:
                    right();
                    break;
                case L:
                    left();
                    break;
            }
            return this;
        }

    }

}
