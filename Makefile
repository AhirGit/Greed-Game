# Compiler
JAVAC = javac
JAVA = java

# Source files
SOURCES = *.java

# Main class
MAIN = GreedGame

# Default: compile everything
all:
	$(JAVAC) $(SOURCES)

# Run the game
run: all
	$(JAVA) $(MAIN)

# Clean up .class files
clean:
	rm -f *.class