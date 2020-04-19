------------------------------------------------------------------------------
-- this is coffeadmin sql file for postgresql 				    --
-- it may sends some warnings but makes the right tables		    --
-- dont forget to create manually user password and a db named coffee	    --
------------------------------------------------------------------------------


    alter table ca_files 
        drop constraint FKDF3BEB56CEE4F181;

    alter table ca_groups 
        drop constraint FKA76C4D5CEC988C1;

    alter table ca_worker 
        drop constraint FK259B3E7FF1B49F25;

    alter table ca_workers 
        drop constraint FK8DCC91D4CEE4F181;

    alter table ca_workers 
        drop constraint FK8DCC91D4C09216E4;

    alter table ca_works 
        drop constraint FKE02E4C61CEC988C1;

    alter table ca_works 
        drop constraint FKE02E4C613E41E6C5;

    drop table ca_contacts;

    drop table ca_files;

    drop table ca_groups;

    drop table ca_users;

    drop table ca_worker;

    drop table ca_workers;

    drop table ca_works;

    drop sequence hibernate_sequence;

    create table ca_contacts (
        idcontact int4 not null,
        title varchar(30),
        fname varchar(30),
        lname varchar(30),
        email varchar(30),
        corp varchar(30),
        primary key (idcontact)
    );

    create table ca_files (
        idwork int4 not null,
        filename varchar(255)
    );

    create table ca_groups (
        idgroup int4 not null,
        description varchar(30),
        iduser int4,
        primary key (idgroup)
    );

    create table ca_users (
        iduser int4 not null,
        fname varchar(30),
        lname varchar(30),
        email varchar(30),
        title varchar(30),
        depmt varchar(30),
        corp varchar(30),
        password varchar(30),
        primary key (iduser)
    );

    create table ca_worker (
        idworker int4 not null,
        fname varchar(30),
        lname varchar(30),
        email varchar(30),
        depmt varchar(30),
        idgroup int4,
        primary key (idworker)
    );

    create table ca_workers (
        idworker int4 not null,
        idwork int4 not null
    );

    create table ca_works (
        idwork int4 not null,
        content varchar(30),
        iduser int4 not null,
        idcontact int4 not null,
        init date,
        endw date,
        status varchar(20),
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
