create table Products
(
    article_id  LONG auto_increment,
    variant_id  LONG        not null,
    name        VARCHAR(50) not null,
    description VARCHAR(200),
    constraint PRODUCTS_PK
        primary key (article_id, variant_id)
);

INSERT INTO Products (article_id, variant_id, name) VALUES (1, 1, 'T-Shirt');
INSERT INTO Products (article_id, variant_id, name) VALUES (1, 2, 'T-Shirt');
INSERT INTO Products (article_id, variant_id, name) VALUES (1, 3, 'T-Shirt');
INSERT INTO Products (article_id, variant_id, name) VALUES (1, 4, 'T-Shirt');
