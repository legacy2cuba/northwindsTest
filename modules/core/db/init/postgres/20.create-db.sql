-- begin EMPLOYEES
alter table employees add constraint FK_EMPLOYEES_ON_REPORTSTO foreign key (REPORTSTO) references employees(employeeid)^
create index IDX_EMPLOYEES_ON_REPORTSTO on employees (REPORTSTO)^
-- end EMPLOYEES
-- begin PRODUCTS
alter table products add constraint FK_PRODUCTS_ON_SUPPLIERID foreign key (SUPPLIERID) references suppliers(supplierid)^
alter table products add constraint FK_PRODUCTS_ON_CATEGORYID foreign key (CATEGORYID) references categories(categoryid)^
create index IDX_PRODUCTS_ON_SUPPLIERID on products (SUPPLIERID)^
create index IDX_PRODUCTS_ON_CATEGORYID on products (CATEGORYID)^
-- end PRODUCTS
-- begin ORDERS
alter table orders add constraint FK_ORDERS_ON_CUSTOMERID foreign key (CUSTOMERID) references customers(customerid)^
alter table orders add constraint FK_ORDERS_ON_EMPLOYEEID foreign key (EMPLOYEEID) references employees(employeeid)^
alter table orders add constraint FK_ORDERS_ON_SHIPVIA foreign key (SHIPVIA) references shippers(shipperid)^
create index IDX_ORDERS_ON_CUSTOMERID on orders (CUSTOMERID)^
create index IDX_ORDERS_ON_EMPLOYEEID on orders (EMPLOYEEID)^
create index IDX_ORDERS_ON_SHIPVIA on orders (SHIPVIA)^
-- end ORDERS
-- begin ORDER_DETAILS
alter table order_details add constraint FK_ORDER_DETAILS_ON_ORDERID foreign key (ORDERID) references orders(orderid)^
alter table order_details add constraint FK_ORDER_DETAILS_ON_PRODUCTID foreign key (PRODUCTID) references products(productid)^
create index IDX_ORDER_DETAILS_ON_ORDERID on order_details (ORDERID)^
create index IDX_ORDER_DETAILS_ON_PRODUCTID on order_details (PRODUCTID)^
-- end ORDER_DETAILS
-- begin ALPHABETICAL_LIST_OF_PRODUCTS
alter table alphabetical_list_of_products add constraint FK_ALPHABETICAL_LIST_OF_PRODUCTS_PRODUCTID foreign key (PRODUCTID) references products(productid)^
alter table alphabetical_list_of_products add constraint FK_ALPHABETICAL_LIST_OF_PRODUCTS_SUPPLIERID foreign key (SUPPLIERID) references suppliers(supplierid)^
alter table alphabetical_list_of_products add constraint FK_ALPHABETICAL_LIST_OF_PRODUCTS_CATEGORYID foreign key (CATEGORYID) references categories(categoryid)^
create index IDX_ALPHABETICAL_LIST_OF_PRODUCTS_PRODUCTID on alphabetical_list_of_products (PRODUCTID)^
create index IDX_ALPHABETICAL_LIST_OF_PRODUCTS_SUPPLIERID on alphabetical_list_of_products (SUPPLIERID)^
create index IDX_ALPHABETICAL_LIST_OF_PRODUCTS_CATEGORYID on alphabetical_list_of_products (CATEGORYID)^
-- end ALPHABETICAL_LIST_OF_PRODUCTS
-- begin CURRENT_PRODUCT_LIST
alter table current_product_list add constraint FK_CURRENT_PRODUCT_LIST_PRODUCTID foreign key (PRODUCTID) references products(productid)^
create index IDX_CURRENT_PRODUCT_LIST_PRODUCTID on current_product_list (PRODUCTID)^
-- end CURRENT_PRODUCT_LIST
-- begin EMPLOYEE_SALES_BY_COUNTRY
alter table employee_sales_by_country add constraint FK_EMPLOYEE_SALES_BY_COUNTRY_ORDERID foreign key (ORDERID) references orders(orderid)^
create index IDX_EMPLOYEE_SALES_BY_COUNTRY_ORDERID on employee_sales_by_country (ORDERID)^
-- end EMPLOYEE_SALES_BY_COUNTRY
-- begin INVOICES_FILTER
alter table invoices_filter add constraint FK_INVOICES_FILTER_CUSTOMERID foreign key (CUSTOMERID) references customers(customerid)^
alter table invoices_filter add constraint FK_INVOICES_FILTER_ORDERID foreign key (ORDERID) references orders(orderid)^
alter table invoices_filter add constraint FK_INVOICES_FILTER_PRODUCTID foreign key (PRODUCTID) references products(productid)^
create index IDX_INVOICES_FILTER_CUSTOMERID on invoices_filter (CUSTOMERID)^
create index IDX_INVOICES_FILTER_ORDERID on invoices_filter (ORDERID)^
create index IDX_INVOICES_FILTER_PRODUCTID on invoices_filter (PRODUCTID)^
-- end INVOICES_FILTER
-- begin INVOICES
alter table invoices add constraint FK_INVOICES_CUSTOMERID foreign key (CUSTOMERID) references customers(customerid)^
alter table invoices add constraint FK_INVOICES_ORDERID foreign key (ORDERID) references orders(orderid)^
alter table invoices add constraint FK_INVOICES_PRODUCTID foreign key (PRODUCTID) references products(productid)^
create index IDX_INVOICES_CUSTOMERID on invoices (CUSTOMERID)^
create index IDX_INVOICES_ORDERID on invoices (ORDERID)^
create index IDX_INVOICES_PRODUCTID on invoices (PRODUCTID)^
-- end INVOICES
-- begin ORDER_SUBTOTALS
alter table order_subtotals add constraint FK_ORDER_SUBTOTALS_ORDERID foreign key (ORDERID) references orders(orderid)^
create index IDX_ORDER_SUBTOTALS_ORDERID on order_subtotals (ORDERID)^
-- end ORDER_SUBTOTALS
-- begin ORDERS_QRY
alter table orders_qry add constraint FK_ORDERS_QRY_ORDERID foreign key (ORDERID) references orders(orderid)^
alter table orders_qry add constraint FK_ORDERS_QRY_CUSTOMERID foreign key (CUSTOMERID) references customers(customerid)^
alter table orders_qry add constraint FK_ORDERS_QRY_EMPLOYEEID foreign key (EMPLOYEEID) references employees(employeeid)^
alter table orders_qry add constraint FK_ORDERS_QRY_SHIPVIA foreign key (SHIPVIA) references shippers(shipperid)^
create index IDX_ORDERS_QRY_ORDERID on orders_qry (ORDERID)^
create index IDX_ORDERS_QRY_CUSTOMERID on orders_qry (CUSTOMERID)^
create index IDX_ORDERS_QRY_EMPLOYEEID on orders_qry (EMPLOYEEID)^
create index IDX_ORDERS_QRY_SHIPVIA on orders_qry (SHIPVIA)^
-- end ORDERS_QRY
-- begin ORDER_DETAILS_EXTENDED
alter table order_details_extended add constraint FK_ORDER_DETAILS_EXTENDED_ORDERID foreign key (ORDERID) references orders(orderid)^
alter table order_details_extended add constraint FK_ORDER_DETAILS_EXTENDED_PRODUCTID foreign key (PRODUCTID) references products(productid)^
create index IDX_ORDER_DETAILS_EXTENDED_ORDERID on order_details_extended (ORDERID)^
create index IDX_ORDER_DETAILS_EXTENDED_PRODUCTID on order_details_extended (PRODUCTID)^
-- end ORDER_DETAILS_EXTENDED
-- begin QUARTERLY_ORDERS_BY_PRODUCT
alter table quarterly_orders_by_product add constraint FK_QUARTERLY_ORDERS_BY_PRODUCT_CUSTOMERID foreign key (CUSTOMERID) references customers(customerid)^
create index IDX_QUARTERLY_ORDERS_BY_PRODUCT_CUSTOMERID on quarterly_orders_by_product (CUSTOMERID)^
-- end QUARTERLY_ORDERS_BY_PRODUCT
-- begin QUARTERLY_ORDERS
alter table quarterly_orders add constraint FK_QUARTERLY_ORDERS_CUSTOMERID foreign key (CUSTOMERID) references customers(customerid)^
create index IDX_QUARTERLY_ORDERS_CUSTOMERID on quarterly_orders (CUSTOMERID)^
-- end QUARTERLY_ORDERS
-- begin SALES_BY_CATEGORY
alter table sales_by_category add constraint FK_SALES_BY_CATEGORY_CATEGORYID foreign key (CATEGORYID) references categories(categoryid)^
create index IDX_SALES_BY_CATEGORY_CATEGORYID on sales_by_category (CATEGORYID)^
-- end SALES_BY_CATEGORY
-- begin SALES_BY_YEAR
alter table sales_by_year add constraint FK_SALES_BY_YEAR_ORDERID foreign key (ORDERID) references orders(orderid)^
create index IDX_SALES_BY_YEAR_ORDERID on sales_by_year (ORDERID)^
-- end SALES_BY_YEAR
-- begin SALES_TOTALS_BY_AMOUNT
alter table sales_totals_by_amount add constraint FK_SALES_TOTALS_BY_AMOUNT_ORDERID foreign key (ORDERID) references orders(orderid)^
create index IDX_SALES_TOTALS_BY_AMOUNT_ORDERID on sales_totals_by_amount (ORDERID)^
-- end SALES_TOTALS_BY_AMOUNT
-- begin SUMMARY_OF_SALES_BY_QUARTER
alter table summary_of_sales_by_quarter add constraint FK_SUMMARY_OF_SALES_BY_QUARTER_ORDERID foreign key (ORDERID) references orders(orderid)^
create index IDX_SUMMARY_OF_SALES_BY_QUARTER_ORDERID on summary_of_sales_by_quarter (ORDERID)^
-- end SUMMARY_OF_SALES_BY_QUARTER
-- begin SUMMARY_OF_SALES_BY_YEAR
alter table summary_of_sales_by_year add constraint FK_SUMMARY_OF_SALES_BY_YEAR_ORDERID foreign key (ORDERID) references orders(orderid)^
create index IDX_SUMMARY_OF_SALES_BY_YEAR_ORDERID on summary_of_sales_by_year (ORDERID)^
-- end SUMMARY_OF_SALES_BY_YEAR
