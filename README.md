This test shows an explosion I'm having with graal.js.  I've reduced the problem to a minimal chunk of code.

Method to demonstrate the problem:

1. Clone the archive locally
2. sbt

> test


This will build the code and run the test.

The first time it will work fine. (All tests passed message in green.)
Without leaving sbt, run it again:

> test

Now you'll see the error below.  I'm passing a ProxyObject concrete class into the engine as an argument to my function.  The first run, everything seems to work fine, but on subsequent runs, the engine seems to look for a method 'getField' on my proxy, but ProxyObject defines no such method.

```
[info] TestMe:
[info] - Does it work *** FAILED ***
[info]   javax.script.ScriptException: org.graalvm.polyglot.PolyglotException: java.lang.IllegalStateException: java.lang.IllegalAccessException: no such field: com.test.Options.hash/com.test.MapProxyObject/getField
[info]   at com.oracle.truffle.js.scriptengine.GraalJSScriptEngine.invoke(GraalJSScriptEngine.java:402)
[info]   at com.oracle.truffle.js.scriptengine.GraalJSScriptEngine.invokeFunction(GraalJSScriptEngine.java:390)
[info]   at com.test.GraalBoom.jsRun(GraalBoom.scala:17)
[info]   at com.test.TestMe.$anonfun$new$1(TestMe.scala:12)
[info]   at org.scalatest.OutcomeOf.outcomeOf(OutcomeOf.scala:85)
[info]   at org.scalatest.OutcomeOf.outcomeOf$(OutcomeOf.scala:83)
[info]   at org.scalatest.OutcomeOf$.outcomeOf(OutcomeOf.scala:104)
[info]   at org.scalatest.Transformer.apply(Transformer.scala:22)
[info]   at org.scalatest.Transformer.apply(Transformer.scala:20)
[info]   at org.scalatest.FunSpecLike$$anon$1.apply(FunSpecLike.scala:455)
[info]   ...
[info]   Cause: org.graalvm.polyglot.PolyglotException: java.lang.IllegalStateException: java.lang.IllegalAccessException: no such field: com.test.Options.hash/com.test.MapProxyObject/getField
[info]   at com.oracle.truffle.polyglot.HostFieldDesc$MHImpl.makeGetMethodHandle(HostFieldDesc.java:200)
[info]   at com.oracle.truffle.polyglot.HostFieldDesc$MHImpl.get(HostFieldDesc.java:156)
[info]   at com.oracle.truffle.polyglot.HostObject$ReadFieldNode.doCached(HostObject.java:1151)
[info]   at com.oracle.truffle.polyglot.HostObjectFactory$ReadFieldNodeGen.executeAndSpecialize(HostObjectFactory.java:1272)
[info]   at com.oracle.truffle.polyglot.HostObjectFactory$ReadFieldNodeGen.execute(HostObjectFactory.java:1237)
[info]   at com.oracle.truffle.polyglot.HostObject.readMember(HostObject.java:239)
[info]   at com.oracle.truffle.polyglot.HostObjectGen$InteropLibraryExports$Cached.readMemberNode_AndSpecialize(HostObjectGen.java:1221)
[info]   at com.oracle.truffle.polyglot.HostObjectGen$InteropLibraryExports$Cached.readMember(HostObjectGen.java:1199)
[info]   at com.oracle.truffle.api.interop.InteropLibraryGen$CachedDispatch.readMember(InteropLibraryGen.java:2983)
[info]   at com.oracle.truffle.js.nodes.access.PropertyGetNode$ForeignPropertyGetNode.foreignGet(PropertyGetNode.java:913)
[info]   ...
```