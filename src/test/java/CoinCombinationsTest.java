import org.junit.*;
import static org.junit.Assert.*;

public class CoinCombinationsTest {
  //
  @Test
  public void isChangeReturning_CorrectQuarters_true() {

    App testcoinCombinations = new App();
    Integer numThree = 3;
    assertEquals(numThree, testcoinCombinations.changeCalculations(93).get("quarters"));

  }

    @Test
    public void isChangeReturning_CorrectQuarters_false() {

     CoinCombinations testcoinCombinations = new CoinCombinations();
      Integer numFive = 2;
      assertEquals(numFive, testcoinCombinations.changeCalculations(93).get("quarters"));

    }
}
