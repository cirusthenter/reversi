# Very Simple CUI Reversi
## Introduction
This is a very simple Reversi written in Java.
## How to Use
 You can play just by running the following two commands:

```
$ javac Reversi.java
$ java Reversi
```

Input the place where you want to put the stone. For example, let's think of the very first situation. The board is the following.

```
$ javac Reversi.java
$ java Reversi
---------------------
|   0 1 2 3 4 5 6 7 |
| a _ _ _ _ _ _ _ _ |
| b _ _ _ _ _ _ _ _ |
| c _ _ _ _ _ _ _ _ |
| d _ _ _ ● ○ _ _ _ |
| e _ _ _ ○ ● _ _ _ |
| f _ _ _ _ _ _ _ _ |
| g _ _ _ _ _ _ _ _ |
| h _ _ _ _ _ _ _ _ |
---------------------
Player 1: ●
Player 2: ○
---------------------

```
If you are Player 1 and want to put the ● to an apropreate place, let's say right above the upper right ○, you need to input "4c" or "c4" and the board changes this way.

```
---------------------
|   0 1 2 3 4 5 6 7 |
| a _ _ _ _ _ _ _ _ |
| b _ _ _ _ _ _ _ _ |
| c _ _ _ _ _ _ _ _ |
| d _ _ _ ● ○ _ _ _ |
| e _ _ _ ○ ● _ _ _ |
| f _ _ _ _ _ _ _ _ |
| g _ _ _ _ _ _ _ _ |
| h _ _ _ _ _ _ _ _ |
---------------------
Player 1: ●
Player 2: ○
---------------------
Player 1 ● input: 4c
---------------------
|   0 1 2 3 4 5 6 7 |
| a _ _ _ _ _ _ _ _ |
| b _ _ _ _ _ _ _ _ |
| c _ _ _ _ ● _ _ _ |
| d _ _ _ ● ● _ _ _ |
| e _ _ _ ○ ● _ _ _ |
| f _ _ _ _ _ _ _ _ |
| g _ _ _ _ _ _ _ _ |
| h _ _ _ _ _ _ _ _ |
---------------------
Player 1: ●
Player 2: ○
---------------------
```

## TIPS
If you feel grandeur, you may like editing line 2 in `Board.java`.

```
1: public calss Board {
2:	  static final int FIELDSIZE = 8;
3:    private int[][] field = new int[FIELDSIZE][FIELDSIZE];
```

The constant `FIELDSIZE` defines the size of the board. In the default mode, where `FIELDSIZE` is 8, you get the 8 * 8 battle field. If it is changed to 20, you get the following grand filed:

```
---------------------
|   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 |
| a _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| b _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| c _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| d _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| e _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| f _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| g _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| h _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| i _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| j _ _ _ _ _ _ _ _ _ ● ○ _ _ _ _ _ _ _ _ _ |
| k _ _ _ _ _ _ _ _ _ ○ ● _ _ _ _ _ _ _ _ _ |
| l _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| m _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| n _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| o _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| p _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| q _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| r _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| s _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| t _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
---------------------
Player 1: ●
Player 2: ○
---------------------
```
However, you might feel tiny some rainy day.  Then you want to set `FIELDSIZE` to a small number, such as 4.

```
---------------------
|   0 1 2 3 |
| a _ _ _ _ |
| b _ ● ○ _ |
| c _ ○ ● _ |
| d _ _ _ _ |
---------------------
Player 1: ●
Player 2: ○
---------------------
```

The size of the board can be however big you want it to be, but keep in mind, the character is interpreted as an ASCII code char, thus if you set the size bigger than 26, say 30, you get it printed a weired way. But just don't care and type like "25}".

```
---------------------
|   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 |
| a _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| b _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| c _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| d _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| e _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| f _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| g _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| h _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| i _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| j _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| k _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| l _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| m _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| n _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| o _ _ _ _ _ _ _ _ _ _ _ _ _ _ ● ○ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| p _ _ _ _ _ _ _ _ _ _ _ _ _ _ ○ ● _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| q _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| r _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| s _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| t _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| u _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| v _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| w _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| x _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| y _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| z _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| { _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| | _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| } _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
| ~ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
---------------------
Player 1: ●
Player 2: ○
---------------------
```
