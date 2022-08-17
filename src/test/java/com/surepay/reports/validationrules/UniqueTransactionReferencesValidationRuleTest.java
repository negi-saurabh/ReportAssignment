package com.surepay.reports.validationrules;

import com.surepay.reports.beans.TransactionRecord;
import com.surepay.reports.interfaces.IValidationRule;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class UniqueTransactionReferencesValidationRuleTest {
  private IValidationRule validationRule;
  private TransactionRecord record;
  private Set<String> referenceSet;

  @Before
  public void setUp() throws Exception {
    validationRule = new UniqueTransactionReferencesValidationRule();
    referenceSet = new HashSet<>();
    referenceSet.add("ABC");
    referenceSet.add("2");
    referenceSet.add("3");
    referenceSet.add("4");
  }

  @Test
  @DisplayName("UniqueTransactionReferencesValidationRule with duplicate reference")
  public void test_isValid_False_DuplicateReference() {
    record = new TransactionRecord("ABC","ABNA00000", "TEST", 5.2, -1.0, 4.2 );
    Assert.assertEquals(validationRule.isValid(record), false);
  }

  @Test
  @DisplayName("UniqueTransactionReferencesValidationRule with a new reference")
  public void test_isValid_True_NewReference() {
    record = new TransactionRecord("XYZ","ABNA00000", "TEST", 5.2, -1.0, 9.2 );
    Assert.assertEquals(validationRule.isValid(record), true);
  }

}