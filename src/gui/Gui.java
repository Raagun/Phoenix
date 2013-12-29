/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import galaxyreader.Unit;
import game.Game;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import state.MM1;
import state.SU;
import state.State;
import state.StateRef;
import util.C;
import util.Util;
import util.WindowSize;

/**
 *
 * @author joulupunikki
 */
public class Gui extends JFrame {

    private static final int DEFAULT_WINDOW_WIDTH = 640;
    private static final int DEFAULT_WINDOW_HEIGHT = 480;
    private static String[] args;
    //holds the space map
    private SpaceMap space_map;
    //holds the planet map
    private PlanetMap planet_map;
    //holds the planet map background and components
    private PlanetWindow planet_window;
    private JButton launch_button;
    private ButtonIcon launch_button_enabled;
    private ButtonIcon launch_button_disabled;
    //holds the starmap background and components    
    private SpaceWindow space_window;
    private GalacticMap galactic_map;
    private GlobeMap globe_map;
    //holds the unit info window/stack window
    private UnitInfoWindow unit_info_window;
    private MainMenu main_menu;
    private CombatWindow combat_window;
    //holds the planet map display and star map display and unit info window in a CardLayout    
    private JPanel main_windows;
    private JMenuBar menubar;
    private JMenuBar no_menubar;
    private JMenu file_menu;
    private JMenuItem menu_exit;
    private JMenuItem menu_load;
    private JMenuItem menu_save;

    
    private Resources resources;
    //stack display window
    private JDialog stack_window;
    private static WindowSize ws;
    //reference to Game object
    private Game game;
    //efs 256-color pallette
    private byte[][] pallette;
    private static IndexColorModel color_index;
    private static int[][] unit_icons;
    private static int[][][] hex_tiles;
    private static int[][][] structures;
    private Timer stack_move_timer;
    private boolean stop_stack = false;
    private boolean stack_moving = false;
    private boolean animation_blink = true;
    private int stack_move_counter;
    private State state;
    private StateRef state_ref;
    private int color_cycle_count;
    private Color[] color_cycle_colors;
    private Color color_cycle_color;
    private Unit drag_unit;
    private Point drag_point;
    private Unit info_unit;

    private boolean loadsave_win_up;
    private JDialog loadsave_dialog;

    public Gui() throws HeadlessException {
        // set swing component default colors
        UIManager.put("OptionPane.background", Color.DARK_GRAY);
        UIManager.put("OptionPane.foreground", C.COLOR_GOLD);
        UIManager.put("Panel.background", Color.DARK_GRAY);
        UIManager.put("Panel.foreground", C.COLOR_GOLD);
        UIManager.put("OptionPane.messageForeground", C.COLOR_GOLD);
        UIManager.put("Button.background", Color.BLACK);
        UIManager.put("Button.foreground", C.COLOR_GOLD);
        UIManager.put("Button.border", new BorderUIResource(new LineBorder(C.COLOR_GOLD)));
        UIManager.put("Dialog.background", Color.DARK_GRAY);
        UIManager.put("Dialog.foreground", C.COLOR_GOLD);
        UIManager.put("ProgressBar.foreground", C.COLOR_GOLD);
        UIManager.put("ProgressBar.background", Color.DARK_GRAY);
        UIManager.put("MenuItem.background", Color.DARK_GRAY);
        UIManager.put("MenuItem.foreground", C.COLOR_GOLD);
        UIManager.put("Menu.background", Color.DARK_GRAY);
        UIManager.put("Menu.foreground", C.COLOR_GOLD);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] args = Gui.args;

        pallette = Util.loadPallette("EFS.PAL");
        color_index = loadICM();

        unit_icons = Util.loadSquares(C.S_EFSUNIT_BIN, 92, 32 * 32);

