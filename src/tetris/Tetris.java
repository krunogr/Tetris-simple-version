/*
 * Krunoslav Grčević
 * 20-12-2014
 * 
 */
package tetris;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Kruno
 */
public class Tetris {

    /**
     * @param args the command line arguments
     */
    static public boolean end = true;
    static int point1 = 0, point2 = 0, point3 = 0, point4 = 0;

    public static void main(String[] args) {
        Map<Integer, String> points = new HashMap<Integer, String>();
        int randomPiece = new Random().nextInt(4);

        String s = "";

        for (int i = 0; i <= 506; i++) {
            if (i % 23 == 0) {
                points.put(i, "*");

                i++;
                points.put(i, "\n");
                i++;

                points.put(i, "*");

            } else {
                if (i > 484) {

                    points.put(i, "*");
                } else {
                    points.put(i, " ");

                }
            }
        }

        for (int i = 25; i <= 506; i++) {
            points.put(i - 25, points.get(i));

        }

        int positionOfPiece = 0;

        createPiece(randomPiece, positionOfPiece);

        points.put(point1, "*");
        points.put(point2, "*");
        points.put(point3, "*");
        points.put(point4, "*");

        draw(points);
        while (end) {
            Scanner scanner = new Scanner(System.in);
            String user_move = scanner.next();

            switch (user_move) {
                case "a":
                    points = movePieceLeft(points);
                    break;
                case "d":
                    points = movePieceRight(points);
                    break;
                case "w":

                    break;
                case "s":

                    break;

            }
        }
    }

    private static Map<Integer, String> movePieceLeft(Map<Integer, String> points) {
        Map<Integer, String> newPoints = points;
        newPoints.put(point1, " ");
        newPoints.put(point2, " ");
        newPoints.put(point3, " ");
        newPoints.put(point4, " ");

        if (newPoints.get(point1 + 22) == " " && newPoints.get(point2 + 22) == " "
                && newPoints.get(point3 + 22) == " " && newPoints.get(point4 + 22) == " ") {
            point1 += 22;
            point2 += 22;
            point3 += 22;
            point4 += 22;
            newPoints.put(point1, "*");
            newPoints.put(point2, "*");
            newPoints.put(point3, "*");
            newPoints.put(point4, "*");
            draw(newPoints);
            return newPoints;
        } else {
            if (newPoints.get(point1 + 23) != " " || newPoints.get(point2 + 23) != " "
                    || newPoints.get(point3 + 23) != " " || newPoints.get(point4 + 23) != " ") {
                newPoints.put(point1, "*");
                newPoints.put(point2, "*");
                newPoints.put(point3, "*");
                newPoints.put(point4, "*");
                createPiece(new Random().nextInt(4), 0);
                newPoints.put(point1, "*");
                newPoints.put(point2, "*");
                newPoints.put(point3, "*");
                newPoints.put(point4, "*");
                draw(newPoints);
                return newPoints;
            } else {
                System.out.println("Action is not valid!  Try again");
                return points;

            }
        }
    }

    private static Map<Integer, String> movePieceRight(Map<Integer, String> points) {
        Map<Integer, String> newPoints = points;
        newPoints.put(point1, " ");
        newPoints.put(point2, " ");
        newPoints.put(point3, " ");
        newPoints.put(point4, " ");

        if (newPoints.get(point1 + 24) == " " && newPoints.get(point2 + 24) == " "
                && newPoints.get(point3 + 24) == " " && newPoints.get(point4 + 24) == " ") {
            if (point1 < 22) {
                System.out.println("Game Over!");
                end = true;
            }
            point1 += 24;
            point2 += 24;
            point3 += 24;
            point4 += 24;
            newPoints.put(point1, "*");
            newPoints.put(point2, "*");
            newPoints.put(point3, "*");
            newPoints.put(point4, "*");
            draw(newPoints);
            return newPoints;
        } else {
            if (newPoints.get(point1 + 23) != " " || newPoints.get(point2 + 23) != " "
                    || newPoints.get(point3 + 23) != " " || newPoints.get(point4 + 23) != " ") {
                if (point1 < 22) {
                    System.out.println("Game Over!");
                    end = true;
                }
                newPoints.put(point1, "*");
                newPoints.put(point2, "*");
                newPoints.put(point3, "*");
                newPoints.put(point4, "*");
                createPiece(new Random().nextInt(4), 0);
                newPoints.put(point1, "*");
                newPoints.put(point2, "*");
                newPoints.put(point3, "*");
                newPoints.put(point4, "*");

                draw(newPoints);
                return newPoints;
            } else {
                System.out.println("Action is not valid!  Try again");
                return points;

            }
        }
    }

    private static void draw(Map<Integer, String> points) {
        String s = "";
        for (int i = 0; i <= 481; i++) {
            s += points.get(i);

        }
        System.out.println(s);
    }

    private static void createPiece(int randomPiece, int positionOfPiece) {
        switch (randomPiece) {
            case 0:
                positionOfPiece = new Random().nextInt(17) + 1;
                point1 = positionOfPiece;
                point2 = positionOfPiece + 1;
                point3 = positionOfPiece + 2;
                point4 = positionOfPiece + 3;
                break;
            case 1:
                positionOfPiece = new Random().nextInt(19) + 1;
                point1 = positionOfPiece;
                point2 = positionOfPiece + 23;
                point3 = positionOfPiece + 46;
                point4 = positionOfPiece + 47;
                break;
            case 2:
                positionOfPiece = new Random().nextInt(19) + 2;
                point1 = positionOfPiece;
                point2 = positionOfPiece + 23;
                point3 = positionOfPiece + 45;
                point4 = positionOfPiece + 46;
                break;
            case 3:
                positionOfPiece = new Random().nextInt(19) + 2;
                point1 = positionOfPiece;
                point2 = positionOfPiece + 22;
                point3 = positionOfPiece + 23;
                point4 = positionOfPiece + 45;
                break;
            case 4:
                positionOfPiece = new Random().nextInt(19) + 1;
                point1 = positionOfPiece;
                point2 = positionOfPiece + 1;
                point3 = positionOfPiece + 23;
                point4 = positionOfPiece + 24;
                break;

        }
        System.out.println("Creation of a new point!");
    }
}
