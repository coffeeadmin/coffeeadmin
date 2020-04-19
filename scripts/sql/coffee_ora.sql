------------------------------------------------------------------------------
-- this is coffeadmin sql file for oracle 8				    --
-- it may sends some warnings but makes the right tables		    --
-- dont forget to create manually user password and a db named coffee	    --
------------------------------------------------------------------------------


    drop table ca_contacts cascade constraints;

    drop table ca_files cascade constraints;

    drop table ca_groups cascade constraints;

    drop table ca_users cascade constraints;

    drop table ca_worker cascade constraints;

    drop table ca_workers cascade constraints;

    drop table ca_works cascade constraints;

    drop sequence hibernate_sequence;

    create table ca_contacts (
        idcontact number(10,0) not null,
        title varchar2(30),
        fname varchar2(30),
        lname varchar2(30),
        email varchar2(30),
        corp varchar2(30),
        primary key (idcontact)
    );

    create table ca_files (
        idwork number(10,0) not null,
        filename varchar2(255)
    );

    create table ca_groups (
        idgroup number(10,0) not null,
        description varchar2(30),
        iduser number(10,0),
        primary key (idgroup)
    );

    create table ca_users (
        iduser number(10,0) not null,
        fname varchar2(30),
        lname varchar2(30),
        email varchar2(30),
        title varchar2(30),
        depmt varchar2(30),
        corp varchar2(30),
        password varchar2(30),
        primary key (iduser)
    );

    create table ca_worker (
        idworker number(10,0) not null,
        fname varchar2(30),
        lname varchar2(30),
        email varchar2(30),
        depmt varchar2(30),
        idgroup number(10,0),
        primary key (idworker)
    );

    create table ca_workers (
        idworker number(10,0) not null,
        idwork number(10,0) not null
    );

    create table ca_works (
        idwork number(10,0) not null,
        content varchar2(30),
        iduser number(10,0) not null,
        idcontact number(10,0) not null,
        init date,
        endw date,
        status varchar2(20),
        primary key (idwork)
    );

    alter table ca_files 
        add constraint FKDF3BEB56CEE4F181 
        foreign key (idwork) 
        references ca_works;

    create index user_index on ca_groups (iduser);

    alter table ca_groups 
        add constraint FKA76C4D5CEC988C1 
        foreign key (iduser) 
        references ca_users 
        on delete cascade;

    create index user_index on ca_users (fname);

    create index group_index on ca_worker (idgroup);

    alter table ca_worker 
        add constraint FK259B3E7FF1B49F25 
        foreign key (idgroup) 
        references ca_groups 
        on delete cascade;

    alter table ca_workers 
        add constraint FK8DCC91D4CEE4F181 
        foreign key (idwork) 
        references ca_works;

    alter table ca_workers 
        add constraint FK8DCC91D4C09216E4 
        foreign key (idworker) 
        references ca_worker;

    alter table ca_works 
        add constraint FKE02E4C61CEC988C1 
        foreign key (iduser) 
        references ca_users;

    alter table ca_works 
        add constraint FKE02E4C613E41E6C5 
        foreign key (idcontact) 
        references ca_contacts 
        on delete cascade;

    create sequence hibernate_sequence;