        if (args.length == 2) {
            if (Integer.parseInt(args[0]) == 1) {
                ws = new WindowSize(false);
            } else if (Integer.parseInt(args[0]) == 2) {
                ws = new WindowSize(true);
            } else {

                ws = new WindowSize(false);
                System.out.println("usage: java -jar Gui.jar 1|2 galaxy.gal");
                System.exit(0);
            }

            game = new Game(args[1], 14);
            game.init();
        } else if (args.length == 0) {
            game = new Game("GALAXY.GAL", 14);
            game.init();
            ws = new WindowSize(false);
        } else {
            ws = new WindowSize(false);
            System.out.println("usage: java -jar Gui.jar 1|2 galaxy.gal");
            System.exit(0);
        }
        this.setSize(ws.main_window_width, ws.main_window_height);

        loadHexTiles();

        loadStructureTiles();
        resources = new Resources(this);

        /*
         * build Gui
         */
        no_menubar = new JMenuBar();
        no_menubar.setBackground(Color.DARK_GRAY);
        JMenu no_menu = new JMenu(".");
        no_menu.setBackground(Color.DARK_GRAY);
        no_menubar.add(no_menu);
        no_menubar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        menubar = new JMenuBar();
        file_menu = new JMenu("File");
        menu_exit = new JMenuItem("Exit Game");
        menu_load = new JMenuItem("Load Game");
        menu_save = new JMenuItem("Save Game");

        menubar.setBackground(Color.DARK_GRAY);
        file_menu.setBackground(Color.DARK_GRAY);
        menu_exit.setBackground(Color.DARK_GRAY);
        menubar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        file_menu.setForeground(C.COLOR_GOLD);
        menu_exit.setForeground(C.COLOR_GOLD);
        menu_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu_load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadGame();

            }
        });
        menu_save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveGame();

            }
        });

        file_menu.add(menu_exit);
        file_menu.add(menu_load);
        file_menu.add(menu_save);

        menubar.add(file_menu);

        this.setJMenuBar(menubar);

        /*
         * create planet map display
         */
        planet_window = new PlanetWindow(this);
        planet_window.setLayout(null);
        planet_window.setPreferredSize(new Dimension(ws.main_window_width,
                ws.main_window_height));
//        this.add(planet_window);

        planet_window.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
//                clickOnPlanetMap(e);
                state.clickOnPlanetWindow(e);
            }
        });

        planet_window.addMouseWheelListener(new MouseAdapter() {
            public void mouseWheelMoved(MouseWheelEvent e) {
//                handleWheelMove(e);
                state.wheelRotated(e);
            }
        });

        planet_map = new PlanetMap(this);
        planet_window.add(planet_map);
        planet_map.setBounds(ws.planet_map_x_offset, ws.planet_map_y_offset,
                ws.planet_map_width, ws.planet_map_height);

        planet_map.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
//                clickOnPlanetMap(e);
                state.clickOnPlanetMap(e);
            }
        });

        setUpLaunchButton();

        /*
         * create star map display
         */
        space_window = new SpaceWindow(this);
        space_window.setLayout(null);
        space_window.setPreferredSize(new Dimension(ws.main_window_width,
                ws.main_window_height));

        space_window.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
//                clickOnPlanetMap(e);
                state.clickOnSpaceWindow(e);
            }
        });
        space_window.addMouseWheelListener(new MouseAdapter() {
            public void mouseWheelMoved(MouseWheelEvent e) {
//                handleWheelMove(e);
                state.wheelRotated(e);
            }
        });

        space_map = new SpaceMap(this);

        space_window.add(space_map);

        space_map.setBounds(ws.space_map_x_pos, ws.space_map_y_pos,
                ws.space_map_width, ws.space_map_height);

        space_map.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
//                clickOnSpaceMap(e);
                state.clickOnSpaceMap(e);
            }
        });

        galactic_map = new GalacticMap(this, game, ws);
        space_window.add(galactic_map);
        galactic_map.setBounds(ws.galactic_map_x_pos, ws.galactic_map_y_pos,
                ws.galactic_map_width, ws.galactic_map_height);
        galactic_map.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                state.clickOnGalacticMap(e);
            }
        });

        globe_map = new GlobeMap(this, game, ws);
        planet_window.add(globe_map);
        globe_map.setBounds(ws.globe_map_x_pos, ws.globe_map_y_pos,
                ws.globe_map_width, ws.globe_map_height);
        globe_map.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                state.clickOnGlobeMap(e);
            }
        });

        /*
         * create unit info window/stack window
         */
        unit_info_window = new UnitInfoWindow(this);
        unit_info_window.setLayout(null);
        unit_info_window.setPreferredSize(new Dimension(ws.main_window_width,
                ws.main_window_height));
        unit_info_window.setUpWindow();

        main_menu = new MainMenu(this);
        main_menu.setLayout(null);
        main_menu.setPreferredSize(new Dimension(ws.main_window_width,
                ws.main_window_height));
