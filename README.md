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

# general info

base oracle db is created by using [packer-oraclelinux-ovf](https://github.com/kikitux/packer-oraclelinux-ovf) repo
then using vagrant we will start our own oracle db that will be available on port 1521 of the localhost


# todo
[] base oracledb
[] local project Vagrantfile
[] base oracledb schema
[] simple grapql app


