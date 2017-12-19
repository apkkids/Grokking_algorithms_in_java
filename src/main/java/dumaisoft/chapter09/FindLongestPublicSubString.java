package dumaisoft.chapter09;

/**
 * Created by wxb on 2017/12/19 0019.
 * 使用动态规划算来寻找"最长的公共子序列"
 */
public class FindLongestPublicSubString {
    public static void main(String[] args) {
        String word_a = "fosh";
        String word_b = "fish";
        int maxSubSequence = findLongestPublicSubSequence(word_a, word_b);
        System.out.println("the longest public sub sequence is : " + maxSubSequence);
        int maxSubString = findLongestPublicSubString(word_a, word_b);
        System.out.println("the longest public sub string is : " + maxSubString);
    }

    /**
     * 寻找最长公共子串
     *
     * @param word_a
     * @param word_b
     * @return
     */
    private static int findLongestPublicSubString(String word_a, String word_b) {
        int[][] cell = new int[word_a.length()][word_b.length()];
        for (int i = 0; i < word_a.length(); i++) {
            for (int j = 0; j < word_b.length(); j++) {
                if (word_a.charAt(i) == word_b.charAt(j)) {
                    if (i > 0 && j > 0) {
                        cell[i][j] = cell[i - 1][j - 1] + 1;
                    } else {
                        cell[i][j] = 1;
                    }
                } else {
                    cell[i][j] = 0;
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < word_a.length(); i++) {
            for (int j = 0; j < word_b.length(); j++) {
                maxLength = Math.max(maxLength, cell[i][j]);
            }
        }
        return maxLength;
    }

    /**
     * 寻找最长公共子序列
     *
     * @param word_a
     * @param word_b
     * @return
     */
    private static int findLongestPublicSubSequence(String word_a, String word_b) {
        int[][] cell = new int[word_a.length()][word_b.length()];
        for (int i = 0; i < word_a.length(); i++) {
            for (int j = 0; j < word_b.length(); j++) {
                if (word_a.charAt(i) == word_b.charAt(j)) {
                    if (i > 0 && j > 0) {
                        cell[i][j] = cell[i - 1][j - 1] + 1;
                    } else {
                        cell[i][j] = 1;
                    }
                } else {
                    if (i > 0 && j > 0) {
                        cell[i][j] = Math.max(cell[i - 1][j], cell[i][j - 1]);
                    } else if (i > 0) {
                        cell[i][j] = cell[i - 1][j];
                    } else if (j > 0) {
                        cell[i][j] = cell[i][j - 1];
                    } else {
                        cell[i][j] = 0;
                    }
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < word_a.length(); i++) {
            for (int j = 0; j < word_b.length(); j++) {
                maxLength = Math.max(maxLength, cell[i][j]);
            }
        }
        return maxLength;
    }
}
