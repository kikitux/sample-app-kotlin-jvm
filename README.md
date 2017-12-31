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

download ojdbc8.jar](http://www.oracle.com/technetwork/database/features/jdbc/jdbc-ucp-122-3110062.html) and leave a copy in `src\demo\dep`

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

# general info

base oracle db is created by using [packer-oraclelinux-ovf](https://github.com/kikitux/packer-oraclelinux-ovf) repo
then using vagrant we will start our own oracle db that will be available on port 1521 of the localhost

use `sys` and `system` have the password of `Password1` defined in the db configuration file `provision/xe.rsp`.

# todo
[] datadog
[] base oracledb schema
[] base rest api for stock
[] events
[] simple grapql app
[x] base oracledb
[x] local project Vagrantfile
[x] db configuration
[x] initial Controller + tests

