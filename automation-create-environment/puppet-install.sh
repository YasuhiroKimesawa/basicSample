#!/bin/sh

sudo chmod g+w /etc/yum.repos.d
sudo cat << SETUP >> /etc/yum.repos.d/dag.repo
[dag]
name=DAG RPM Repository
baseurl=http://ftp.riken.jp/Linux/dag/redhat/el6/en/x86_64/dag/
gpgcheck=1
gpgkey=http://ftp.riken.go.jp/pub/Linux/dag/RPM-GPG-KEY.dag.txt
SETUP

sudo yum install -y ruby
sudo yum install -y augeas-libs
rpm -Uvh http://dl.fedoraproject.org/pub/epel/6/x86_64/ruby-augeas-0.4.1-1.el6.x86_64.rpm
sudo yum install -y puppet-server

 echo domain example.com >>  /etc/resolv.conf

cp -rf puppet/ /etc/
