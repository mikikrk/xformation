package com.xformation.task3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mikolaj on 2015-11-22.
 */
public class MineSweeperTest {

    private MineSweeper mineSweeper;

    private final String properMineField =
                    "..*...*......*.\n" +
                    "*......*....***\n" +
                    "*......*....***\n" +
                    ".*.*.*.*.*.*.*.\n" +
                    "...............\n" +
                    ".....**.**.....";

    final String properHintField =
                    "12*101*210013*3\n" +
                    "*311013*2002***\n" +
                    "*321214*4123***\n" +
                    "2*2*2*3*3*2*4*3\n" +
                    "112133434331211\n" +
                    "00001**2**10000";

    private final String finishedWithNewLineMineField =
                    "..*...*......*.\n" +
                    "*......*....***\n" +
                    "*......*....***\n" +
                    ".*.*.*.*.*.*.*.\n" +
                    "...............\n" +
                    ".....**.**.....\n";

    private final String notSameLineLengthMineField =
                    "..*...*......*.\n" +
                    "*......*....***\n" +
                    "*......*....***\n" +
                    ".*.*.*.*.*.*.*.\n" +
                    "..............\n" +
                    ".....**.**.....";

    private final String onlyMinesField =
                    "***************\n" +
                    "***************\n" +
                    "***************\n" +
                    "***************\n" +
                    "***************\n" +
                    "***************";

    private final String noMineMineField =
                    "...............\n" +
                    "...............\n" +
                    "...............\n" +
                    "...............\n" +
                    "...............\n" +
                    "...............";

    private final String noMineHintField =
                    "000000000000000\n" +
                    "000000000000000\n" +
                    "000000000000000\n" +
                    "000000000000000\n" +
                    "000000000000000\n" +
                    "000000000000000";

    @Before
    public void init(){
        mineSweeper = new MineSweeperImpl();
    }

    @Test
    public void testProperHintField(){
        mineSweeper.setMineField(properMineField);
        assertEquals(properHintField, mineSweeper.getHintField());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFinishedWithNewLine(){
        mineSweeper.setMineField(finishedWithNewLineMineField);
        mineSweeper.getHintField();
    }

    @Test(expected = IllegalArgumentException.class)
    public void notSameLineLength(){
        mineSweeper.setMineField(notSameLineLengthMineField);
        mineSweeper.getHintField();
    }

    @Test(expected = IllegalStateException.class)
    public void testNotSetMineField(){
        mineSweeper.getHintField();
    }

    @Test
    public void testOnlyMines(){
        mineSweeper.setMineField(onlyMinesField);
        assertEquals(onlyMinesField, mineSweeper.getHintField());
    }

    @Test
    public void testNoMines(){
        mineSweeper.setMineField(noMineMineField);
        assertEquals(noMineHintField, mineSweeper.getHintField());
    }
}
