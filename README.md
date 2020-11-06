# grails4_springloaded

Depencendies: 
- JDK 8
- Grails 4.1.0.M2
- springloaded (as outlined here https://github.com/grails/grails-core/pull/11441)

Example project with Failing SpringLoaded implementation due to abstract class usage. 


Very simple class structure: 

```groovy

// the abstract class
abstract class BasexAssociation {
  protected String name

  BasexAssociation() {
  }
 }
 
 
// the subclass
class BasexEntityReference extends BasexAssociation {
  String status

  BasexEntityReference(String name, String status) {
    this.name = name   //this will break the application, because it sets the property of the abstract superclass
    this.status = status
  }
}

// a grails controller calling the constructor of BasexEntityReference
class TestController {

  def test(){
    def basexEntityReference = new BasexEntityReference("hello", "open")  //this kills the application
    render basexEntityReference.name
  }
}

```

Start the application and then visit: 
http://localhost:8080/test/test

the application then dies, with this error. 
```
#
# A fatal error has been detected by the Java Runtime Environment:
#
#  SIGSEGV (0xb) at pc=0x0000000000000000, pid=36877, tid=25603
#
# JRE version: Java(TM) SE Runtime Environment (8.0_40-b26) (build 1.8.0_40-b26)
# Java VM: Java HotSpot(TM) 64-Bit Server VM (25.40-b25 mixed mode bsd-amd64 compressed oops)
# Problematic frame:
# C  0x0000000000000000
#
# Failed to write core dump. Core dumps have been disabled. To enable core dumping, try "ulimit -c unlimited" before starting Java again
#
# An error report file with more information is saved as:
# /Users/antonia/dev/projects/Sandbox/grails4_springloaded/hs_err_pid36877.log
#
# If you would like to submit a bug report, please visit:
#   http://bugreport.java.com/bugreport/crash.jsp
#
```

Further in the log, you can find this: 

```
Exception <a 'java/lang/ClassNotFoundException': basex/BasexEntityReferenceBeanInfo> (0x00000007ba7bc9b8) thrown at ...
Exception <a 'java/lang/ClassNotFoundException': basex/BasexAssociationBeanInfo> (0x00000007ba7e4368) thrown at ...
Exception <a 'java/lang/ClassNotFoundException': basex/BasexAssociationCustomizer> (0x00000007ba80d758) thrown at ...
Exception <a 'java/lang/ClassNotFoundException': basex/BasexEntityReferenceCustomizer> (0x00000007ba841310) thrown at  ...

```


