drop if exists table book_detail;
CREATE TABLE book_detail (
seqno bigint NOT NULL AUTO_INCREMENT ,
catagory_tag  varchar(30),
catagory_tag_main char(10),
catagory_tag_side char(10),
update_date_yyyy  char(4),
update_date_mm    char(2),
update_date_dd    char(2),
update_date varchar(20),
book_url  varchar(200),
book_name  varchar(200),
book_desc  varchar(3000),
enter_date  datetime NOT NULL DEFAULT NOW(),
down_url  varchar(300),
down_pwd  varchar(100),
image_path  varchar(100),
file_path  varchar(1000),
download_flag char(1) NOT NULL DEFAULT 'N',
book_star  char(1),
PRIMARY KEY (seqno)
)ENGINE=InnoDB CHARSET='utf8';

drop VIEW book_statics_view;
CREATE VIEW book_statics_view as SELECT update_date_yyyy,update_date_mm,count(*) as count
                                 from book_detail GROUP BY update_date_yyyy,update_date_mm;

INSERT INTO book_detail(catagory_tag,update_date,book_url,book_name,book_desc,enter_date,down_url,down_pwd,image_path,file_path,download_flag) SELECT catagory_tag,update_date,book_url,book_name,book_desc,enter_date,down_url,down_pwd,image_path,file_path,download_flag from book LIMIT 13,10;
