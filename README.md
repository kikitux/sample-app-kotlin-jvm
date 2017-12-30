# sample-app-graphql
repository for our same app that will create a graphql endpoint

# pre-requirements
- make
- packer
- virtualbox
- vagrant

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

download ojdbc8.jar](http://www.oracle.com/technetwork/database/features/jdbc/jdbc-ucp-122-3110062.html) and leave a copy in `src\demo`

TL;DR

```
cd src\demo
mvn install:install-file -Dfile=ojdbc8.jar -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1 -Dpackaging=jar
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
```


# general info

base oracle db is created by using [packer-oraclelinux-ovf](https://github.com/kikitux/packer-oraclelinux-ovf) repo
then using vagrant we will start our own oracle db that will be available on port 1521 of the localhost

use `sys` and `system` have the password of `Password1` defined in the db configuration file `provision/xe.rsp`.

# todo
[] base oracledb schema
[] simple grapql app
[x] base oracledb
[x] local project Vagrantfile


