import org.junit.Test;
import static org.junit.Assert.*;

public class RoverTest {

  @Test
  public void testThatRoverDefault() {
    Rover rover = new Rover();
    assertSame(0, rover.position.getX());
    assertSame(0, rover.position.getY());
    assertSame("N", rover.position.getDirection());
  }

  @Test
  public void testThatRoverCanMoveNorth() {
    Rover rover = new Rover();
    rover.setPosition(1, 1, "N");
    rover.move(1);
    assertSame(2, rover.position.getY());
  }
  @Test
  public void testThatRoverCanMoveEast() {
    Rover rover = new Rover();
    rover.setPosition(1, 1, "E");
    rover.move(1);
    assertSame(2, rover.position.getX());
  }
  @Test
  public void testThatRoverCanMoveSouth() {
    Rover rover = new Rover();
    rover.setPosition(1, 1, "S");
    rover.move(1);
    assertSame(0, rover.position.getY());
  }
  @Test
  public void testThatRoverCanMoveWest() {
    Rover rover = new Rover();
    rover.setPosition(1, 1, "W");
    rover.move(1);
    assertSame(0, rover.position.getX());
  }

  @Test
  public void testThatRoverCanTurnLeft() {
    Rover rover = new Rover();
    rover.setPosition(1, 1, "N");
    rover.turn("L");
    assertSame("W", rover.position.getDirection());
  }
  @Test
  public void testThatRoverCanTurnLeftTwice() {
    Rover rover = new Rover();
    rover.setPosition(1, 1, "N");
    rover.turn("L");
    rover.turn("L");
    assertSame("S", rover.position.getDirection());
  }
  @Test
  public void testThatRoverCanTurnRight() {
    Rover rover = new Rover();
    rover.setPosition(1, 1, "N");
    rover.turn("R");
    assertSame("E", rover.position.getDirection());
  }
  @Test
  public void testThatRoverCanTurnRightTwice() {
    Rover rover = new Rover();
    rover.setPosition(1, 1, "N");
    rover.turn("R");
    rover.turn("R");
    assertSame("S", rover.position.getDirection());
  }

  @Test
  public void testThatRoverCanSetPositionString() {
    Rover rover = new Rover();
    rover.setPositionString("1 3 E");
    assertEquals("1 3 E", rover.getPositionString());
  }

  @Test
  public void testTheFirstFormula() {
    Rover rover = new Rover();
    rover.setPosition(1, 2, "N");
    assertEquals("1 3 N", rover.command("LMLMLMLMM"));
  }

  @Test
  public void testTheSecondFormula() {
    Rover rover = new Rover();
    rover.setPosition(3, 3, "E");
    assertEquals("5 1 E", rover.command("MMRMMRMRRM"));
  }

  @Test
  public void testThatNorthIs0deg() {
    Rover rover = new Rover();
    assertSame(0, rover.position.getX());
    assertSame(0, rover.position.getY());
    assertSame("N", rover.position.getDirection());
  }
  @Test
  public void testThatEastIs90deg() {
    Rover rover = new Rover();
    assertSame("E", rover.angleToDirection(90));
    assertSame("E", rover.angleToDirection(-270));
  }
  @Test
  public void testThatSouthIs180deg() {
    Rover rover = new Rover();
    assertSame("S", rover.angleToDirection(180));
    assertSame("S", rover.angleToDirection(-180));
  }
  @Test
  public void testThatWestIs270deg() {
    Rover rover = new Rover();
    assertSame("W", rover.angleToDirection(270));
    assertSame("W", rover.angleToDirection(-90));
  }

}