//        main_menu.setUpWindow();

        combat_window = new CombatWindow(this);
        combat_window.setLayout(null);
        combat_window.setPreferredSize(new Dimension(ws.main_window_width,
                ws.main_window_height));

        main_windows = new JPanel(new CardLayout());

        main_windows.add(main_menu, C.S_MAIN_MENU);
        main_windows.add(planet_window, C.S_PLANET_MAP);
        main_windows.add(space_window, C.S_STAR_MAP);
        main_windows.add(unit_info_window, C.S_UNIT_INFO);
        main_windows.add(combat_window, C.S_COMBAT_WINDOW);

        this.getContentPane().add(main_windows, BorderLayout.CENTER);
        setMouseCursor();

//        State.setReferences(this, game, ws);
        state = MM1.get();

        this.pack();
        this.setVisible(true);

        /*
         * set animation timer
         */
        int delay = 400; //milliseconds
        ActionListener timer_listener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                animation_blink = !animation_blink;
                main_windows.repaint();
            }
        };
        Timer anim_timer = new Timer(delay, timer_listener);
        anim_timer.start();

        /*
         * set stack movement timer and listener, 
         */
        int move_delay = 30;
        ActionListener stack_move_listener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                state.stackMoveEvent();
//                setStack_move_counter(getStack_move_counter() + 1);
//                if (getStack_move_counter() >= 20) {
//                    setStack_move_counter(0);
//                    if (!game.moveStack()) {
//                        setStop_stack(true);
//                        showTooManyUnits();
//                    }
//                    LinkedList<Hex> path = game.getPath();
//                    if (path.getFirst().equals(path.getLast())) {
//                        setStop_stack(true);
//                        game.setPath(null);
//                    } else if (!Util.moveCapable(game)) {
//                        setStop_stack(true);
//                    }
//                    if (isStop_stack()) {
//                        getStack_move_timer().stop();
//                        setStack_moving(false);
//                        // bit ugly to set state here
//                        if (game.getPath() == null) {
//                            setCurrentState(PW2.get());
//                        } else {
//                            setCurrentState(PW3.get());
//                        }
//                    }
//                }
//                planet_window.repaint();
            }
        };
        stack_move_timer = new Timer(move_delay, stack_move_listener);

        setColorCycle();
        color_cycle_count = 0;
        color_cycle_color = color_cycle_colors[0];
        int cycle_delay = 300; //milliseconds
        ActionListener cycle_listener = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                main_windows.repaint();
                color_cycle_count++;
                if (color_cycle_count == 5) {
                    color_cycle_count = 0;
                }
                color_cycle_color = color_cycle_colors[color_cycle_count];
            }
        };
        Timer cycle_timer = new Timer(cycle_delay, cycle_listener);
        cycle_timer.start();

    }

    public Resources getResources() {
        return resources;
    }
    
    public void setLoadSaveWinUp(boolean state) {
        loadsave_win_up = state;
    }

    public boolean getLoadSaveWinUp() {
        return loadsave_win_up;
    }

    public void cancelLoadSaveDialog() {
        loadsave_dialog.dispose();
    }

    public JDialog showProgressBar(String text) {
        JDialog dialog = new JDialog(this, text, true);
        int p_width = this.getWidth();
        int p_height = this.getHeight();

        int width = p_width / 3;
        System.out.println("width = " + width);
        int heigth = p_height / 5;
        System.out.println("heigth = " + heigth);
        int x = (p_width - width) / 2;
        int y = (p_height - heigth) / 2;
        dialog.setBounds(x, y, width, heigth);
        dialog.setDefaultCloseOperation(
                JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                ;
            }
        });
        JProgressBar progress_bar = new JProgressBar();
        progress_bar.setSize(width, heigth);
        progress_bar.setIndeterminate(true);
        dialog.add(progress_bar);
        dialog.pack();
