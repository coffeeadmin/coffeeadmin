------------------------------------------------------------------------------
-- this is coffeadmin sql file for mysql ,default config,		    --
-- it may sends some warnings but makes the right tables		    --
-- dont forget to create manually user password and a db named coffee	    --
------------------------------------------------------------------------------

CREATE TABLE ca_works (
idwork double NOT NULL auto_increment,
content char(30) default NULL,
iduser double NOT NULL,
idcontact double NOT NULL,
init date,
endw date,
status char(20),
PRIMARY KEY (idwork),
KEY (iduser),
KEY (idcontact),
KEY (init),
KEY(endw),
KEY(status)
)TYPE=MyISAM;

CREATE TABLE ca_workers (
idwork double NOT NULL,
idworker double NOT NULL,
KEY (idwork),
KEY (idworker)
)TYPE=MyISAM;




CREATE TABLE ca_contacts (
idcontact double NOT NULL auto_increment,
title char(30) default NULL,
fname char(30) default NULL,
lname char(30) default NULL,
email char(30) default NULL,
corp char(30) default NULL,
KEY (idcontact)
)TYPE=MyISAM;


CREATE TABLE ca_worker (
idworker double NOT NULL auto_increment,
fname char(30) default NULL,
lname char(30) default NULL,
email char(30) default NULL,
depmt char(30) default NULL,
idgroup double NOT NULL,  
PRIMARY KEY (idworker),
KEY (idgroup)
)TYPE=MyISAM;


CREATE TABLE ca_groups (
idgroup double NOT NULL auto_increment,
description char(30) default NULL,
iduser double NOT NULL,
PRIMARY KEY (idgroup),
KEY (iduser)
)TYPE=MyISAM;




CREATE TABLE ca_report (
name char(30) default NULL, 
description text,
template text,
KEY (name)
)TYPE=MyISAM;


CREATE TABLE ca_users (
iduser double NOT NULL auto_increment,
fname char(30) default NULL,
lname char(30) default NULL,
email char(30) default NULL,
title char(30) default NULL,
depmt char(30) default NULL,
corp char(30) default NULL,
password char(30) default NULL,
PRIMARY KEY (iduser)
)TYPE=MyISAM;


CREATE TABLE ca_files (
idwork double NOT NULL,
filename char(100),
KEY (idwork),
KEY (filename)
)TYPE=MyISAM;


