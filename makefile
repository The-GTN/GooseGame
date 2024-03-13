EXEC = goosegame
TEST = java -jar lib/test-1.7.jar

all: $(EXEC)

doc:
	cd src;javadoc goosegame -d ../docs;
	cd src;javadoc io -d ../docs;

classes:
	rm -rf classes;mkdir classes

comp: classes
	cd src;javac */*.java */*/*.java -d ../classes;

compTest: comp
	javac -classpath lib/test-1.7.jar test/goosegame/*.java test/goosegame/*/*.java;

test: compTest
	$(TEST) goosegame.TestCell
	$(TEST) goosegame.cells.TestStartCell
	$(TEST) goosegame.cells.TestGooseCell
	$(TEST) goosegame.cells.TestTeleportCell
	$(TEST) goosegame.cells.TestPrisonCell
	$(TEST) goosegame.cells.TestWaitCell
	$(TEST) goosegame.boards.TestClassicalBoard
	$(TEST) goosegame.TestGame


goosegame:
	java -jar dist/GooseGame.jar

io:
	java -jar dist/IO.jar

exe: comp
	cd classes;jar cvfm ../dist/GooseGame.jar ../lib/manifest/manifest-GooseGame goosegame io
	cd classes;jar cvfm ../dist/IO.jar ../lib/manifest/manifest-IO io

extract:
	cd dist;jar xvf GooseGame.jar

clean:
	rm -rf classes docs test/*.class test/*/*.class test/*/*/*.class dist/META-INF dist/goosegame dist/io

.PHONY: clean extract exe test compTest comp classes doc all goosegame io
