public class RoverPosition {

  String direction;
  int x;
  int y;

  public RoverPosition(int xInput, int yInput, String directionInput) {
    x = xInput;
    y = yInput;
    direction = directionInput;
  }

  public String getDirection() {
    return direction;
  }
  public void setDirection(String str) {
    direction = str;
  }

  public int getX() {
    return x;
  }
  public void setX(int deg) {
    x = deg;
  }

  public int getY() {
    return y;
  }
  public void setY(int deg) {
    y = deg;
  }


}