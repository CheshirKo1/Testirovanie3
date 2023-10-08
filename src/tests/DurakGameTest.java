package src.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.main.Card;
import src.main.DurakGame;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

//import io.cucumber.*;

public class DurakGameTest {
    private DurakGame game;

    @BeforeEach
    void setUp() {
        game = new DurakGame();
    }

}