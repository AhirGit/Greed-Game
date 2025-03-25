# Greed ASCII Game

A terminal-based ASCII game inspired by the classic *Greed* puzzle game. Move across a board of digits, collecting points based on the value of the cells you move over. The game ends when no valid moves are left.

---

## How to Play

- Player represented by the `@` symbol.
- Each move direction corresponds to a key (`q`, `w`, `e`, `a`, `d`, `z`, `s`, `x`).
- Clear cells (`' '`) can't be moved into or passed through.
- Press `0` during the game to return to the main menu.

---

## How to Build & Run

Make sure you have `make` and `javac` installed.

```bash
make        # Compile all Java files
make run    # Run the game
make clean  # Remove all .class files