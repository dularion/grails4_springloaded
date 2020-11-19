import basex.BasexEntityReference
import grails4_springloaded2.Foo

class TestController {

  def test(){
    def foo = new Foo(name: "hello")
    foo.save()
    foo.deproxy()
    foo as Foo
    render foo.name + "!"
  }
}
