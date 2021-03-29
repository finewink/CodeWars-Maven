package com.codewars;

import java.util.Arrays;

public class CodewarsStyleRankingSystem {
    private int[] rankTable = new int[] { -8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8 };
    public int rank = -8;
    public int progress;

    public int incProgress(int rank) {
        if (Arrays.binarySearch(rankTable, rank) < 0) {
            rank = rankTable[Arrays.binarySearch(rankTable, rank)];// on purpose raise exception;
        }
        this.progress += calcPoint(rank);
        this.rank = calcRank(this.progress);

        return this.rank;
    }

    private int calcPoint(int actRank) {
        int userRank = getRank(calcRank(this.progress));
        int diff = getRankTableIndex(actRank) - userRank;
        if (diff < -1) {
            return 0;
        } else if (diff == -1) {
            return 1;
        } else if (diff == 0) {
            return 3;
        } else {
            return 10 * diff * diff;
        }
    }

    private int calcRank(int progress) {
        int rank = progress / 100;
        if (rank >= rankTable.length) {
            rank = rankTable.length - 1;
        }

        return rank;
    }

    private int getRank(int index) {
        return rankTable[index];
    }

    private int getRankTableIndex(int rank) {
        return Arrays.binarySearch(rankTable, rank);
    }

}
