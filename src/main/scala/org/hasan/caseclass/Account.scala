package org.hasan.caseclass

// Need an "override val" if extending a trait
case class Account(override val policyNumber: String, inForce: Boolean)
    extends AccountTrait
