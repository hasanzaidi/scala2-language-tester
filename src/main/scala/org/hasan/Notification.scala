package org.hasan

abstract class Notification

final case class Email(sender: String, title: String, body: String) extends Notification

final case class SMS(caller: String, message: String) extends Notification

final case class VoiceRecording(contactName: String, link: String) extends Notification
