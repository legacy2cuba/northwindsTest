alter table order_details add column ID uuid ^
update order_details set ID = newid() where ID is null ;
alter table order_details alter column ID set not null ;
