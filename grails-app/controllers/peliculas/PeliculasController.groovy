package peliculas



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PeliculasController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Peliculas.list(params), model:[peliculasInstanceCount: Peliculas.count()]
    }

    def show(Peliculas peliculasInstance) {
        respond peliculasInstance
    }

    def create() {
        respond new Peliculas(params)
    }

    @Transactional
    def save(Peliculas peliculasInstance) {
        if (peliculasInstance == null) {
            notFound()
            return
        }

        if (peliculasInstance.hasErrors()) {
            respond peliculasInstance.errors, view:'create'
            return
        }

        peliculasInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'peliculasInstance.label', default: 'Peliculas'), peliculasInstance.id])
                redirect peliculasInstance
            }
            '*' { respond peliculasInstance, [status: CREATED] }
        }
    }

    def edit(Peliculas peliculasInstance) {
        respond peliculasInstance
    }

    @Transactional
    def update(Peliculas peliculasInstance) {
        if (peliculasInstance == null) {
            notFound()
            return
        }

        if (peliculasInstance.hasErrors()) {
            respond peliculasInstance.errors, view:'edit'
            return
        }

        peliculasInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Peliculas.label', default: 'Peliculas'), peliculasInstance.id])
                redirect peliculasInstance
            }
            '*'{ respond peliculasInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Peliculas peliculasInstance) {

        if (peliculasInstance == null) {
            notFound()
            return
        }

        peliculasInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Peliculas.label', default: 'Peliculas'), peliculasInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'peliculasInstance.label', default: 'Peliculas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
