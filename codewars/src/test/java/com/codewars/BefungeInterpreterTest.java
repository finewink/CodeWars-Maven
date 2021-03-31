package com.codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BefungeInterpreterTest {
  @Test
  public void tests() {
    assertEquals("123456789", new BefungeInterpreter().interpret(">987v>.v\nv456<  :\n>321 ^ _@"));
    System.out.println(new java.util.Random().nextInt(3) - 1);
  }

  @Test
  public void tests2() {
    assertEquals("Hello World!",
        new BefungeInterpreter().interpret("25*\"!dlroW olleH\":v\n                v:,_@\n                >  ^"));
  }

  @Test
  public void tests3() {
    assertEquals("Hello World!", new BefungeInterpreter().interpret("1# +# :# 0# g# ,# :# 5# 8# *# 4# +# -# _@"));

  }

  @Test
  public void sieve() {
    assertEquals("23571113171923293137", new BefungeInterpreter().interpret(
        "2>:3g\" \"-!v\\  g30          <\n |!`\"&\":+1_:.:03p>03g+:\"&\"`|\n @               ^  p3\\\" \":<\n2 2345678901234567890123456789012345678"));
  }

  @Test
  public void quine() {
    assertEquals("", new BefungeInterpreter().interpret("01->1# +# :# 0# g# ,# :# 5# 8# *# 4# +# -# _@"));
  }
}
