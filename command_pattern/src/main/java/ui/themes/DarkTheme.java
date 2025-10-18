package ui.themes;

import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.ColorUIResource;

public class DarkTheme extends DefaultMetalTheme {

    @Override
    public String getName() {
        return "Dark Theme";
    }

    private final ColorUIResource primary1 = new ColorUIResource(66, 66, 66);
    private final ColorUIResource primary2 = new ColorUIResource(99, 99, 99);
    private final ColorUIResource primary3 = new ColorUIResource(122, 122, 122);

    private final ColorUIResource secondary1 = new ColorUIResource(0, 0, 0);
    private final ColorUIResource secondary2 = new ColorUIResource(51, 51, 51);
    private final ColorUIResource secondary3 = new ColorUIResource(102, 102, 102);

    private final ColorUIResource black = new ColorUIResource(222, 222, 222);
    private final ColorUIResource white = new ColorUIResource(30, 30, 30);

    @Override
    public ColorUIResource getPrimary1() {
        return primary1;
    }

    @Override
    public ColorUIResource getPrimary2() {
        return primary2;
    }

    @Override
    public ColorUIResource getPrimary3() {
        return primary3;
    }

    @Override
    public ColorUIResource getSecondary1() {
        return secondary1;
    }

    @Override
    public ColorUIResource getSecondary2() {
        return secondary2;
    }

    @Override
    public ColorUIResource getSecondary3() {
        return secondary3;
    }

    @Override
    public ColorUIResource getBlack() {
        return black;
    }

    @Override
    public ColorUIResource getWhite() {
        return white;
    }
}
