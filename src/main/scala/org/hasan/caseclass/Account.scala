package org.hasan.caseclass

// Need an "override val" if extending a trait
final case class Account(override val policyNumber: String, inForce: Boolean) extends AccountTrait