//        dialog.setVisible(true);
        return dialog;
    }

    public void loadGame() {
        JFileChooser chooser = new JFileChooser();
        String path_name = System.getProperty("user.dir")
                + System.getProperty("file.separator") + "SAV";
        chooser.setCurrentDirectory(new File(path_name));
        int returnVal = chooser.showOpenDialog(this);
        System.out.println("path_name = " + path_name);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String load_name = chooser.getCurrentDirectory().getAbsolutePath()
                    + System.getProperty("file.separator")
                    + chooser.getSelectedFile().getName();

            System.out.println("load_name = " + load_name);
//            JDialog load_dialog = showProgressBar("Loading game");

            loadsave_dialog = showProgressBar("Loading game");
            Cursor cursor = this.getCursor();
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            new LoadWorker(this, load_name).execute();

            loadsave_dialog.setVisible(true);
            this.setCursor(cursor);
        }
    }

    public void saveGame() {
        JFileChooser chooser = new JFileChooser();
//        FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                "JPG & GIF Images", "jpg", "gif");
//        chooser.setFileFilter(filter);
        String path_name = System.getProperty("user.dir")
                + System.getProperty("file.separator") + "SAV";
        chooser.setCurrentDirectory(new File(path_name));
        int returnVal = chooser.showSaveDialog(this);
        System.out.println("path_name = " + path_name);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            final String save_name = chooser.getCurrentDirectory().getAbsolutePath()
                    + System.getProperty("file.separator")
                    + chooser.getSelectedFile().getName();

            System.out.println("save_name = " + save_name);
//            FileOutputStream f;
//            ObjectOutput s;

            loadsave_dialog = showProgressBar("Saving game");
            Cursor cursor = this.getCursor();
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            new SaveWorker(this, save_name).execute();

            loadsave_dialog.setVisible(true);
            this.setCursor(cursor);
        }
    }

    private class LoadWorker extends SwingWorker<Void, Void> {

        private Gui gui;
        private String load_name;

        public LoadWorker(Gui gui, String load_name) {
            this.gui = gui;
            this.load_name = load_name;
        }

        public Void doInBackground() {
            while (!loadsave_dialog.isVisible()) {
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    ;
                }

            }
//            try {
//                Thread.sleep(5000);
//            } catch (Exception e) {
//                ;
//            }

            try (FileInputStream in = new FileInputStream(load_name);
                    GZIPInputStream gis = new GZIPInputStream(in);
                    ObjectInputStream s = new ObjectInputStream(gis)) {
                game = (Game) s.readObject();
                System.out.println("after read object");
                space_map.setGame(game);
                planet_map.setGame(game);
                planet_window.setGame(game);
                space_window.setGame(game);
                unit_info_window.setGame(game);
                main_menu.setGame(game);
                combat_window.setGame(game);
                galactic_map.setGame(game);
                globe_map.setGame(game);
                State.setGameRef(game);
                game.setPath(null);
                game.setJumpPath(null);
                Point p = game.getSelectedPoint();
                if (p == null) {
                    SU.selectNextUnmovedUnit();
                } else {
                    List<Unit> stack = game.getSelectedStack();
                    SU.centerMapOnUnit(stack.get(0));
                }
            } catch (Exception ex) {
                showInfoWindow("Load failed");
            }
            return null;
        }

        public void done() {
            gui.cancelLoadSaveDialog();
        }
    }

    private class SaveWorker extends SwingWorker<Void, Void> {

        private Gui gui;
        private String save_name;

        public SaveWorker(Gui gui, String save_name) {
            this.gui = gui;
            this.save_name = save_name;
        }

        public Void doInBackground() {
            while (!loadsave_dialog.isVisible()) {
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    ;
                }

            }
            try (FileOutputStream f = new FileOutputStream(save_name);
                    GZIPOutputStream gos = new GZIPOutputStream(f);
                    ObjectOutputStream s = new ObjectOutputStream(gos)) {

                s.writeObject(game);
                s.flush();
                System.out.println("after flush");
            } catch (Exception ex) {
                System.out.println(ex);
                showInfoWindow("Save failed");
            }
            return null;
        }

        public void done() {
            gui.cancelLoadSaveDialog();
        }
    }

    public void showInfoWindow(String message) {
        JOptionPane.showMessageDialog(this, message, null, JOptionPane.PLAIN_MESSAGE);
    }

    public void setMouseCursor() {

        int wt;
        int ht;
        if (ws.is_double) {
            wt = 64;
            ht = 64;
        } else {
            wt = 32;
            ht = 32;
        }

        BufferedImage bi = new BufferedImage(wt, ht, BufferedImage.TYPE_BYTE_INDEXED, color_index);
        WritableRaster wr = bi.getRaster();
        int[] cursor_img = Util.loadSquare("MOUSE.MSK", 0, 32 * 32);
        if (ws.is_double) {
            cursor_img = Util.scale2XImage(cursor_img, 32 * 32, 32);
        }
        wr.setPixels(0, 0, wt, ht, cursor_img);
        BufferedImage alpha_img = new BufferedImage(wt, ht, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = alpha_img.createGraphics();
        g2.drawImage(bi, 0, 0, null);
        g2.dispose();
        WritableRaster alpha_wr = alpha_img.getRaster();
        int[] trans_color = new int[4];

        alpha_wr.getPixel(0, ht - 1, trans_color);

        trans_color[3] = 0;
        int[] pixel = new int[4];
        for (int i = 0; i < ht; i++) {
            for (int j = 0; j < wt; j++) {
                alpha_wr.getPixel(i, j, pixel);
                if (pixel[0] == trans_color[0]
                        && pixel[1] == trans_color[1]
                        && pixel[2] == trans_color[2]) {
                    alpha_wr.setPixel(i, j, trans_color);
                }

            }

        }

        this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(alpha_img, new Point(0, 0), "sceptor"));

    }

    public void enableLaunchButton(boolean enabled) {
        launch_button.setEnabled(enabled);
    }

    public void setUpLaunchButton() {

        launch_button_enabled = new ButtonIcon(ws.launch_button_width, ws.launch_button_height, "bin/efsbut3.bin", 0, color_index, ws);

        int file_offset = 3;
        launch_button_disabled = new ButtonIcon(ws.launch_button_width, ws.launch_button_height, "bin/efsbut3.bin", file_offset, color_index, ws);
        file_offset = 2;
        ButtonIcon launch_button_pressed = new ButtonIcon(ws.launch_button_width, ws.launch_button_height, "bin/efsbut3.bin", file_offset, color_index, ws);

        launch_button = new JButton();
        launch_button.setBorder(null);
        launch_button.setIcon(launch_button_enabled);
        launch_button.setDisabledIcon(launch_button_disabled);
        launch_button.setPressedIcon(launch_button_pressed);
        planet_window.add(launch_button);
        launch_button.setBounds(ws.launch_button_x_offset, ws.launch_button_y_offset,
                ws.launch_button_width, ws.launch_button_height);
        launch_button.setEnabled(false);
        launch_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.pressLaunchButton();
            }
        });
    }

    public void setMenus(boolean visible) {
        if (visible) {
            this.setJMenuBar(menubar);
        } else {
            this.setJMenuBar(no_menubar);
        }
    }
    // not used
