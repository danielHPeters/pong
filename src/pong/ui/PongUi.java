/*
 * Copyright (C) 2017 Daniel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pong.ui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import pong.ButtonActions;
import pong.GameState;
import pong.configuration.Settings;

/**
 *
 * @author Daniel
 */
public class PongUi {

    /**
     * the game window
     */
    private final JFrame window;

    /**
     * the drawing painter containing the game loop and objects
     */
    private final JPanel painter;

    /**
     *
     */
    private final ButtonActions btnActions;

    /**
     *
     */
    private final JToggleButton pauseButton;

    /**
     *
     */
    private final JButton restartButton;

    /**
     *
     */
    private JMenuBar actionBar;

    /**
     * 
     * @param config
     * @param game 
     */
    public PongUi(Settings config, GameState game) {

        this.window = new GameWindow(config);
        this.painter = new Painter(config, game);
        this.actionBar = new JMenuBar();
        this.actionBar.setFocusable(false);

        this.btnActions = new ButtonActions(game);
        this.pauseButton = new JToggleButton("Pause");
        this.pauseButton.addItemListener(btnActions.pauseListener());

        this.restartButton = new JButton("Restart");
        this.restartButton.addActionListener(btnActions.restartListener());
        this.restartButton.setFocusable(false);

        this.actionBar.add(pauseButton);
        this.actionBar.add(restartButton);

        this.window.add(painter, BorderLayout.CENTER);
        this.window.add(actionBar, BorderLayout.NORTH);
        this.window.pack();
    }

    /**
     * 
     * @return 
     */
    public JPanel getPainter() {
        return painter;
    }

    /**
     * 
     * @return 
     */
    public JFrame getWindow() {
        return window;
    }
    

}