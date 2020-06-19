from bottle import route, post, request, run
import docker

client = docker.from_env()

def translate_container(container):
    return { "id" : container.id, "name" : container.name }

@route('/api/runningconts')
def list_containers():
    returnVal = { "containers" : map(translate_container, client.containers.list()) }
    return returnVal

@post('/api/stop')
def stop_container():
    contid = request.forms.get("contid")
    for container in client.containers.list():
    	if container.id == contid:
 	    container.stop()
	    break
    returnVal = { "containers" : map(translate_container, client.containers.list()) }
    return returnVal

run(host='localhost', port=8080, debug=True)
