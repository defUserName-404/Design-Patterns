package components;

/**
 * Just another feature of a car.
 */
public record GpsNavigator(String route) {
    public GpsNavigator() {
        this("221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London");
    }

}