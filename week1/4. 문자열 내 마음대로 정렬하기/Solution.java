import java.util.Arrays;

/*
    4. 문자 내마음대로 정렬하기
    https://programmers.co.kr/learn/courses/30/lessons/12915
*/
class Solution4 {

    public static void main(String[] args) {

        Solution4 sol = new Solution4();

        String[] strArray = { "abce", "abcd", "cdx" };
        int nthChar = 2;

        sol.solution(strArray, nthChar);

    }

    public String[] solution(String[] strings, int n) {

        String[] tempStringArray = new String[strings.length];

        mergeSort(strings, 0, strings.length - 1, n, tempStringArray);

        System.out.println(Arrays.toString(strings));

        return strings;
    }

    public void mergeSort(String[] strArray, int start, int end, int n, String[] tempStringArray) {

        if (start < end) {

            int medium = (start + end) / 2;

            mergeSort(strArray, start, medium, n, tempStringArray);
            mergeSort(strArray, medium + 1, end, n, tempStringArray);

            int i = start;
            int j = medium + 1;
            int k = start;
            while (i <= medium && j <= end) {
                if (strArray[i].charAt(n) < strArray[j].charAt(n)) {

                    tempStringArray[k++] = strArray[i++];

                } else if (strArray[i].charAt(n) == strArray[j].charAt(n)) {

                    int tempIndexDownCount = 1;
                    int tempIndexUpperCount = 1;

                    boolean isFinished = false;

                    while ((n - tempIndexDownCount) != 0) {
                        if (strArray[i].charAt(n - tempIndexDownCount) < strArray[j].charAt(n - tempIndexDownCount)) {

                            tempStringArray[k++] = strArray[i++];
                            isFinished = true;
                            break;
                        } else if (strArray[i].charAt(n - tempIndexDownCount) == strArray[j]
                                .charAt(n - tempIndexDownCount)) {

                        } else {
                            tempStringArray[k++] = strArray[j++];
                        }

                        ++tempIndexDownCount;

                    }

                    while (!isFinished && (n + tempIndexUpperCount) != strArray[i].length() - 1) {
                        if (strArray[i].charAt(n + tempIndexUpperCount) < strArray[j].charAt(n + tempIndexUpperCount)) {

                            tempStringArray[k++] = strArray[i++];
                            isFinished = true;
                            break;
                        } else if (strArray[i].charAt(n + tempIndexUpperCount) == strArray[j]
                                .charAt(n + tempIndexUpperCount)) {

                        } else {
                            tempStringArray[k++] = strArray[j++];
                        }

                        ++tempIndexUpperCount;
                    }

                    if (!isFinished && strArray[i].length() > strArray[j].length()) {
                        tempStringArray[k++] = strArray[j++];
                    } else if (!isFinished && strArray[i].length() < strArray[j].length()) {
                        tempStringArray[k++] = strArray[i++];
                    } else {
                        tempStringArray[k++] = strArray[j++];
                    }

                } else {

                    tempStringArray[k++] = strArray[j++];

                }
            }

            while (i <= medium) {
                tempStringArray[k++] = strArray[i++];
            }
            while (j <= end) {
                tempStringArray[k++] = strArray[j++];
            }
            for (int c = start; c <= end; c++) {
                strArray[c] = tempStringArray[c];
            }

        }

    }

}
