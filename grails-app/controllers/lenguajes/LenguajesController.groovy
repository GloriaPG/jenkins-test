package lenguajes



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LenguajesController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Lenguajes.list(params), model:[lenguajesInstanceCount: Lenguajes.count()]
    }

    def show(Lenguajes lenguajesInstance) {
        respond lenguajesInstance
    }

    def create() {
        respond new Lenguajes(params)
    }

    @Transactional
    def save(Lenguajes lenguajesInstance) {
        if (lenguajesInstance == null) {
            notFound()
            return
        }

        if (lenguajesInstance.hasErrors()) {
            respond lenguajesInstance.errors, view:'create'
            return
        }

        lenguajesInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'lenguajesInstance.label', default: 'Lenguajes'), lenguajesInstance.id])
                redirect lenguajesInstance
            }
            '*' { respond lenguajesInstance, [status: CREATED] }
        }
    }

    def edit(Lenguajes lenguajesInstance) {
        respond lenguajesInstance
    }

    @Transactional
    def update(Lenguajes lenguajesInstance) {
        if (lenguajesInstance == null) {
            notFound()
            return
        }

        if (lenguajesInstance.hasErrors()) {
            respond lenguajesInstance.errors, view:'edit'
            return
        }

        lenguajesInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Lenguajes.label', default: 'Lenguajes'), lenguajesInstance.id])
                redirect lenguajesInstance
            }
            '*'{ respond lenguajesInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Lenguajes lenguajesInstance) {

        if (lenguajesInstance == null) {
            notFound()
            return
        }

        lenguajesInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Lenguajes.label', default: 'Lenguajes'), lenguajesInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lenguajesInstance.label', default: 'Lenguajes'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
