/*
 * 1. 하샤드 수
 * https://programmers.co.kr/learn/courses/30/lessons/12947
 */
class Solution {
  static solution = function (x) {
    const sum = String(x)
      .split("")
      .reduce((a, c) => {
        return Number(a) + Number(c);
      });

    return x % sum == 0 ? true : false;
  };
}

console.log(Solution.solution(24))