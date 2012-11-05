%define _binaries_in_noarch_packages_terminate_build 0
%define installdir /usr/local/james
%define debug_package %{nil}
%define __os_install_post %{nil}

Summary: Apache James
Name: james
Version: 3.0
Release: beta4
URL: http://james.apache.org/
Vendor: Apache Software Foundation
Source0: http://ftp.meisei-u.ac.jp/mirror/apache/dist//james/apache-james/%{version}%{release}/apache-james-%{version}-%{release}-app.tar.gz
License: Apache software License
Group: Networking/Daemons
BuildRoot: %{_tmppath}/%{name}-root
BuildArch: noarch

%description
james

%prep
%setup -q -n apache-james-%{version}-%{release}

%build

%install
rm -rf $RPM_BUILD_ROOT
mkdir -p $RPM_BUILD_ROOT%{installdir}
cp -pr * $RPM_BUILD_ROOT%{installdir}

%pre

%post

%preun

%clean
rm -rf $RPM_BUILD_ROOT

%files
%defattr(-,root,root)

%dir %{installdir}/
%{installdir}/bin
%{installdir}/conf
%{installdir}/lib
%{installdir}/LICENSE
%{installdir}/log
%{installdir}/NOTICE
%{installdir}/README.crypto
%{installdir}/README.txt
%{installdir}/var
%{installdir}/james
