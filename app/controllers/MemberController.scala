package controllers

import models.members

import javax.inject._
import play.api.mvc._

class MemberController @Inject()(cc: ControllerComponents) extends AbstractController(cc){

  def member = Action{
    val memdetails = members.stu
    Ok(views.html.member(memdetails))
  }
}