//    public void showStackWindow() {
//        stack_window = new StackWindow(this);
//    }

    public void setDragUnit(Unit u, Point p) {
        drag_unit = u;
        drag_point = p;
    }

    public void setDragPoint(Point p) {
        drag_point = p;
    }

    public Unit getDragUnit() {
        return drag_unit;
    }

    public Point getDragPoint() {
        return drag_point;
    }

    public void showTooManyUnits() {
        JOptionPane.showMessageDialog(this, "Too many units in the destination area.", null, JOptionPane.PLAIN_MESSAGE);
    }

    public Color getColorCycleColor() {
        return color_cycle_color;
    }

    public void setColorCycle() {
        color_cycle_colors = new Color[5];
        for (int i = 0; i < color_cycle_colors.length; i++) {
            color_cycle_colors[i] = new Color(150 - 10 * i, 150 - 10 * i, 255);

        }
    }

    public void startStackMove() {
        setStack_move_counter(0);
        setStack_moving(true);
        setStop_stack(false);
        getStack_move_timer().start();
    }

    public void stopStackMove() {
        setStop_stack(true);
    }

    public int getStackMoveCounter() {
        return getStack_move_counter();
    }

    public boolean getStackMove() {
        return isStack_moving();
    }

    public boolean getAnimationBlink() {
        return animation_blink;
    }

    public void setStateReferences() {
        State.setReferences(this, game, ws);
    }

    public static IndexColorModel getICM() {
        return color_index;
    }

    public IndexColorModel loadICM() {

        return new IndexColorModel(8, 256, pallette[2], pallette[1], pallette[0], 256);
    }

    public static int[][] getUnitIcons() {
        return unit_icons;
    }

    public static void loadHexTiles() {
        hex_tiles = new int[C.TILE_SETS][][];
        for (int i = 0; i < C.TILE_SETS; i++) {
            hex_tiles[i] = Util.loadHexTiles("bin/efstile" + i + ".bin", 134);

        }
    }

    public static void loadStructureTiles() {
        structures = new int[C.TILE_SETS][][];
        for (int i = 0; i < C.TILE_SETS; i++) {
            structures[i] = Util.loadHexTiles("bin/struct" + i + ".bin", 32);

        }
    }

    public static int[][] getHexTiles(int tile_set) {
        return hex_tiles[tile_set];
    }

    public static int[][] getStructureTiles(int tile_set) {
        return structures[tile_set];
    }

    public static WindowSize getWindowSize() {
        return ws;
    }

    public Game getGame() {
        return game;
    }

    public byte[][] getPallette() {
        return pallette;
    }

    public JPanel getMainWindows() {
        return main_windows;
    }

    public JPanel getPlanetWindow() {
        return planet_window;
    }

    public JPanel getSpaceWindow() {
        return space_window;
    }

    public void setCurrentState(State s) {
        state = s;
//        state_ref.setState(s);
    }

    public State getCurrentState() {
        return state;
//        return state_ref.getState();
    }

    public void setUpMainMenu() {
        main_menu.setDefaultHumanControl();
    }

    private static void createAndShowGUI() {
        Gui gui = new Gui();
        gui.setStateReferences();
        gui.setUpMainMenu();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gui.args = args;
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void execute(String[] args) {
        Gui.args = args;
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * @return the stack_move_counter
     */
    public int getStack_move_counter() {
        return stack_move_counter;
    }

    /**
     * @param stack_move_counter the stack_move_counter to set
     */
    public void setStack_move_counter(int stack_move_counter) {
        this.stack_move_counter = stack_move_counter;
    }

    /**
     * @return the stop_stack
     */
    public boolean isStop_stack() {
        return stop_stack;
    }

    /**
     * @param stop_stack the stop_stack to set
     */
    public void setStop_stack(boolean stop_stack) {
        this.stop_stack = stop_stack;
    }

    /**
     * @return the stack_moving
     */
    public boolean isStack_moving() {
        return stack_moving;
    }

    /**
     * @param stack_moving the stack_moving to set
     */
    public void setStack_moving(boolean stack_moving) {
        this.stack_moving = stack_moving;
    }

    /**
     * @return the stack_move_timer
     */
    public Timer getStack_move_timer() {
        return stack_move_timer;
    }

    /**
     * @param stack_move_timer the stack_move_timer to set
     */
    public void setStack_move_timer(Timer stack_move_timer) {
        this.stack_move_timer = stack_move_timer;
    }

    /**
     * @return the info_unit
     */
    public Unit getInfo_unit() {
        return info_unit;
    }

    /**
     * @param info_unit the info_unit to set
     */
    public void setInfo_unit(Unit info_unit) {
        this.info_unit = info_unit;
    }
}