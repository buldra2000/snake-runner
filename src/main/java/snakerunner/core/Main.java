package snakerunner.core;

import java.util.List;
import java.util.Set;

import javax.swing.SwingUtilities;

import snakerunner.commons.Point2D;
import snakerunner.controller.Controller;
import snakerunner.controller.impl.ControllerImpl;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.impl.MainFrameImpl;
import snakerunner.model.GameModel;
import snakerunner.model.LevelData;
import snakerunner.model.impl.GameModelImpl;
import snakerunner.model.impl.LevelDataImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Snake Runner!");

        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrameImpl();
            GameModel gameModel = new GameModelImpl();
            Controller controller = new ControllerImpl(mainFrame, gameModel);

            mainFrame.setController(controller);
            controller.loadLevel(createTestLevel());
            controller.init();
        });
    }

    //LIVELLO PROVA
    private static LevelData createTestLevel() {
        Set<Point2D<Integer, Integer>> walls = Set.of(
            new Point2D<>(5, 3),
            new Point2D<>(5, 4),
            new Point2D<>(5, 5)
        );

        List<Point2D<Integer, Integer>> fruits = List.of(
            new Point2D<>(2, 2),
            new Point2D<>(10, 8)
        );

        return new LevelDataImpl(walls, fruits);
    }
}

