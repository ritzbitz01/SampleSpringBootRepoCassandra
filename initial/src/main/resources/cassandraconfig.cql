CREATE KEYSPACE IF NOT EXISTS ryangreeting WITH replication = { 'class' : 'SimpleStrategy', 'replication_factor' : 1};

CREATE TABLE IF NOT EXISTS ryangreeting . greeting (id bigint, content text, PRIMARY KEY ( id));

CREATE TABLE IF NOT EXISTS ryangreeting . course (key varchar, course_book_id varchar, course_code varchar, title varchar, description varchar, thumnail varchar, start_date timestamp, end_date timestamp, ams_calendar_id varchar, author varchar, created_at timestamp, updated_at timestamp, version int, metadata_map varchar, socrates_id varchar, course_status varchar, registrar_course_id varchar, course_ready_message_id varchar, PRIMARY KEY( key ));