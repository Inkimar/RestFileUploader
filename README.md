# RestFileUploader
proof-of-concept, uploading files up to 6GB - 

1. deployed in Tomcat 8.0.27
2. using 'Eclipse IDE for Enterprise Java Developers.' Version   2019-03 (4.11.0)
3. - problems using netbeans version 11.1

For code explanation and additional configurations read the tutorial at https://javatutorial.net/java-file-upload-rest-service 


# deployed

1. deployed in Tomcat version 8.0.27
2. upload file -> http://localhost:8080/FileUploader/fileuploader.html 
3. after a successful uploading http://localhost:8080/FileUploader/rest/upload 

*** 
Testing the 'drewnoakes meta-extractor'-library
1. upload file -> http://localhost:8080/FileUploader/fileupload-extra.html

***

Upgraded the version of Jersey to 1.19.4
1. The restful-services are defined in the file FileUploadService.java
2. hardcoded : the 'UPLOAD_FOLDER' to point at 
2. The name of the war-file is set in the pom.xml -> ```<finalName>FileUploader</finalName>```


#Troubleshooting
if you change the package-name then you need to update the param-value to the new package in the web.xml-file

```
       <init-param>
			<param-name>com.sun.jersey.config.property.packages</param-name>
			<param-value>se.nrm.bio.attachment</param-value>
		</init-param>

```

# Creating a large file,  uploading the file using firefox.

## 2G

```
#!/bin/bash
fallocate -l 2G gentoo_root.img
```

**file before:**
1. source-dir> md5sum gentoo_root.img
2. a981130cf2b7e09f4686dc273cf7187e  gentoo_root.img

**file after:**
1. target-dir> md5sum gentoo_root.img
2. a981130cf2b7e09f4686dc273cf7187e  gentoo_root.img

**works**

## 3G

```
#!/bin/bash
fallocate -l 3G gentoo_3.img
```

**file before:**
1. source-dir> md5sum gentoo_3.img
2. c698c87fb53058d493492b61f4c74189  gentoo_3.img

**file after:**
1. target-dir> md5sum gentoo_2.img
2. c698c87fb53058d493492b61f4c74189  gentoo_3.img

**works**

## 4G

```
#!/bin/bash
fallocate -l 4G gentoo_4.img
```

**file before:**
1. source-dir> md5sum gentoo_4.img
2. c9a5a6878d97b48cc965c1e41859f034  gentoo_4.img

**file after:**
1. target-dir> md5sum gentoo_4.img
2. c9a5a6878d97b48cc965c1e41859f034  gentoo_4.img

**works**


## 5G

```
#!/bin/bash
fallocate -l 5G gentoo_5.img
```

**file before:**
1. source-dir> md5sum gentoo_5.img
2. ec4bcc8776ea04479b786e063a9ace45  gentoo_5.img

**file after:**
1. target-dir> md5sum gentoo_5.img
2. ec4bcc8776ea04479b786e063a9ace45  gentoo_5.img

**works**


## 6G

```
#!/bin/bash
fallocate -l 6G gentoo_6.img
```

**file before:**
1. source-dir> md5sum gentoo_6.img
2. 58cf638a733f919007b4287cf5396d0c  gentoo_6.img

**file after:**
1. target-dir> md5sum gentoo_6.img
2. 58cf638a733f919007b4287cf5396d0c  gentoo_6.img

# Fetching information from files.

- testing to save the information(tags) down to a file 

**Not Using the TIKA-style, too much footprint - test 'drewnoakes' **

1. Using the Apache Tika project -> https://tika.apache.org/ 
2. maven artifacts here -> https://mvnrepository.com/artifact/org.apache.tika/tika-parsers

## Image (png, jpeg, jpg)

## PDF

## ZIP

**Using drewnoakes**

1. https://github.com/drewnoakes/metadata-extractor/blob/master/Samples/com/drew/metadata/SampleUsage.java
2. Metadata metadata = ImageMetadataReader.readMetadata(inputStream);



## Image (png,jpeg)

test jpeg

``` 
[JPEG] Compression Type - Progressive, Huffman[JPEG] Data Precision - 8 bits[JPEG] Image Height - 633 pixels[JPEG] Image Width - 511 pixels[JPEG] Number of Components - 3[JPEG] Component 1 - Y component: Quantization table 0, Sampling factors 2 horiz/2 vert[JPEG] Component 2 - Cb component: Quantization table 1, Sampling factors 1 horiz/1 vert[JPEG] Component 3 - Cr component: Quantization table 1, Sampling factors 1 horiz/1 vert[JFIF] Version - 1.1[JFIF] Resolution Units - none[JFIF] X Resolution - 1 dot[JFIF] Y Resolution - 1 dot[JFIF] Thumbnail Width Pixels - 0[JFIF] Thumbnail Height Pixels - 0[IPTC] Special Instructions - FBMD0f000758010000aa1500008d31000057370000e83c0000ea410000f28f000093920000[Huffman] Number of Tables - 2 Huffman tables[File Type] Detected File Type Name - JPEG[File Type] Detected File Type Long Name - Joint Photographic Experts Group[File Type] Detected MIME Type - image/jpeg[File Type] Expected File Name Extension - jpg
 ```

**Q:**

1. kan jag spara denna data annorlunda ? 
2. kan jag hämta ut 'MIME Type'

## PDF

## ZIP

test zip

```
[File Type] Detected File Type Name - ZIP[File Type] Detected File Type Long Name - ZIP Archive[File Type] Detected MIME Type - application/zip[File Type] Expected File Name Extension - .zip 
```

# Jersey test

1. https://www.javaguides.net/2018/06/how-to-test-jersey-rest-api-with-junit.html
2. https://www.javaguides.net/p/jersey-rest.html
3. https://github.com/RameshMF/jersey-tutorial


