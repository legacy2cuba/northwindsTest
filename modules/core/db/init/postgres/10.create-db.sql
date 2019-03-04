-- begin CATEGORIES
create table categories (
    categoryid integer,
    --
    categoryname varchar(15),
    description varchar(40000),
    picture bytea,
    --
    primary key (categoryid)
)^
-- end CATEGORIES
-- begin CUSTOMERS
create table customers (
    customerid varchar(5),
    --
    companyname varchar(40),
    contactname varchar(30),
    contacttitle varchar(30),
    address varchar(60),
    city varchar(15),
    region varchar(15),
    postalcode varchar(10),
    country varchar(15),
    phone varchar(24),
    fax varchar(24),
    --
    primary key (customerid)
)^
-- end CUSTOMERS
-- begin EMPLOYEES
create table employees (
    employeeid integer,
    --
    lastname varchar(20),
    firstname varchar(10),
    title varchar(30),
    titleofcourtesy varchar(50),
    birthdate timestamp,
    hiredate timestamp,
    address varchar(60),
    city varchar(15),
    region varchar(15),
    postalcode varchar(10),
    country varchar(15),
    homephone varchar(24),
    extension varchar(4),
    photo bytea,
    notes varchar(40000),
    reportsto integer,
    --
    primary key (employeeid)
)^
-- end EMPLOYEES
-- begin SHIPPERS
create table shippers (
    shipperid integer,
    --
    companyname varchar(40),
    phone varchar(24),
    --
    primary key (shipperid)
)^
-- end SHIPPERS
-- begin SUPPLIERS
create table suppliers (
    supplierid integer,
    --
    companyname varchar(40),
    contactname varchar(30),
    contacttitle varchar(30),
    address varchar(60),
    city varchar(15),
    region varchar(15),
    postalcode varchar(10),
    country varchar(15),
    phone varchar(24),
    fax varchar(24),
    homepage varchar(40000),
    --
    primary key (supplierid)
)^
-- end SUPPLIERS
-- begin PRODUCTS
create table products (
    productid integer,
    --
    productname varchar(40),
    supplierid integer,
    categoryid integer,
    quantityperunit varchar(20),
    unitprice double precision,
    unitsinstock integer,
    unitsonorder integer,
    reorderlevel integer,
    discontinued boolean,
    --
    primary key (productid)
)^
-- end PRODUCTS
-- begin ORDERS
create table orders (
    orderid integer,
    --
    customerid varchar(5),
    employeeid integer,
    orderdate timestamp,
    requireddate timestamp,
    shippeddate timestamp,
    shipvia integer,
    freight double precision,
    shipname varchar(40),
    shipaddress varchar(60),
    shipcity varchar(15),
    shipregion varchar(15),
    shippostalcode varchar(10),
    shipcountry varchar(15),
    --
    primary key (orderid)
)^
-- end ORDERS
-- begin ORDER_DETAILS
create table order_details (
    id uuid,
    --
    orderid integer,
    productid integer,
    unitprice double precision,
    quantity integer,
    discount double precision,
    --
    primary key (id)
)^
-- end ORDER_DETAILS
-- begin ALPHABETICAL_LIST_OF_PRODUCTS
create table alphabetical_list_of_products (
    rownum bigint,
    --
    productid integer,
    productname varchar(40),
    supplierid integer,
    categoryid integer,
    quantityperunit varchar(20),
    unitprice double precision,
    unitsinstock integer,
    unitsonorder integer,
    reorderlevel integer,
    discontinued boolean,
    categoryname varchar(15),
    --
    primary key (rownum)
)^
-- end ALPHABETICAL_LIST_OF_PRODUCTS
-- begin CATEGORY_SALES_FOR_1997
create table category_sales_for_1997 (
    rownum bigint,
    --
    categoryname varchar(15),
    categorysales double precision,
    --
    primary key (rownum)
)^
-- end CATEGORY_SALES_FOR_1997
-- begin CURRENT_PRODUCT_LIST
create table current_product_list (
    rownum bigint,
    --
    productid integer,
    productname varchar(40),
    --
    primary key (rownum)
)^
-- end CURRENT_PRODUCT_LIST
-- begin CUSTOMERS_AND_SUPPLIERS_BY_CITY
create table customers_and_suppliers_by_city (
    rownum bigint,
    --
    city varchar(15),
    companyname varchar(40),
    contactname varchar(30),
    relationship text,
    --
    primary key (rownum)
)^
-- end CUSTOMERS_AND_SUPPLIERS_BY_CITY
-- begin EMPLOYEE_SALES_BY_COUNTRY
create table employee_sales_by_country (
    rownum bigint,
    --
    country varchar(15),
    lastname varchar(20),
    firstname varchar(10),
    shippeddate timestamp,
    orderid integer,
    saleamount double precision,
    --
    primary key (rownum)
)^
-- end EMPLOYEE_SALES_BY_COUNTRY
-- begin INVOICES_FILTER
create table invoices_filter (
    rownum bigint,
    --
    shipname varchar(40),
    shipaddress varchar(60),
    shipcity varchar(15),
    shipregion varchar(15),
    shippostalcode varchar(10),
    shipcountry varchar(15),
    customerid varchar(5),
    companyname varchar(40),
    address varchar(60),
    city varchar(15),
    region varchar(15),
    postalcode varchar(10),
    country varchar(15),
    salesperson text,
    orderid integer,
    orderdate timestamp,
    requireddate timestamp,
    shippeddate timestamp,
    shippers_companyname varchar(40),
    productid integer,
    productname varchar(40),
    unitprice double precision,
    quantity integer,
    discount double precision,
    extendedprice varchar(40),
    freight double precision,
    --
    primary key (rownum)
)^
-- end INVOICES_FILTER
-- begin INVOICES
create table invoices (
    rownum bigint,
    --
    shipname varchar(40),
    shipaddress varchar(60),
    shipcity varchar(15),
    shipregion varchar(15),
    shippostalcode varchar(10),
    shipcountry varchar(15),
    customerid varchar(5),
    companyname varchar(40),
    address varchar(60),
    city varchar(15),
    region varchar(15),
    postalcode varchar(10),
    country varchar(15),
    salesperson text,
    orderid integer,
    orderdate timestamp,
    requireddate timestamp,
    shippeddate timestamp,
    shippers_companyname varchar(40),
    productid integer,
    productname varchar(40),
    unitprice double precision,
    quantity integer,
    discount double precision,
    extendedprice varchar(40),
    freight double precision,
    --
    primary key (rownum)
)^
-- end INVOICES
-- begin ORDER_SUBTOTALS
create table order_subtotals (
    rownum bigint,
    --
    orderid integer,
    subtotal double precision,
    --
    primary key (rownum)
)^
-- end ORDER_SUBTOTALS
-- begin ORDERS_QRY
create table orders_qry (
    rownum bigint,
    --
    orderid integer,
    customerid varchar(5),
    employeeid integer,
    orderdate timestamp,
    requireddate timestamp,
    shippeddate timestamp,
    shipvia integer,
    freight double precision,
    shipname varchar(40),
    shipaddress varchar(60),
    shipcity varchar(15),
    shipregion varchar(15),
    shippostalcode varchar(10),
    shipcountry varchar(15),
    companyname varchar(40),
    address varchar(60),
    city varchar(15),
    region varchar(15),
    postalcode varchar(10),
    country varchar(15),
    --
    primary key (rownum)
)^
-- end ORDERS_QRY
-- begin ORDER_DETAILS_EXTENDED
create table order_details_extended (
    rownum bigint,
    --
    orderid integer,
    productid integer,
    productname varchar(40),
    unitprice double precision,
    quantity integer,
    discount double precision,
    extendedprice varchar(40),
    --
    primary key (rownum)
)^
-- end ORDER_DETAILS_EXTENDED
-- begin PRODUCTS_ABOVE_AVERAGE_PRICE
create table products_above_average_price (
    rownum bigint,
    --
    productname varchar(40),
    unitprice double precision,
    --
    primary key (rownum)
)^
-- end PRODUCTS_ABOVE_AVERAGE_PRICE
-- begin PRODUCTS_BY_CATEGORY
create table products_by_category (
    rownum bigint,
    --
    categoryname varchar(15),
    productname varchar(40),
    quantityperunit varchar(20),
    unitsinstock integer,
    discontinued boolean,
    --
    primary key (rownum)
)^
-- end PRODUCTS_BY_CATEGORY
-- begin PRODUCT_SALES_FOR_1997
create table product_sales_for_1997 (
    rownum bigint,
    --
    categoryname varchar(15),
    productname varchar(40),
    productsales double precision,
    shippedquarter text,
    --
    primary key (rownum)
)^
-- end PRODUCT_SALES_FOR_1997
-- begin QUARTERLY_ORDERS_BY_PRODUCT
create table quarterly_orders_by_product (
    rownum bigint,
    --
    productname varchar(40),
    customerid varchar(5),
    orderyear varchar(40),
    qtr_1 double precision,
    qtr_2 double precision,
    qtr_3 double precision,
    qtr_4 double precision,
    --
    primary key (rownum)
)^
-- end QUARTERLY_ORDERS_BY_PRODUCT
-- begin QUARTERLY_ORDERS
create table quarterly_orders (
    rownum bigint,
    --
    customerid varchar(5),
    companyname varchar(40),
    city varchar(15),
    country varchar(15),
    --
    primary key (rownum)
)^
-- end QUARTERLY_ORDERS
-- begin SALES_BY_CATEGORY
create table sales_by_category (
    rownum bigint,
    --
    categoryid integer,
    categoryname varchar(15),
    productname varchar(40),
    productsales double precision,
    --
    primary key (rownum)
)^
-- end SALES_BY_CATEGORY
-- begin SALES_BY_YEAR
create table sales_by_year (
    rownum bigint,
    --
    shippeddate timestamp,
    orderid integer,
    subtotal double precision,
    year varchar(40),
    --
    primary key (rownum)
)^
-- end SALES_BY_YEAR
-- begin SALES_TOTALS_BY_AMOUNT
create table sales_totals_by_amount (
    rownum bigint,
    --
    saleamount double precision,
    orderid integer,
    companyname varchar(40),
    shippeddate timestamp,
    --
    primary key (rownum)
)^
-- end SALES_TOTALS_BY_AMOUNT
-- begin SUMMARY_OF_SALES_BY_QUARTER
create table summary_of_sales_by_quarter (
    rownum bigint,
    --
    shippeddate timestamp,
    orderid integer,
    subtotal double precision,
    --
    primary key (rownum)
)^
-- end SUMMARY_OF_SALES_BY_QUARTER
-- begin SUMMARY_OF_SALES_BY_YEAR
create table summary_of_sales_by_year (
    rownum bigint,
    --
    shippeddate timestamp,
    orderid integer,
    subtotal double precision,
    --
    primary key (rownum)
)^
-- end SUMMARY_OF_SALES_BY_YEAR
-- begin TEN_MOST_EXPENSIVE_PRODUCTS
create table ten_most_expensive_products (
    rownum bigint,
    --
    tenmostexpensiveproducts varchar(40),
    unitprice double precision,
    --
    primary key (rownum)
)^
-- end TEN_MOST_EXPENSIVE_PRODUCTS
