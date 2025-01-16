package exercise;

// BEGIN
public class App {

    public static void printSquare(Circle circle) {
        try {
            int square = (int) Math.round(circle.getSquare());
            System.out.println(square);
        } catch (NegativeRadiusException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
