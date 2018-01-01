# sample-app-kotlin-jvm

repository for our same app that will create a graphql endpoint

# pre-requirements
- make
- packer
- virtualbox
- vagrant

Where you will run this code, we need:
- java 8

optionally intelliJ

# start
We need an oracle db so we will start with our own oracle xe db running on Vagrant

TL;DR

```
cd dep/github/kikitux/packer-oraclelinux-ovf/
make xe.box
cd ../../../../
vagrant up
```
for long explantion check [packer-oraclelinux-ovf](https://github.com/kikitux/packer-oraclelinux-ovf)

# our app

download [ojdbc8.jar](http://www.oracle.com/technetwork/database/features/jdbc/jdbc-ucp-122-3110062.html) and leave a copy in `src\demo\dep`

TL;DR

```
cd src\demo
./gradlew build
./gradlew test
./gradlew bootRun 
```

Now we can check our app.

At this stage this works:

```
curl -s 'http://localhost:8080/hello'
curl -s 'http://localhost:8080/greeting'
curl -s 'http://localhost:8080/greeting?name=World'
curl -s 'http://localhost:8080/greeting'
curl -s 'http://localhost:8080/greetingData?name=World'
curl -s 'http://localhost:8080/sysdate'
curl -s 'http://localhost:8080/dbname'
```

swagger ui is enabled, and located at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)



## endpoints

http://localhost:8080/actuator/health
http://localhost:8080/actuator/info

## runing the jar

after build we can run our application stand alone

```
JAVA_OPTS="-server -Xms4g -Xmx4g -XX:+UseG1GC -XX:MaxGCPauseMillis=100 -XX:+UseStringDeduplication"
java ${JAVA_OPTS} -Dserver.port=8080 -jar src/demo/build/libs/demo-0.0.1-SNAPSHOT.jar 
```

# monitoring
- [ ] todo datadog

## datadog

datadog can be enabled by:
- create `provision/datadog.env` with your datadog key like `export DD_API_KEY=<your_key>`
- run the optional vagrant script `vagrant provision --provision-with datadog`

this will setup datadog, and will also install [cx_Oracle](https://oracle.github.io/python-cx_Oracle) python driver

if everything went fine, you should be able to check the dashboard for your [xe vm](https://app.datadoghq.com/dash/host_name/xe?page=0&live=4h) in the [datadog dashboard](https://app.datadoghq.com)

# general info

base oracle db is created by using [packer-oraclelinux-ovf](https://github.com/kikitux/packer-oraclelinux-ovf) repo
then using vagrant we will start our own oracle db that will be available on port 1521 of the localhost

use `sys` and `system` have the password of `Password1` defined in the db configuration file `provision/xe.rsp`.

## todo
- [ ] base oracledb schema
- [ ] base rest api for stock
- [ ] events
- [ ] simple grapql app

## done
- [x] base oracledb
- [x] local project Vagrantfile
- [x] db configuration
- [x] initial Controller + tests
- [x] datadog
