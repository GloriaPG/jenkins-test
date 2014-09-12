package lenguajes



import spock.lang.*

/**
 *
 */
class LenguajesSpec extends Specification {

    def setup() {
        //Save
        Lenguajes lenguajes=new Lenguajes(lenguaje:'Java',experiencia:'10 años',ejemplo:'xxxx',conclusion:'Es un lenguaje flexible y multiplataforma.')
        lenguajes.save(failOnError: true)

        //Update
        Lenguajes lenguajesUpdate=lenguajes.get(1)
        lenguajesUpdate.lenguaje="Java 7"
        lenguajesUpdate.save(failOnError: true)
    }

    def cleanup() {
    }

    void "Test Domain"() {
         println "jajajajaaj probando"
        setup:"SAVE and UPDATE "
        //Save
        def lenguajes=new Lenguajes(lenguaje:'Java',experiencia:'10 años',ejemplo:'ejemplo X',conclusion:'Es un lenguaje flexible y multiplataforma.')


        expect:'SAVING ,UPDATING'
        lenguajes.save(failOnError: true)
    }


     void "Test two"() {
         println "Not let me down :( "
        setup:"SAVE and UPDATE "
        //Save
        def lenguajes=new Lenguajes(lenguaje:'Java',experiencia:'10 años',ejemplo:'ejemplo X',conclusion:'Es un lenguaje flexible y multiplataforma.')


        expect:'SAVING ,UPDATING'
        lenguajes.save(failOnError: true)
    }
}
