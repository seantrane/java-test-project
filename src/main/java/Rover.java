/**
 * A rover cable of turning 4 cardinal directions and moving 1 unit.
 * Can receive Left, Right, Move commands via char-string; "LRM" and
 * provide current coordinates and direction in response.
 *
 * Usage:
 *   Rover rover = new Rover();
 *   rover.setPosition(1, 2, "N");
 *   rover.command("LMLMLMLMM"); // 1 3 N
 *   rover.setPositionString("3 3 E");
 *   rover.command("MMRMMRMRRM"); // 5 1 E
 * Internals:
 *   rover.turn("R");
 *   rover.move(1);
 */
public class Rover {

  RoverPosition position;

  public Rover() {
    setPosition(0, 0, "N");
  }

  public RoverPosition getPosition() {
    return position;
  }
  public void setPosition(int xInput, int yInput, String directionInput) {
    position = new RoverPosition(xInput, yInput, directionInput);
  }

  public String getPositionString() {
    return String.format("%s %s %s", position.getX(), position.getY(), position.getDirection());
  }
  public void setPositionString(String positionString) {
    String[] split = positionString.split(" ");
    position.setX(Integer.valueOf(split[0]));
    position.setY(Integer.valueOf(split[1]));
    position.setDirection(split[2]);
  }

  public String command(String input) {
    char[] chars = input.toCharArray();
    for (char ch : chars) {
      if (ch == 'M') {
        move(1);
      } else if (ch == 'L' || ch == 'R') {
        turn(Character.toString(ch));
      }
    }
    return getPositionString();
  }

  public void move(int units) {
    switch (position.getDirection()) {
      case "N":
        position.setY(position.getY() + units);
        break;
      case "E":
        position.setX(position.getX() + units);
      break;
      case "S":
        position.setY(position.getY() - units);
        break;
      case "W":
        position.setX(position.getX() - units);
      break;
      default:
        break;
    }
  }

  public void turn(String turn) {
    String newDirection = position.getDirection();
    switch (position.getDirection()) {
      case "N":
        newDirection = (turn == "L") ? "W" : "E";
        break;
      case "E":
        newDirection = (turn == "L") ? "N" : "S";
        break;
      case "S":
        newDirection = (turn == "L") ? "E" : "W";
        break;
      case "W":
        newDirection = (turn == "L") ? "S" : "N";
        break;
      default:
        break;
    }
    position.setDirection(newDirection);
  }

  public String angleToDirection(double angle) {
    String directions[] = {"N", "NE", "E", "SE", "S", "SW", "W", "NW", "N"};
    angle = normalizeAngle(angle);
    return directions[ (int)Math.round(( ((double)angle % 360) / 45)) ];
  }

  public double directionToAngle(String myDirection) {
    int degree = 0;
    switch (myDirection) {
      case "E":
        degree = 90;
        break;
      case "S":
        degree = 180;
        break;
      case "W":
        degree = 270;
        break;
      default:
        break;
    }
    return 0;
  }

  public double normalizeAngle(double angle) {
    if (angle < 0) {
      angle += 360;
    }
    if (angle > 360) {
      angle -= 360;
    }
    return angle;
  }

}