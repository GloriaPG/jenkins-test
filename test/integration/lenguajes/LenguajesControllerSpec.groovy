package lenguajes

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(LenguajesController)
@Mock(Lenguajes)
class LenguajesControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.lenguajesInstanceList
        model.lenguajesInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.lenguajesInstance != null
    }



    void "Test that the show action returns the correct model"() {
        when: "The show action is executed with a null domain"
        controller.show(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the show action"
        populateValidParams(params)
        def lenguajes = new Lenguajes(params)
        controller.show(lenguajes)

        then: "A model is populated containing the domain instance"
        model.lenguajesInstance == lenguajes
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def lenguajes = new Lenguajes(params)
        controller.edit(lenguajes)

        then: "A model is populated containing the domain instance"
        model.lenguajesInstance == lenguajes
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when: "Update is called for a domain instance that doesn't exist"
        controller.update(null)

        then: "A 404 error is returned"
        status == 404

        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def lenguajes = new Lenguajes()
        lenguajes.validate()
        controller.update(lenguajes)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.lenguajesInstance == lenguajes

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        lenguajes = new Lenguajes(params).save(flush: true)
        controller.update(lenguajes)

        then: "A redirect is issues to the show action"
        response.redirectedUrl == "/lenguajes/show/$lenguajes.id"
        flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when: "The delete action is called for a null instance"
        controller.delete(null)

        then: "A 404 is returned"
        status == 404

        when: "A domain instance is created"
        response.reset()
        populateValidParams(params)
        def lenguajes = new Lenguajes(params).save(flush: true)

        then: "It exists"
        Lenguajes.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(lenguajes)

        then: "The instance is deleted"
        Lenguajes.count() == 0
        response.redirectedUrl == '/lenguajes/index'
        flash.message != null
    }
}
