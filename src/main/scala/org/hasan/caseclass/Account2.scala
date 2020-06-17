package org.hasan.caseclass

// Need to pass abstract class parameters after extends
case class Account2(accountId: String, enabled: Boolean)
    extends AccountAbstract(accountId)
