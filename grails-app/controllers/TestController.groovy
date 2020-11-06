import basex.BasexEntityReference

class TestController {

  def test(){
    def basexEntityReference = new BasexEntityReference("hello", "open")  //this kills the application
    render basexEntityReference.name
  }
}
