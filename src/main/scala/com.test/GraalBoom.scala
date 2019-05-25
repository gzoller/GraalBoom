package com.test

import javax.script._

case class GraalBoom() {

  val javascript = {
    val engine = new ScriptEngineManager().getEngineByName("graal.js")
    val bindings = engine.createBindings()
    bindings.put("polyglot.js.allowAllAccess", true)
    engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE)
    engine
  }

  def jsRun(fnName: String, args: List[Object]): Object = {
    val inv = javascript.asInstanceOf[Invocable]
    inv.invokeFunction(fnName, args: _*)
  }

}
