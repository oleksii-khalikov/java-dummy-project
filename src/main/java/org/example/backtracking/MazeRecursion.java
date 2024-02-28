package org.example.backtracking;

public class MazeRecursion {

    public static void mazeRecursion() {
        int[][] map = new int[8][7];
        int[][] map2 = new int[8][7];

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }


        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("The condition of the map： ");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, map2[i], 0, map[i].length);
        }

        setWay(map, 1, 1);
        setWay2(map2, 1, 1);

        System.out.println("After the ball goes through the map1，show the current map1 condition");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("After the ball goes through the map2，show the current map2 condition");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map2[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay(map, i + 1, j)) {
                return true;
            } else if (setWay(map, i, j + 1)) {
                return true;
            } else if (setWay(map, i - 1, j)) {
                return true;
            } else if (setWay(map, i, j - 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay2(map, i - 1, j)) {
                return true;
            } else if (setWay2(map, i, j + 1)) {
                return true;
            } else if (setWay2(map, i + 1, j)) {
                return true;
            } else if (setWay2(map, i, j - 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }
}
