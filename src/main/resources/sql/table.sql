create table tbl_category(
  id int primary key auto_increment,
  category_name varchar(20),
);
create table tb_article(
        id  int primary key auto_increment,
        title varchar ,
        description   varchar ,
        author varchar ,
        image varchar ,
        create_date varchar,
        category_id int ,
        foreign key (category_id) references tbl_category(id) on delete cascade


);


INSERT INTO tbl_category(category_name)values ('Java');
INSERT INTO tbl_category(category_name)values ('Spring');
INSERT INTO tbl_category(category_name)values ('C#');
INSERT INTO tbl_category(category_name)values ('other');
