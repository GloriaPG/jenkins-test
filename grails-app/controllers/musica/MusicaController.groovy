package musica



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MusicaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Musica.list(params), model:[musicaInstanceCount: Musica.count()]
    }

    def show(Musica musicaInstance) {
        respond musicaInstance
    }

    def create() {
        respond new Musica(params)
    }

    @Transactional
    def save(Musica musicaInstance) {
        if (musicaInstance == null) {
            notFound()
            return
        }

        if (musicaInstance.hasErrors()) {
            respond musicaInstance.errors, view:'create'
            return
        }

        musicaInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'musicaInstance.label', default: 'Musica'), musicaInstance.id])
                redirect musicaInstance
            }
            '*' { respond musicaInstance, [status: CREATED] }
        }
    }

    def edit(Musica musicaInstance) {
        respond musicaInstance
    }

    @Transactional
    def update(Musica musicaInstance) {
        if (musicaInstance == null) {
            notFound()
            return
        }

        if (musicaInstance.hasErrors()) {
            respond musicaInstance.errors, view:'edit'
            return
        }

        musicaInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Musica.label', default: 'Musica'), musicaInstance.id])
                redirect musicaInstance
            }
            '*'{ respond musicaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Musica musicaInstance) {

        if (musicaInstance == null) {
            notFound()
            return
        }

        musicaInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Musica.label', default: 'Musica'), musicaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'musicaInstance.label', default: 'Musica'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
