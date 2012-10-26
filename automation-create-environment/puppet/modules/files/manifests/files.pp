class files
{
	include files::config 
}

class files::config 
{
	file 
	{ 
	  "/etc/yum.repos.d/pilgrim.lifestyle.com.repo":
        owner => "root",
        group => "root",
        mode  => "777",
        content  => template("files/pilgrim.lifestyle.com.repo")
    }

	file 
	{ 
	  "/etc/yum.repos.d/jpackage50.repo":
        owner => "root",
        group => "root",
        mode  => "777",
        content  => template("files/jpackage50.repo")
    }
}