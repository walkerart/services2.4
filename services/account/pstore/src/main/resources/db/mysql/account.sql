alter table tenants drop foreign key FKAAE82D09C4F08FD6;
drop table if exists accounts_common;
drop table if exists tenants;
create table accounts_common (csid varchar(255) not null, email longtext not null, mobile varchar(255), phone varchar(255), screen_name varchar(128) not null, status varchar(15) not null, userid longtext not null, primary key (csid));
create table tenants (HJID bigint not null auto_increment, id varchar(255) not null, name varchar(255) not null, TENANT_ACCOUNTSCOMMON_CSID varchar(255), primary key (HJID));
alter table tenants add index FKAAE82D09C4F08FD6 (TENANT_ACCOUNTSCOMMON_CSID), add constraint FKAAE82D09C4F08FD6 foreign key (TENANT_ACCOUNTSCOMMON_CSID) references accounts_common (csid);