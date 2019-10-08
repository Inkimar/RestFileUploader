#!make

HOST = http://localhost:8080/BioUploadv02
HOST_DOCKER = http://localhost:8081/BioUploadv03
SIZE = 1000
OUTPUT_FILE= output.json

#all: headers resize bundle post-https firefox clean
pre: headers resize bundle

# creates head.json and tail.json
headers:
	@echo -n '{"fileName":"testing.jpg","fileDataBase64":"' > head.json
	@echo -n '"}' > tail.json

# convert from gif-to-png -> Version: ImageMagick 6.9.7-4 Q16 x86_64 20170114 http://www.imagemagick.org 
resize: dragon.gif
	@convert dragon.gif -resize ${SIZE} dragon.png

# transform -> base64 using -> base64 (GNU coreutils) 8.28  (konverterar png till b64)
bundle: dragon.png
	@base64 dragon.png > dragon.b64
	@cat head.json dragon.b64 tail.json > big.b64

#	
post-binary-docker:
	@curl -v  -F 'file=@dragon.gif' ${HOST_DOCKER}/rest/upload

post-binary-local:
	@curl -v  -F 'file=@dragon.png' ${HOST}/rest/upload


    

#firefox: ${OUTPUT_FILE} 
#	./inspect-image.sh

#clean:
#	rm dragon.png dragon.b64 big.b64 head.json tail.json  ${OUTPUT_FILE}
