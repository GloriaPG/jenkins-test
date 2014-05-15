package peliculas

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(PeliculasController)
@Mock(Peliculas)
class PeliculasControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.peliculasInstanceList
        model.peliculasInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.peliculasInstance != null
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        def peliculas = new Peliculas()
        peliculas.validate()
        controller.save(peliculas)

        then: "The create view is rendered again with the correct model"
        model.peliculasInstance != null
        view == 'create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        peliculas = new Peliculas(params)

        controller.save(peliculas)

        then: "A redirect is issued to the show action"
        response.redirectedUrl == '/peliculas/show/1'
        controller.flash.message != null
        Peliculas.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when: "The show action is executed with a null domain"
        controller.show(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the show action"
        populateValidParams(params)
        def peliculas = new Peliculas(params)
        controller.show(peliculas)

        then: "A model is populated containing the domain instance"
        model.peliculasInstance == peliculas
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def peliculas = new Peliculas(params)
        controller.edit(peliculas)

        then: "A model is populated containing the domain instance"
        model.peliculasInstance == peliculas
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when: "Update is called for a domain instance that doesn't exist"
        controller.update(null)

        then: "A 404 error is returned"
        status == 404

        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def peliculas = new Peliculas()
        peliculas.validate()
        controller.update(peliculas)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.peliculasInstance == peliculas

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        peliculas = new Peliculas(params).save(flush: true)
        controller.update(peliculas)

        then: "A redirect is issues to the show action"
        response.redirectedUrl == "/peliculas/show/$peliculas.id"
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
        def peliculas = new Peliculas(params).save(flush: true)

        then: "It exists"
        Peliculas.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(peliculas)

        then: "The instance is deleted"
        Peliculas.count() == 0
        response.redirectedUrl == '/peliculas/index'
        flash.message != null
    }
}
