package com.kodekonveyor.tidyup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("dummy behaviour")
@SpringBootTest
public class DummyIT {

  @Test
  public void test() {
    Assertions.assertTrue(true);
  }
}
