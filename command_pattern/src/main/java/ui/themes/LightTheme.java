package ui.themes;

import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.ColorUIResource;

public class LightTheme extends DefaultMetalTheme {

    @Override
    public String getName() {
        return "Light Theme";
    }

    private final ColorUIResource primary1 = new ColorUIResource(160, 190, 255);
    private final ColorUIResource primary2 = new ColorUIResource(200, 220, 255);
    private final ColorUIResource primary3 = new ColorUIResource(220, 235, 255);

    private final ColorUIResource secondary1 = new ColorUIResource(240, 240, 240);
    private final ColorUIResource secondary2 = new ColorUIResource(220, 220, 220);
    private final ColorUIResource secondary3 = new ColorUIResource(200, 200, 200);

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
}
