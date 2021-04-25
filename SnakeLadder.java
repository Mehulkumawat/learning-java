public class SnakeLadderGame {
    private GameBoard gameBoard;
    private Dice dice;
    private Player player1;
    private Player player2;
    
    public static void main(String[] args) {
        initialize(); // Setup players, cells, snakes, ladders.
        String winner = play();
        
        System.out.println("Winner is: " + winner);
    }
    
    public void initialize() {
        setBoard();
        setPlayers();
        setDice();
    } 
    
    public void setBoard() {
        gameBoard = new GameBoard();
    }
    
    public void setPlayers() {
        player1 = new Player("Abhishek", gameBoard.getFirstCell());
        player2 = new Player("Mehul", gameBoard.getFirstCell());
    }
    
    public void setDice() {
        dice = new Dice();
    }
    
    /**
     * Starts the game, pllays it, and at the end return the winner's name.
    */
    public String play {
        boolean isPlayer1Chance = true;
        boolean hasWon = false;
        while(true) {
            Player player = isPlayer1Chance ? player1 : player2;
            Cell playerCell = player.play();
            if (hasWon(playerCell)) return player.getName();
            isPlayer1Chance = !isPlayer1Chance;
        }
        throw new Exception("Unexpceted state");
    }
    
    public boolean hasWon(Cell cell) {
        return cell.getValue() == 100;
    }
}

public class GameBoard {
    private int start = 1;
    private int end = 100;
    private Cell[] cells; // 100 cells, 0 -> 1st, 1 -> 2nd
    private Snake[] snakes; // 7 snakes.
    private Ladder[] ladders; // 7 ladders.
    
    public GameBoard() {
        setCells();
        setSnakes();
        setLadders();
    }
    
    public void setCells() {
        cells = new int[end];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell(i+1);
        }
    }
    
    public void setSnakes() {
        snakes = new Snake[5]; // Creating 5 snakes in total.
        int[][] snakePositions = new int[][] {
            new int[] {21, 5},
            new int[] {45, 18},
            new int[] {55, 26},
            new int[] {85, 30},
            new int[] {99, 10}
        };
        
        for (int i = 0; i < snakePositions.length; i++) {
            Cell headCell = getCell(snakePositions[0]);
            Cell tailCell = getCell(snakePositions[1]);
            snakes[i] = new Snake(headCell, tailCell);
            
            headCell.setSnake(snake[i]);
            headCell.setHasSnakeHead(true);
            
            tailCell.setSnake(snake[i]);
            tailCell.setHasSnakeHead(false);
        }
    }
    
    public void setLadders() {
        ladders = new Ladder[4];
        int[][] ladderPositions = new int[][] {
            new int[] {6, 24},
            new int[] {31, 46},
            new int[] {56, 86},
            new int[] {75, 95},
        }
        
        for (int i = 0; i < ladderPositions.length; i++) {
            Cell startCell = getCell(ladderPositions[0]);
            Cell endCell = getCell(ladderPositions[1]);
            ladders[i] = new Ladder(startCell, endCell);
            
            startCell.setLadder(ladder[i]);
            startCell.setHasLadderStart(true);
            
            endCell.setLadder(ladder[i]);
            endCell.setHasLadderStart(false);
        }
    }
    
    public Cell getCell(int value) {
        return cells[value-1];
    }
    
    public Cell getFirstCell() {
        return cells[0];
    }
}

public class Cell {
    private int value;
    private boolean hasLadderStart;
    private boolean hasSnakeHead;
    private Snake snake = null;
    private Ladder ladder = null;
    
    public Cell(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void setSnake(Snake snake) {
        this.snake = snake;
    }
    
    public void setHasSnakeHead(boolean hasSnakeHead) {
        this.hasSnakeHead = hasSnakeHead;
    }
    
    public void setLadder(Ladder snake) {
        this.ladder = ladder;
    }
    
    public void setHasLadderStart(boolean hasLadderStart) {
        this.hasLadderStart = hasLadderStart;
    }
    
    public boolean hasLadderStart() {
        return this.hasLadderStart;
    }
    
    public boolean hasSnakeStart() {
        return this.hasLadderEnd();
    }
    
    public Snake getSnake() {
        return this.snake;
    }
    
    public Ladder getLadder() {
        return this.ladder;
    }
}

public class Snake {
    private Cell head;
    private Cell tail;
    
    public Snake(Cell head, Cell tail) {
        this.head = head;
        this.tail = tail;
    }
    
    public Cell getTailCell() {
        return this.tail;
    }
}

public class Ladder {
    private Cell start;
    private Cell end;
    
    public Ladder(Cell start, Cell end) {
        this.start = start;
        this.end = end;
    }
    
    public Cell getEndCell() {
        return this.end;
    }
}

public class Dice {
    public int roll() {
        Random random = new Random();
        return random.nextInt(6) + 1; // Returns a random int value between 1 to 6.
    }
}

public class Player {
    private String name;
    private Cell current;
    
    public Player(String name, Cell start) {
        this.name = name;
        this.current = start;
    }
    
    public String getName() {
        return name;
    }
    
    /***
     * Return the final cell after playing the chance.
     * 
     * TODO: what if 6 comes?
     */ 
    public Cell play(GameBoard board, Dice dice) {
        int value = rollDice(dice);
        if (value == 0) return current;
        
        current = moveTocell(board, current, value);
        // If snake start is at the cell, snake will bite, and our new cell will now go to tail cell.
        if (current.hasSnakeHead()) current = current.getSnake().getTailCell();
        // If ladder start is at the cell, chad jao ladder pe.
        else if (current.hasLadderStart()) current = current.getLadder().getEndCell();
        return current;
    }
    
    public int rollDice(Dice dice) {
        int value = dice.roll();
        int sixCount = 0;
        
        while(value == 6 && sixCount < 3) {
            sixCount++;
            value = value + dice.roll();
        }
        
        return (sixCount == 3) ? 0 : value;
    }
    
    public Cell moveToCell(GameBoard board, Cell current, int moveValue) {
        int newValue = current.getValue() + moveValue;
        // If value is greater than 100, don't move the cell.
        if (newValue > 100) return current;
        return board.getCell(newValue);
    }
}
