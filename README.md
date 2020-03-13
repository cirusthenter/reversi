# Very Simple CUI Reversi
This is a very simple Reversi written in Java. You can play just by running the following two commands:

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
