package com.test

import org.scalatest.{ FunSpec, Matchers }

class TestMe() extends FunSpec with Matchers {

  val gb = GraalBoom()

  it("Does it work") {
    val jsCode = "var myfn = function(options){ return options.hash['tidal']; }"
    gb.javascript.eval(jsCode)
    gb.jsRun("myfn", List(new Options())) should be("wave")
  }
}