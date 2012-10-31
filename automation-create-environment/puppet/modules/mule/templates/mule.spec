%define _binaries_in_noarch_packages_terminate_build 0
%define installdir /usr/local/mule
%define debug_package %{nil}
%define __os_install_post %{nil}

Summary: Mule ESB
Name: mule
Version: 3.3.0
Release: 1
URL: http://www.mulesoft.org/
Vendor: Mule Soft
Source0: http://dist.codehaus.org/mule/distributions/mule-standalone-%{version}.tar.gz
License: Common Public Attribution License
Group: Networking/Daemons
BuildRoot: %{_tmppath}/%{name}-root
BuildArch: noarch

%description
mule ESB

%prep
%setup -q -n mule-standalone-%{version}

%build

%install
rm -rf $RPM_BUILD_ROOT
mkdir -p $RPM_BUILD_ROOT%{installdir}
cp -pr * $RPM_BUILD_ROOT%{installdir}

%pre

%post
sudo cp -p %{installdir}/mule /etc/rc.d/init.d/mule

chmod +x /etc/rc.d/init.d/mule
sudo chkconfig --add mule
sudo chkconfig mule on

%preun
sudo rm -rf /etc/rc.d/init.d/mule

%clean
rm -rf $RPM_BUILD_ROOT

%files
%defattr(-,root,root)

%dir %{installdir}/
%{installdir}/apps
%{installdir}/bin
%{installdir}/conf
%{installdir}/docs
%{installdir}/examples
%{installdir}/lib
%{installdir}/LICENSE.txt
%{installdir}/logs
%{installdir}/mule
%{installdir}/README.txt
%{installdir}/src
