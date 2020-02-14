create table clients(
	id bigserial primary key,
	name varchar(128) not null,
	age integer not null
);

create table products(
	id bigserial primary key,
	name varchar(256) not null,
	sku varchar(64)
);

create table orders(
	id bigserial primary key,
	client_id bigint not null
);

create table product_order(
	product_id bigint not null,
	order_id bigint not null,
	foreign key(product_id) references products(id),
	foreign key(order_id) references orders(id)
);

-- select orders with product numbers
select o.id, count(po.product_id) 
from orders o 
join product_order po on (o.id = po.order_id)
group by (o.id);

