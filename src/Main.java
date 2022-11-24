import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int FIELD_SIZE = 5;
        int[][] field = getArray(FIELD_SIZE, FIELD_SIZE, 0);
        int[][] agents = getArray(4, 2, FIELD_SIZE);

        arrayToString(field);
        arrayToString(agents);

        System.out.println("---------first wave---------");
        int[][] infectedField = pandemic(field, agents);
        arrayToString(infectedField);

        System.out.println("--------second wave---------");
        agents = getArray(6, 2, FIELD_SIZE);
        arrayToString(agents);
        int[][] secondWave = pandemic(infectedField, agents);
        arrayToString(secondWave);

        System.out.println("--------third wave---------");
        agents = getArray(8, 2, FIELD_SIZE);
        arrayToString(agents);
        arrayToString(pandemic(secondWave, agents));
    }

    static Random random = new Random();
    public static int[][] getArray(int rows, int cells, int bound) {
        int[][] field = new int[rows][cells];

        if (bound < 1) {
            bound = 1;
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = random.nextInt(bound);
            }
        }
        return field;
    }

    public static void arrayToString(int[][] array) {
        for (int[] values : array) {
            for (int value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static int[][] pandemic(int[][] field, int[][] agents) {
        int row;
        int cell;

        try {
            for (int[] agent : agents) {
                row = agent[0];
                cell = agent[1];
                if (field[row][cell] == 0) {
                    field[row][cell] += 1;
                } else {
                    field[row][cell] *= 2;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return field;
    }
}