package org.hasan.caseclass

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class CaseClassSuite extends AnyFunSuite with Matchers {
  test("Case classes which extend abstract class or trait") {
    val policyData = Account("123", false)
    policyData.inForce shouldBe false
    policyData.policyNumber should equal("123")

    val policyData2 = Account2("123", false)
    policyData2.enabled shouldBe false
    policyData2.accountId should equal("123")
  }
}
