package grails4_springloaded

import basex.BasexEntityReference
import basex.TestSomething

class Bar {

//    static basexHasMany = [hints: new BasexEntityReference<Foo>(Foo, this)]
    static basexHasMany = [hints: new TestSomething<Foo>()]


//    static TestSomething testSomething = new TestSomething()


    static test_bla = ['helloWorld']

    static transients = ['basexHasMany', 'testSomething']
    static constraints = {
    }



    def foo(){
        new BasexEntityReference<Foo>(Foo, this.class)
    }
}
