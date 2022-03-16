create table customer
(
	id serial
		constraint customer_pk
			primary key,
	name varchar not null,
	document varchar not null
);

create unique index customer_document_uindex
	on customer (document);

create index customer_name_index
	on customer (name);
