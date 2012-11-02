%define _binaries_in_noarch_packages_terminate_build 0
%define installdir /usr/local/activemq
%define debug_package %{nil}
%define __os_install_post %{nil}

Summary: Apache Active MQ
Name: activemq
Version: 5.7.0
Release: 1
URL: http://activemq.apache.org/
Vendor: Apache Software Foundation
Source0: http://ftp.meisei-u.ac.jp/mirror/apache/dist/activemq/apache-activemq/${version}/apache-activemq-%{version}-bin.tar.gz
License: Apache software License
Group: Networking/Daemons
BuildRoot: %{_tmppath}/%{name}-root
BuildArch: noarch

%description
Apache Active MQ

%prep
%setup -q -n apache-activemq-%{version}

%build

%install
rm -rf $RPM_BUILD_ROOT
mkdir -p $RPM_BUILD_ROOT%{installdir}
cp -pr * $RPM_BUILD_ROOT%{installdir}
%pre
%post
sudo cp -p %{installdir}/activemq /etc/rc.d/init.d/activemq
chmod +x /etc/rc.d/init.d/activemq
sudo chkconfig --add activemq
sudo chkconfig activemq on

%preun
sudo rm -rf /etc/rc.d/init.d/activemq
%clean
rm -rf $RPM_BUILD_ROOT

%files
%defattr(-,root,root)
%dir %{installdir}/
%{installdir}/bin
%{installdir}/data
%{installdir}/example
%{installdir}/LICENSE
%{installdir}/README.txt
%{installdir}/webapps
%{installdir}/activemq-all-5.7.0.jar
%{installdir}/conf
%{installdir}/docs
%{installdir}/lib
%{installdir}/NOTICE
%{installdir}/user-guide.html
%{installdir}/WebConsole-README.txt
%{installdir}/activemq
