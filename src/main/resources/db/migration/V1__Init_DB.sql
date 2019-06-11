create table questions (id bigint not null auto_increment, answer varchar(255), quest_number integer not null, test_id bigint not null, primary key (id)) engine=InnoDB;
create table student_success (id bigint not null auto_increment, quest_number integer not null, status varchar(255), write_answer integer not null, wrong_answer integer not null, test_id bigint not null, user_id bigint not null, primary key (id)) engine=InnoDB;
create table test (id bigint not null, name varchar(255), need_answer_numb integer not null, quest_number integer not null, theme varchar(255), primary key (id)) engine=InnoDB;
create table users (id bigint not null, account_status bit not null, email varchar(255), password varchar(255), role varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
alter table questions add constraint FKbpeck5iqmq0culcc699xmhsbo foreign key (test_id) references test (id);
alter table student_success add constraint FKqcquytov3enuh5p7p9c6l2dwx foreign key (test_id) references test (id);
alter table student_success add constraint FKqm86vth9yktobilr4fxp2odbf foreign key (user_id) references users (id);