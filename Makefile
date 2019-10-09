#!make

build:
	@docker image build -t inkimar/uploader:v0.3 dockerfile

list-image:
	@docker images | grep inkimar
		
start-up:
	@docker container run -it --publish 8081:8080 inkimar/uploader:latest

start-browser:
	xdg-open http://localhost:8081/ &

start-uploader:
	xdg-open http://localhost:8081/BioUpload/ &

# https://stackoverflow.com/questions/12667797/using-curl-to-upload-post-data-with-files
post-curl:
	curl -i -H "Content-Type: multipart/form-data" -X POST -d @testbild.jpg http://127.0.0.1:8080/BioUploadv0.2/rest/upload

post-binary:
	@curl -v  -F 'file=@./self-testing/dragon.gif' ${HOST}/rest/upload

# extra
test-barebone:
	@docker run -it --rm -p 8888:8080 tomcat:8.5-jdk8 bash