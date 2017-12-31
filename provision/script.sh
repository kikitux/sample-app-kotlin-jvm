#!/usr/bin/env bash
set -e

service oracle-xe configure responseFile=/vagrant/provision/xe.rsp
usermod -a -G vagrant oracle

BP=/home/oracle/.bash_profile # oracle .bash_profile
XEE=/vagrant/provision/xe.env # oracle xe environment

grep ${XEE} /home/oracle/.bash_profile || {
  echo "source ${XEE}" | tee -a ${BP}
}
