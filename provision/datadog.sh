#!/usr/bin/env bash

envfile=provision/datadog.env

if [ -f /vagrant/${envfile} ]; then
  source /vagrant/${envfile}
  bash -c "$(curl -L https://raw.githubusercontent.com/DataDog/dd-agent/master/packaging/datadog-agent/source/install_agent.sh)"
else
  echo "err: please create file ${envfile} with 'export DD_API_KEY=<yourkey>'"
fi

#pip
which pip 2>/dev/null || yum install -y python27-python-pip.noarch

P27E=/opt/rh/python27/enable
source ${P27E}
pip install --upgrade pip

#xe db environment
XEE=/vagrant/provision/xe.env
source ${XEE}

#install cx_Oracle
python -m pip install cx_Oracle --upgrade

BP=/home/oracle/.bash_profile
grep ${BP} ${P27E} || {
  echo "source ${P27E}" | tee -a ${BP}
}
