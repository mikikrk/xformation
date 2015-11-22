package com.xformation.task3;

/**
 * Created by Mikolaj on 2015-11-22.
 */
public class MineSweeperImpl implements MineSweeper{

    private char[][] mineField;
    private StringBuffer hintField;
    private int colsAmount;
    private int rowsAmount;

    public enum DIR {
        N(-1,0),
        E(0,1),
        S(1,0),
        W(0,-1),
        NE(-1,1),
        SE(1,1),
        SW(1,-1),
        NW(-1,-1);

        private final int dx;
        private final int dy;

        DIR(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public int transformX(int x){
            return x + dx;
        }

        public int transformY(int y){
            return y + dy;
        }
    }

    public void setMineField(String mineField) throws IllegalArgumentException {
        if (hasProperFormat(mineField)){
            initMineField(mineField);
        } else {
            throw new IllegalArgumentException("Wrong format");
        }
    }

    private boolean hasProperFormat(String mineField) {
        return mineField.matches("([\\. \\*]+\\n)*[\\. \\*]+");
    }

    private void initMineField(String mineField) {
        String[] mineArrField = mineField.split("\n");
        rowsAmount = mineArrField.length;
        colsAmount = mineArrField[0].length();
        this.mineField = new char[rowsAmount][colsAmount];

        fillMineField(mineArrField);
    }

    private void fillMineField(String[] mineArrField) {
        for (int it = 0; it<rowsAmount; it++){
            this.mineField[it] = mineArrField[it].toCharArray();
            if (this.mineField[it].length != colsAmount){
                throw new IllegalArgumentException("Wrong format");
            }
        }
    }

    public String getHintField() throws IllegalStateException {
        if (mineField != null) {
            hintField = new StringBuffer();
            for (int i = 0; i < rowsAmount; i++) {
                for (int j = 0; j < colsAmount; j++){
                    appendHintToField(i, j);
                }
                hintField.append("\n");
            }
        } else {
            throw new IllegalStateException("MineField is not initialized");
        }
        return prepareHintField();
    }

    private void appendHintToField(int row, int col) {
        if (mineField[row][col] == '*'){
            hintField.append('*');
        }else {
            Integer neighborMines = countNeighborMines(row, col);
            hintField.append(neighborMines.toString());
        }
    }

    private Integer countNeighborMines(int row, int col) {
        int counter = 0;
        for (DIR dir: DIR.values()){
            int neighX = dir.transformX(row);
            int neighY = dir.transformY(col);
            if (notOutOfField(neighX, neighY) && mineField[neighX][neighY] == '*'){
                counter++;
            }
        }
        return counter;
    }

    private boolean notOutOfField(int neighX, int neighY) {
        return neighX >= 0 && neighX < rowsAmount && neighY >= 0 && neighY < colsAmount;
    }

    private String prepareHintField() {
        int lastNewLineIndex = hintField.lastIndexOf("\n");
        return hintField.substring(0, lastNewLineIndex);
    }
}
