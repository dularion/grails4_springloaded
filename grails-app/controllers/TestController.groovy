import basex.BasexEntityReference

class TestController {

  def test(){
    render "OK!!!!!!!?"

    new BasexEntityReference("hello", "open")  //this kills the application
  }
}
