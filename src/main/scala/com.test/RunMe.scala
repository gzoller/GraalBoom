package com.test

object RunMe extends App {
  val jsCode = """var myfn = function(options){ return options.hash['tidal']; }"""
  val gb = GraalBoom()
  gb.javascript.eval(jsCode)

  println(gb.jsRun("myfn", List(new Options())))
}

