package com.surepay.reports.validationrules;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IValidationRule;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;

public class BalanceCheckValidationRuleTest {
  private IValidationRule validationRule;
  private TransactionRecord record;

  @Before
  public void setUp() throws Exception {
    validationRule = new BalanceCheckValidationRule();
  }

  @Test
  @DisplayName("BalanceCheckValidationRule isTrue for NegativeMutation")
  public void test_isValid_True_NegativeMutation() {
    record = new TransactionRecord("ABC","ABNA00000", "TEST", 5.2, -1.0, 4.2 );
    Assert.assertEquals(validationRule.isValid(record), true);
  }

  @Test
  @DisplayName("BalanceCheckValidationRule isFalse for NegativeMutation")
  public void test_isValid_False_NegativeMutation() {
    record = new TransactionRecord("ABC","ABNA00000", "TEST", 5.2, -1.0, 9.2 );
    Assert.assertEquals(validationRule.isValid(record), false);
  }

  @Test
  @DisplayName("BalanceCheckValidationRule isTrue for PositiveMutation")
  public void test_isValid_True_PositiveMutation() {
    record = new TransactionRecord("ABC","ABNA00000", "TEST", 5.2, 6.07, 11.27 );
    Assert.assertEquals(validationRule.isValid(record), true);
  }

  @Test
  @DisplayName("BalanceCheckValidationRule isFalse for PositiveMutation")
  public void test_isValid_False_PositiveMutation() {
    record = new TransactionRecord("ABC","ABNA00000", "TEST", 5.2, 5.0, 5.45 );
    Assert.assertEquals(validationRule.isValid(record), false);
  }
}