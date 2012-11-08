%define _binaries_in_noarch_packages_terminate_build 0
%define installdir /usr/local/h2
%define debug_package %{nil}
%define __os_install_post %{nil}

Summary: H2 DatabaseEngine
Name: h2
Version: 1.3
Release: 167
URL: http://tomcat.apache.org/
Vendor: Apache Software Foundation
Source0: h2-%{version}.%{release}.tar.gz
License: MPL EPL
Group: Networking/Daemons
BuildArch: noarch
BuildRoot: %{_tmppath}/%{name}-root

%description
h2

%prep
%setup -q -n h2

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
%{installdir}/build.bat
%{installdir}/build.sh
%{installdir}/docs
%{installdir}/service
%{installdir}/src
